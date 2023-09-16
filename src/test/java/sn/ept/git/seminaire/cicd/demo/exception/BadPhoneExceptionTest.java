package sn.ept.git.seminaire.cicd.demo.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BadPhoneExceptionTest {

    @Test
    void testDefaultConstructor() {
        // Créez une instance de BadPhoneException en utilisant le constructeur par défaut
        BadPhoneException exception = new BadPhoneException();

        // Vérifiez que l'exception a été correctement créée
        assertNull(exception.getMessage(), "The message should be null");
        assertNull(exception.getCause(), "The cause should be null");
    }

    @Test
    void testMessageConstructor() {
        // Créez une instance de BadPhoneException en utilisant le constructeur avec un message personnalisé
        String errorMessage = "Custom error message";
        BadPhoneException exception = new BadPhoneException(errorMessage);

        // Vérifiez que l'exception a été correctement créée avec le message personnalisé
        assertEquals(errorMessage, exception.getMessage(), "The custom message should be set correctly");
        assertNull(exception.getCause(), "The cause should be null");
    }

    @Test
    void testMessageAndCauseConstructor() {
        // Créez une cause fictive
        Throwable cause = new RuntimeException("Cause Exception");

        // Créez une instance de BadPhoneException en utilisant le constructeur avec un message personnalisé et une cause
        String errorMessage = "Custom error message";
        BadPhoneException exception = new BadPhoneException(errorMessage, cause);

        // Vérifiez que l'exception a été correctement créée avec le message et la cause
        assertEquals(errorMessage, exception.getMessage(), "The custom message should be set correctly");
        assertEquals(cause, exception.getCause(), "The cause should be set correctly");
    }

    @Test
    void testCauseConstructor() {
        // Créez une cause fictive
        Throwable cause = new RuntimeException("Cause Exception");

        // Créez une instance de BadPhoneException en utilisant le constructeur avec une cause
        BadPhoneException exception = new BadPhoneException(cause);

        // Vérifiez que l'exception a été correctement créée avec la cause
        assertEquals("java.lang.RuntimeException: Cause Exception", exception.getMessage(), "The message should be null");
        assertEquals(cause, exception.getCause(), "The cause should be set correctly");
    }

    @Test
    void testFullConstructor() {
        // Créez une instance de BadPhoneException en utilisant le constructeur avec tous les paramètres
        String errorMessage = "Custom error message";
        Throwable cause = new RuntimeException("Cause Exception");
        boolean enableSuppression = true;
        boolean writableStackTrace = true;
        BadPhoneException exception = new BadPhoneException(errorMessage, cause, enableSuppression, writableStackTrace);

        // Vérifiez que l'exception a été correctement créée avec tous les paramètres
        assertEquals(errorMessage, exception.getMessage(), "The custom message should be set correctly");
        assertEquals(cause, exception.getCause(), "The cause should be set correctly");
        assertEquals(0, exception.getSuppressed().length, "Suppressed exceptions should be empty");
    }
}

