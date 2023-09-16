package sn.ept.git.seminaire.cicd.exceptions;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.junit.jupiter.api.Assertions.*;

public class ForbiddenExceptionTest {

    @Test
    void testDefaultConstructor() {

        ForbiddenException exception = new ForbiddenException();


        assertEquals(ForbiddenException.DEFAULT_MSG, exception.getMessage(), "The default message should be set correctly");
    }

    @Test
    void testMessageConstructor() {

        String errorMessage = "Custom error message";
        ForbiddenException exception = new ForbiddenException(errorMessage);


        assertEquals(errorMessage, exception.getMessage(), "The custom message should be set correctly");
    }

    @Test
    void testResponseStatusAnnotation() {

        ResponseStatus annotation = ForbiddenException.class.getAnnotation(ResponseStatus.class);

        assertNotNull(annotation);
        assertEquals(HttpStatus.FORBIDDEN, annotation.value());
        assertEquals(ForbiddenException.DEFAULT_MSG, annotation.reason());
    }
}
