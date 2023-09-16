package sn.ept.git.seminaire.cicd.dto.base;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TagBaseDTOTest {

    private Validator validator;

    public TagBaseDTOTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testNameNotBlankValidation() {
        // Créez une instance de TagBaseDTO avec un nom vide
        TagBaseDTO tagBaseDTO = TagBaseDTO.builder()
                .name("")
                .build();

        // Validez l'objet en utilisant le validateur
        Set<ConstraintViolation<TagBaseDTO>> violations = validator.validate(tagBaseDTO);

        // Vérifiez que la violation NotBlank est présente
        assertFalse(violations.isEmpty(), "La validation NotBlank doit échouer pour le nom vide");
    }

    @Test
    void testNameSizeValidation() {
        // Créez une instance de TagBaseDTO avec un nom trop long
        String longName = "ThisIsALongNameThatExceedsTheMaximumAllowedLengthhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh";
        TagBaseDTO tagBaseDTO = TagBaseDTO.builder()
                .name(longName)
                .build();

        // Validez l'objet en utilisant le validateur
        Set<ConstraintViolation<TagBaseDTO>> violations = validator.validate(tagBaseDTO);

        // Vérifiez que la violation Size est présente
        assertFalse(violations.isEmpty(), "La validation Size doit échouer pour le nom trop long");
    }

    @Test
    void testEqualsAndHashCode() {
        TagBaseDTO dto1 = TagBaseDTO.builder()
                .name("Tag1")
                .description("Description1")
                .build();

        TagBaseDTO dto2 = TagBaseDTO.builder()
                .name("Tag1")
                .description("Description1")
                .build();

        TagBaseDTO dto3 = TagBaseDTO.builder()
                .name("Tag2")
                .description("Description2")
                .build();

        // Vérifier l'égalité et les codes de hachage
        assertEquals(dto1, dto2, "Les objets doivent être égaux");
        assertEquals(dto1.hashCode(), dto2.hashCode(), "Les codes de hachage doivent être égaux");

        assertNotEquals(dto1, dto3, "Les objets ne doivent pas être égaux");
        assertNotEquals(dto1.hashCode(), dto3.hashCode(), "Les codes de hachage ne doivent pas être égaux");

        // Vérifier les cas avec null et d'autres types d'objets
        assertNotEquals(null, dto1, "L'objet ne doit pas être égal à null");
        assertNotEquals("Autre objet", dto1, "L'objet ne doit pas être égal à un autre type d'objet");
    }

    @Test
    void testTagBaseDTOConstructor() {
        TagBaseDTO dto = new TagBaseDTO("Tag3", "Description3");

        assertEquals("Tag3", dto.getName(), "Le nom doit correspondre");
        assertEquals("Description3", dto.getDescription(), "La description doit correspondre");
    }

    @Test
    void testToString() {
        TagBaseDTO dto = TagBaseDTO.builder()
                .name("Tag4")
                .description("Description4")
                .build();

        String expectedToString = "TagBaseDTO(name=Tag4, description=Description4)";
        assertEquals(expectedToString, dto.toString(), "La représentation en chaîne doit être correcte");
    }
    @Test
    void testEquals() {
        TagBaseDTO dto1 = TagBaseDTO.builder()
                .name("Tag1")
                .description("Description1")
                .build();

        TagBaseDTO dto2 = TagBaseDTO.builder()
                .name("Tag1")
                .description("Description1")
                .build();

        TagBaseDTO dto3 = TagBaseDTO.builder()
                .name("Tag2")
                .description("Description2")
                .build();

        // Les deux objets sont identiques
        assertEquals(dto1, dto1, "Un objet doit être égal à lui-même");

        // Les deux objets ont les mêmes attributs
        assertEquals(dto1, dto2, "Les objets doivent être égaux car ils ont les mêmes attributs");
        assertEquals(dto1.hashCode(), dto2.hashCode(), "Les codes de hachage doivent être égaux");

        // Les deux objets ont des attributs différents
        assertNotEquals(dto1, dto3, "Les objets ne doivent pas être égaux car ils ont des attributs différents");
    }
}
