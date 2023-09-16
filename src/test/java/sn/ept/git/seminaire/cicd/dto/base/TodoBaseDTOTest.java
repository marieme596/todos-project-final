package sn.ept.git.seminaire.cicd.dto.base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TodoBaseDTOTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testNoArgsConstructor() {
        TodoBaseDTO dto = new TodoBaseDTO();
        assertNotNull(dto, "Le constructeur sans arguments doit créer un objet non nul");
    }

    @Test
    void testGettersAndSetters() {
        TodoBaseDTO dto = new TodoBaseDTO();
        UUID id = UUID.randomUUID();
        String title = "Test Title";
        String description = "Test Description";
        boolean completed = true;

        dto.setId(id);
        dto.setTitle(title);
        dto.setDescription(description);
        dto.setCompleted(completed);

        assertEquals(id, dto.getId(), "Le getter/setter de id doit fonctionner correctement");
        assertEquals(title, dto.getTitle(), "Le getter/setter de title doit fonctionner correctement");
        assertEquals(description, dto.getDescription(), "Le getter/setter de description doit fonctionner correctement");
        assertEquals(completed, dto.isCompleted(), "Le getter/setter de completed doit fonctionner correctement");
    }

    @Test
    void testAnnotations() {
        TodoBaseDTO dto = new TodoBaseDTO();
        dto.setTitle(""); // Titre vide pour provoquer une violation de validation

        Set<ConstraintViolation<TodoBaseDTO>> violations = validator.validate(dto);

        assertFalse(violations.isEmpty(), "La validation @NotBlank doit échouer pour le titre vide");
    }


    @Test
    void testNotEquals() {
        TodoBaseDTO dto1 = TodoBaseDTO.builder()
                .id(UUID.randomUUID())
                .title("Title1")
                .description("Description1")
                .completed(true)
                .build();

        TodoBaseDTO dto2 = TodoBaseDTO.builder()
                .id(UUID.randomUUID())
                .title("Title2")
                .description("Description2")
                .completed(false)
                .build();

        assertNotEquals(dto1, dto2, "Les objets ne doivent pas être égaux car ils ont des attributs différents");
    }

    @Test
    void testHashCode() {
        TodoBaseDTO dto1 = TodoBaseDTO.builder()
                .id(UUID.randomUUID())
                .title("Title")
                .description("Description")
                .completed(true)
                .build();

        TodoBaseDTO dto2 = TodoBaseDTO.builder()
                .id(UUID.randomUUID())
                .title("Title")
                .description("Description")
                .completed(true)
                .build();

        assertEquals(dto1.hashCode(), dto2.hashCode(), "Les codes de hachage doivent être égaux car les objets sont égaux");
    }

    @Test
    void testToString() {
        UUID id = UUID.randomUUID();
        String title = "Title";
        String description = "Description";
        boolean completed = true;

        TodoBaseDTO dto = TodoBaseDTO.builder()
                .id(id)
                .title(title)
                .description(description)
                .completed(completed)
                .build();

        String expectedToString = "TodoBaseDTO(title=" + title + ", description=" + description + ", completed=true)";
        assertEquals(expectedToString, dto.toString(), "La méthode toString doit renvoyer une chaîne formatée correctement");
    }

    @Test
    void testConstructorWithStringBoolean() {
        String title = "Test Title";
        String description = "Test Description";
        boolean completed = true;

        TodoBaseDTO dto = new TodoBaseDTO(title, description, completed);

        assertEquals(title, dto.getTitle(), "Le champ title doit être initialisé correctement");
        assertEquals(description, dto.getDescription(), "Le champ description doit être initialisé correctement");
        assertEquals(completed, dto.isCompleted(), "Le champ completed doit être initialisé correctement");
    }
    @Test
    void testEquals() {
        TodoBaseDTO dto1 = TodoBaseDTO.builder()
                .title("Title1")
                .description("Description1")
                .completed(false)
                .build();

        TodoBaseDTO dto2 = TodoBaseDTO.builder()
                .title("Title1")
                .description("Description1")
                .completed(false)
                .build();

        TodoBaseDTO dto3 = TodoBaseDTO.builder()
                .title("Title2")
                .description("Description2")
                .completed(true)
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
