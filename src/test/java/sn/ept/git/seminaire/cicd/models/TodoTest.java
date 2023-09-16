package sn.ept.git.seminaire.cicd.models;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TodoTest {

    private Todo todo;

    @BeforeEach
    void setUp() {
        // Initialisez une nouvelle instance de Todo avant chaque test
        todo = new Todo();
    }

    @Test
    void testTodoConstructor() {
        assertNotNull(todo, "Todo instance should not be null");
    }

    @Test
    void testTodoProperties() {
        // Définissez des propriétés pour la Todo
        todo.setTitle("Test Title");
        todo.setDescription("Test Description");
        todo.setCompleted(true);

        assertEquals("Test Title", todo.getTitle(), "Title should be set correctly");
        assertEquals("Test Description", todo.getDescription(), "Description should be set correctly");
        assertTrue(todo.isCompleted(), "Completed should be set to true");
    }

    @Test
    void testTodoCompletion() {
        // Vérifiez que la Todo n'est pas complétée par défaut
        assertFalse(todo.isCompleted(), "Completed should be false by default");

        // Marquez la Todo comme complétée
        todo.setCompleted(true);

        // Vérifiez que la Todo est maintenant complétée
        assertTrue(todo.isCompleted(), "Completed should be true after marking as completed");
    }
    @Test
    void testEqualsAndHashCode() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        Instant now = Instant.now();
        Instant later = now.plusSeconds(10);

        Todo todo1 = Todo.builder()
                .id(id1)
                .createdDate(now)
                .lastModifiedDate(now)
                .version(1)
                .enabled(true)
                .deleted(false)
                .build();

        Todo todo2 = Todo.builder()
                .id(id1)
                .createdDate(now)
                .lastModifiedDate(now)
                .version(1)
                .enabled(true)
                .deleted(false)
                .build();

        Todo todo3 = Todo.builder()
                .id(id2)
                .title("test")
                .description("test")
                .createdDate(later)
                .lastModifiedDate(later)
                .version(2)
                .enabled(false)
                .deleted(true)
                .build();

        // Les deux objets sont identiques
        assertEquals(todo1, todo1, "Un objet doit être égal à lui-même");

        // Les deux objets ont les mêmes attributs
        assertEquals(todo1, todo2, "Les objets doivent être égaux car ils ont les mêmes attributs");
        assertEquals(todo1.hashCode(), todo2.hashCode(), "Les codes de hachage doivent être égaux");


    }

    @Test
    void testTodoConstructorWithParameters() {
        // Créez un ensemble de tags fictif pour tester la création d'un Todo avec des tags
        Set<Tag> tags = new HashSet<>();
        tags.add(Tag.builder().id(UUID.randomUUID()).name("Tag1").build());
        tags.add(Tag.builder().id(UUID.randomUUID()).name("Tag2").build());

        // Créez un Todo en utilisant le constructeur avec des paramètres
        Todo todo = new Todo("Titre de la tâche", "Description de la tâche", true, tags);

        // Vérifiez que les attributs ont été correctement initialisés
        assertEquals("Titre de la tâche", todo.getTitle(), "Le titre doit correspondre");
        assertEquals("Description de la tâche", todo.getDescription(), "La description doit correspondre");
        assertTrue(todo.isCompleted(), "La tâche doit être complétée");
        assertEquals(tags, todo.getTags(), "Les tags doivent correspondre");
    }

    @Test
    void testUpdateWith() {
        // Créez un Todo initial
        Todo originalTodo = Todo.builder()
                .id(UUID.randomUUID())
                .title("Titre initial")
                .description("Description initiale")
                .completed(false)
                .build();

        // Créez un Todo de mise à jour
        Todo updatedTodo = Todo.builder()
                .id(originalTodo.getId())
                .title("Nouveau titre")
                .description("Nouvelle description")
                .completed(true)
                .build();

        // Appliquez la mise à jour à l'original
        originalTodo = originalTodo.updateWith(updatedTodo);

        // Vérifiez que les attributs ont été correctement mis à jour
        assertEquals("Nouveau titre", originalTodo.getTitle(), "Le titre doit être mis à jour");
        assertEquals("Nouvelle description", originalTodo.getDescription(), "La description doit être mise à jour");
    }

    @Test
    void testToString() {
        UUID id = UUID.randomUUID();

        Todo todo = Todo.builder()
                .id(id)
                .title("Titre de la tâche")
                .description("Description de la tâche")
                .completed(true)
                .build();

        String expectedToString = "Todo(title=Titre de la tâche, description=Description de la tâche, completed=true)";
        assertEquals(expectedToString, todo.toString(), "La représentation en chaîne doit être correcte");
    }
    @Test
    void testSetTags() {
        // Créez un Todo initial
        Todo todo = Todo.builder()
                .id(UUID.randomUUID())
                .title("Titre de la tâche")
                .description("Description de la tâche")
                .completed(true)
                .build();

        // Créez un ensemble de tags à définir
        Set<Tag> tagsToSet = new HashSet<>();
        tagsToSet.add(Tag.builder().id(UUID.randomUUID()).name("Tag1").build());
        tagsToSet.add(Tag.builder().id(UUID.randomUUID()).name("Tag2").build());

        // Utilisez la méthode setTags pour définir les tags
        todo.setTags(tagsToSet);

        // Vérifiez que les tags ont été correctement définis
        assertEquals(tagsToSet, todo.getTags(), "Les tags doivent être correctement définis");
    }

}
