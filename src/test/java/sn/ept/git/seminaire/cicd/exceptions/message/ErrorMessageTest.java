package sn.ept.git.seminaire.cicd.exceptions.message;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ErrorMessageTest {

    @Test
    void testGetterAndSetter() {
        // Créez une instance de ErrorMessage
        ErrorMessage errorMessage = new ErrorMessage();

        // Définissez les propriétés à l'aide des setters
        errorMessage.setStatus(404);
        errorMessage.setTimestamp(new Date());
        errorMessage.setMessage("Not Found");
        errorMessage.setDescription("Resource not found");

        // Vérifiez que les getters renvoient les valeurs correctes
        assertEquals(404, errorMessage.getStatus(), "Le getter de status doit renvoyer la valeur correcte");
        assertNotNull(errorMessage.getTimestamp(), "Le getter de timestamp doit renvoyer une valeur non nulle");
        assertEquals("Not Found", errorMessage.getMessage(), "Le getter de message doit renvoyer la valeur correcte");
        assertEquals("Resource not found", errorMessage.getDescription(), "Le getter de description doit renvoyer la valeur correcte");
    }

    @Test
    void testAllArgsConstructor() {
        // Créez une instance de ErrorMessage en utilisant le constructeur généré par @AllArgsConstructor
        ErrorMessage errorMessage = ErrorMessage.of(404, new Date(), "Not Found", "Resource not found");

        // Vérifiez que les propriétés ont été correctement initialisées
        assertEquals(404, errorMessage.getStatus(), "Le status doit être initialisé correctement");
        assertNotNull(errorMessage.getTimestamp(), "Le timestamp doit être initialisé correctement");
        assertEquals("Not Found", errorMessage.getMessage(), "Le message doit être initialisé correctement");
        assertEquals("Resource not found", errorMessage.getDescription(), "La description doit être initialisée correctement");
    }

    @Test
    void testEqualsAndHashCode() {
        // Créez deux instances de ErrorMessage avec les mêmes valeurs
        ErrorMessage errorMessage1 = ErrorMessage.of(404, new Date(), "Not Found", "Resource not found");
        ErrorMessage errorMessage2 = ErrorMessage.of(404, new Date(), "Not Found", "Resource not found");

        // Vérifiez que les instances sont égales
        assertEquals(errorMessage1, errorMessage2, "Les instances doivent être égales");
        assertEquals(errorMessage1.hashCode(), errorMessage2.hashCode(), "Les codes de hachage doivent être égaux");
    }

    @Test
    void testToString() {
        // Créez une instance de ErrorMessage
        ErrorMessage errorMessage = ErrorMessage.of(404, new Date(), "Not Found", "Resource not found");

        // Vérifiez que la méthode toString génère la chaîne attendue
        String expectedToString = "ErrorMessage(status=404, timestamp=" + errorMessage.getTimestamp() + ", message=Not Found, description=Resource not found)";
        assertEquals(expectedToString, errorMessage.toString(), "La méthode toString doit générer la chaîne attendue");
    }

    @Test
    void testSuperBuilder() {
        // Créez une instance de ErrorMessage en utilisant Lombok SuperBuilder
        ErrorMessage errorMessage = ErrorMessage.builder()
                .status(404)
                .timestamp(new Date())
                .message("Not Found")
                .description("Resource not found")
                .build();

        // Vérifiez que les propriétés ont été correctement initialisées
        assertEquals(404, errorMessage.getStatus(), "Le status doit être initialisé correctement");
        assertNotNull(errorMessage.getTimestamp(), "Le timestamp doit être initialisé correctement");
        assertEquals("Not Found", errorMessage.getMessage(), "Le message doit être initialisé correctement");
        assertEquals("Resource not found", errorMessage.getDescription(), "La description doit être initialisée correctement");
    }
}
