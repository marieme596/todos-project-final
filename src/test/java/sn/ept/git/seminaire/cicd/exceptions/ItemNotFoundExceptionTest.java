package sn.ept.git.seminaire.cicd.exceptions;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.junit.jupiter.api.Assertions.*;

public class ItemNotFoundExceptionTest {

    @Test
    void testDefaultConstructor() {
        ItemNotFoundException exception = new ItemNotFoundException();

        assertEquals("Impossible de retrouver l'élément recherché", exception.getMessage());
        assertNull(exception.getCause());
    }

    @Test
    void testMessageConstructor() {
        ItemNotFoundException exception = new ItemNotFoundException("Custom Message");

        assertEquals("Custom Message", exception.getMessage());
        assertNull(exception.getCause());
    }

    @Test
    void testMessageAndCauseConstructor() {
        Throwable cause = new RuntimeException("Cause Exception");
        ItemNotFoundException exception = new ItemNotFoundException("Custom Message", cause);

        assertEquals("Custom Message", exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testFormatMethod() {
        String formattedMessage = ItemNotFoundException.format("Impossible de retrouver un site avec l'identifiant %s", "123");

        assertEquals("Impossible de retrouver un site avec l'identifiant 123", formattedMessage);
    }

    @Test
    void testResponseStatusAnnotation() {
        ResponseStatus annotation = ItemNotFoundException.class.getAnnotation(ResponseStatus.class);

        assertNotNull(annotation);
        assertEquals(HttpStatus.NOT_FOUND, annotation.value());
    }

    @Test
    void testCauseConstructor() {

        Throwable cause = new RuntimeException("Cause Exception");


        ItemNotFoundException exception = new ItemNotFoundException(cause);

        assertEquals(cause, exception.getCause(), "The cause should be set correctly");
    }

}
