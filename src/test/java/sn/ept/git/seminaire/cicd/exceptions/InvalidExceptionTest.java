package sn.ept.git.seminaire.cicd.exceptions;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.junit.jupiter.api.Assertions.*;

public class InvalidExceptionTest {

    @Test
    void testMessageConstructor() {

        String errorMessage = "Invalid input data";
        InvalidException exception = new InvalidException(errorMessage);


        assertEquals(errorMessage, exception.getMessage(), "The message should be set correctly");
    }

    @Test
    void testResponseStatusAnnotation() {

        ResponseStatus annotation = InvalidException.class.getAnnotation(ResponseStatus.class);

        assertNotNull(annotation);
        assertEquals(HttpStatus.BAD_REQUEST, annotation.value());
    }
}

