package sn.ept.git.seminaire.cicd.models;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TagTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        // Initialisez un validateur pour les annotations de validation
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testTagProperties() {
        // Créez une instance de Tag
        Tag tag = new Tag();
        tag.setId(UUID.randomUUID());
        tag.setName("Test Name");
        tag.setDescription("Test Description");
        tag.setEnabled(true);
        tag.setDeleted(false);

        // Vérifiez que les propriétés de Tag ont été correctement définies
        assertEquals("Test Name", tag.getName(), "Name should be set correctly");
        assertEquals("Test Description", tag.getDescription(), "Description should be set correctly");
        assertTrue(tag.isEnabled(), "Enabled should be set to true");
        assertFalse(tag.isDeleted(), "Deleted should be set to false");
    }

    @Test
    void testValidation() {
        // Créez une instance de Tag avec des valeurs invalides
        Tag tag = new Tag();
        tag.setName(""); // Nom vide

        // Validez l'instance en utilisant le validateur
        var violations = validator.validate(tag);

        // Vérifiez qu'il y a des violations d'annotations de validation
        assertFalse(violations.isEmpty(), "There should be validation violations");
    }

    @Test
    void testFromId() {
        // Créez un ID UUID
        UUID id = UUID.randomUUID();

        // Utilisez la méthode statique fromId pour créer une instance de Tag à partir de l'ID
        Tag tag = Tag.fromId(id);

        // Vérifiez que l'ID de l'instance créée correspond à l'ID d'origine
        assertEquals(id, tag.getId(), "ID should be set correctly");
    }
    @Test
    void testToStringAnnotation() {
        // Créez une instance de Tag
        Tag tag = new Tag();
        tag.setId(UUID.randomUUID());
        tag.setName("Test Name");
        tag.setDescription("Test Description");

        // Vérifiez que la méthode toString génère la chaîne attendue
        String expectedToString = "Tag(name=Test Name, description=Test Description)";
        assertEquals(expectedToString, tag.toString(), "toString should generate the expected string");
    }

    @Test
    void testAllArgsConstructorAnnotation() {
        // Créez une instance de Tag en utilisant le constructeur généré par @AllArgsConstructor
        UUID id = UUID.randomUUID();
        String name = "Another Name";
        String description = "Another Description";
        Tag tag = Tag.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();

        // Vérifiez que les propriétés ont été correctement initialisées
        assertEquals(id, tag.getId(), "ID should be set correctly");
        assertEquals(name, tag.getName(), "Name should be set correctly");
        assertEquals(description, tag.getDescription(), "Description should be set correctly");
    }
    @Test
    void testEqualsAndHashCode() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        Instant now = Instant.now();
        Instant later = now.plusSeconds(1000);

        Tag tag1 = Tag.builder()
                .id(id1)
                .name("test")
                .description("test")
                .createdDate(now)
                .lastModifiedDate(now)
                .version(1)
                .enabled(true)
                .deleted(false)
                .build();

        Tag tag2 = Tag.builder()
                .id(id1)
                .name("test")
                .description("test")
                .createdDate(now)
                .lastModifiedDate(now)
                .version(1)
                .enabled(true)
                .deleted(false)
                .build();

        Tag tag3 = Tag.builder()
                .id(id2)
                .name("test3")
                .description("test3")
                .createdDate(later)
                .lastModifiedDate(later)
                .version(2)
                .enabled(false)
                .deleted(true)
                .build();

        // Les deux objets sont identiques
        assertEquals(tag1, tag1, "Un objet doit être égal à lui-même");

        // Les deux objets ont les mêmes attributs
        assertEquals(tag1, tag2, "Les objets doivent être égaux car ils ont les mêmes attributs");
        assertEquals(tag1.hashCode(), tag2.hashCode(), "Les codes de hachage doivent être égaux");

        // Les deux objets ont des attributs différents
        assertNotEquals(tag1, tag3, "Les objets ne doivent pas être égaux car ils ont des attributs différents");
    }
    @Test
    void testSetTodos() {
        // Créez un Tag initial
        Tag tag = Tag.builder()
                .id(UUID.randomUUID())
                .name("Nom du tag")
                .description("Description du tag")
                .build();

        // Créez un ensemble de Todos à définir
        Set<Todo> todosToSet = new HashSet<>();
        todosToSet.add(Todo.builder().id(UUID.randomUUID()).title("Tâche 1").build());
        todosToSet.add(Todo.builder().id(UUID.randomUUID()).title("Tâche 2").build());

        // Utilisez la méthode setTodos pour définir les Todos
        tag.setTodos(todosToSet);

        // Vérifiez que les Todos ont été correctement définis
        assertEquals(todosToSet, tag.getTodos(), "Les Todos doivent être correctement définis");
    }
    @Test
    void testTagConstructorWithParameters() {
        // Créez un ensemble de Todos fictif pour tester le constructeur
        Set<Todo> todos = new HashSet<>();
        todos.add(Todo.builder().id(UUID.randomUUID()).title("Tâche 1").build());
        todos.add(Todo.builder().id(UUID.randomUUID()).title("Tâche 2").build());

        // Créez un Tag en utilisant le constructeur avec des paramètres
        Tag tag = new Tag("Nom du tag", "Description du tag", todos);

        // Vérifiez que les attributs ont été correctement initialisés
        assertEquals("Nom du tag", tag.getName(), "Le nom du tag doit correspondre");
        assertEquals("Description du tag", tag.getDescription(), "La description du tag doit correspondre");
        assertEquals(todos, tag.getTodos(), "Les Todos doivent correspondre");
    }

}
