package sn.ept.git.seminaire.cicd.dto.base;

import org.junit.jupiter.api.Test;
import sn.ept.git.seminaire.cicd.dto.vm.TagVM;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TagVMTest {

    @Test
    public void testInheritedMethods() {
        // Créez une instance de TagVM
        TagVM tagVM = new TagVM();

        // Définissez les propriétés héritées de TagBaseDTO
        tagVM.setName("Example Name");
        tagVM.setDescription("Example Description");

        // Vérifiez que les méthodes héritées fonctionnent correctement
        assertEquals("Example Name", tagVM.getName());
        assertEquals("Example Description", tagVM.getDescription());
    }
    @Test
    void testEquals() {
        UUID id = UUID.randomUUID();
        String name = "Test Name";
        String description = "Test Description";

        TagVM tag1 = TagVM.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();

        TagVM tag2 = TagVM.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();

        // Les deux objets devraient être égaux car ils ont la même ID
        assertTrue(tag1.equals(tag2));
        assertTrue(tag2.equals(tag1));
    }

    @Test
    void testNotEqualsWithDifferentType() {
        UUID id = UUID.randomUUID();
        String name = "Test Name";
        String description = "Test Description";

        TagVM tag = TagVM.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();

        // Comparaison avec un objet d'un type différent, cela devrait retourner false
        assertFalse(tag.equals("Non-TagVM Object"));
    }

    @Test
    void testEqualsWithNull() {
        UUID id = UUID.randomUUID();
        String name = "Test Name";
        String description = "Test Description";

        TagVM tag = TagVM.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();

        // Comparaison avec null, cela devrait retourner false
        assertFalse(tag.equals(null));
    }


}

