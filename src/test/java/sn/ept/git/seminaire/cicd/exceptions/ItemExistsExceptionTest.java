package sn.ept.git.seminaire.cicd.exceptions;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.junit.jupiter.api.Assertions.*;

public class ItemExistsExceptionTest {

    @Test
    void testDefaultConstructor() {

        ItemExistsException exception = new ItemExistsException();


        assertEquals(ItemExistsException.DEFAUL_MESSAGE, exception.getMessage(), "The default message should be set correctly");
    }

    @Test
    void testMessageConstructor() {

        String errorMessage = "Custom error message";
        ItemExistsException exception = new ItemExistsException(errorMessage);


        assertEquals(errorMessage, exception.getMessage(), "The custom message should be set correctly");
    }

    @Test
    void testResponseStatusAnnotation() {

        ResponseStatus annotation = ItemExistsException.class.getAnnotation(ResponseStatus.class);

        assertNotNull(annotation);
        assertEquals(HttpStatus.CONFLICT, annotation.value());
    }

    @Test
    void testFormatMethod() {

        String formattedMessage = ItemExistsException.format("Le nom %s existe déjà", "John");

        assertEquals("Le nom John existe déjà", formattedMessage, "The formatted message should be correct");
    }

    @Test
    void testMessageAndCauseConstructor() {
        // Créez une cause fictive
        Throwable cause = new RuntimeException("Cause Exception");

        // Créez une instance de ItemExistsException en utilisant le constructeur avec un message personnalisé et une cause
        String errorMessage = "Custom error message";
        ItemExistsException exception = new ItemExistsException(errorMessage, cause);

        // Vérifiez que l'exception a été correctement créée avec le message et la cause
        assertEquals(errorMessage, exception.getMessage(), "The custom message should be set correctly");
        assertEquals(cause, exception.getCause(), "The cause should be set correctly");
    }

    @Test
    void testCauseConstructor() {

        Throwable cause = new RuntimeException("Cause Exception");


        ItemExistsException exception = new ItemExistsException(cause);


        assertEquals(cause, exception.getCause(), "The cause should be set correctly");
    }

}
