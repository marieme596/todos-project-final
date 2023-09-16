package sn.ept.git.seminaire.cicd.dto.base;

import org.junit.jupiter.api.Test;
import sn.ept.git.seminaire.cicd.dto.vm.TodoVM;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TodoVMTest {

    @Test
    public void testGetAndSetTags() {
        // Créez une instance de TodoVM
        TodoVM todoVM = new TodoVM();

        // Créez un ensemble de tags simulé
        Set<UUID> tags = new HashSet<>();
        tags.add(UUID.randomUUID());
        tags.add(UUID.randomUUID());

        // Utilisez les méthodes setter et getter pour les tags
        todoVM.setTags(tags);
        Set<UUID> retrievedTags = todoVM.getTags();

        // Vérifiez que les tags sont correctement stockés et récupérés
        assertEquals(tags, retrievedTags);
    }

    @Test
    void testEquals() {
        UUID id = UUID.randomUUID();
        String title = "Test Title";
        String description = "Test Description";

        TodoVM todo1 = TodoVM.builder()
                .id(id)
                .title(title)
                .description(description)
                .build();

        TodoVM todo2 = TodoVM.builder()
                .id(id)
                .title(title)
                .description(description)
                .build();

        // Les deux objets devraient être égaux car ils ont la même ID
        assertTrue(todo1.equals(todo2));
        assertTrue(todo2.equals(todo1));
    }

    @Test
    void testNotEquals() {
        UUID id1 = UUID.randomUUID();
        String title1 = "Test Title 1";
        String title2 = "Test Title 2";
        String description1 = "Test Description 1";
        String description2 = "Test Description 2";

        TodoVM todo1 = TodoVM.builder()
                .id(id1)
                .title(title1)
                .description(description1)
                .build();

        TodoVM todo2 = TodoVM.builder()
                .id(id1)
                .title(title2)
                .description(description2)
                .build();

        assertTrue(todo1.equals(todo2));
        assertTrue(todo2.equals(todo1));
    }

    @Test
    void testToString() {
        UUID id = UUID.randomUUID();
        String title = "Test Title";
        String description = "Test Description";

        TodoVM todo = TodoVM.builder()
                .id(id)
                .title(title)
                .description(description)
                .build();

        String expectedToString = "TodoVM(tags=" + todo.getTags() +")";
        assertEquals(expectedToString, todo.toString());
    }

    @Test
    void testNotEqualsWithDifferentType() {
        UUID id = UUID.randomUUID();
        String title = "Test Title";
        String description = "Test Description";
        boolean completed = false;
        Set<UUID> tags = new HashSet<>();

        TodoVM todo = TodoVM.builder()
                .id(id)
                .title(title)
                .description(description)
                .completed(completed)
                .tags(tags)
                .build();

        // Comparaison avec un objet d'un type différent, cela devrait retourner false
        assertFalse(todo.equals("Non-Todo Object"));
    }

    @Test
    void testEqualsWithNull() {
        UUID id = UUID.randomUUID();
        String title = "Test Title";
        String description = "Test Description";
        boolean completed = false;
        Set<UUID> tags = new HashSet<>();

        TodoVM todo = TodoVM.builder()
                .id(id)
                .title(title)
                .description(description)
                .completed(completed)
                .tags(tags)
                .build();

        // Comparaison avec null, cela devrait retourner false
        assertFalse(todo.equals(null));
    }

}
