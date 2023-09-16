package sn.ept.git.seminaire.cicd.utils;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResponseUtilTest {

    @Test
    public void testWrapOrNotFound_WithOptionalValue() {
        Optional<String> optionalValue = Optional.of("Hello, World!");
        ResponseEntity<String> responseEntity = ResponseUtil.wrapOrNotFound(optionalValue);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Hello, World!", responseEntity.getBody());
    }


    @Test
    public void testWrapOrNotFound_ThrowsException() {
        Optional<String> emptyOptional = Optional.empty();
        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> ResponseUtil.wrapOrNotFound(emptyOptional, "Custom Exception Reason"));
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertEquals("Custom Exception Reason", exception.getReason());
    }

    @Test
    public void testWrapOrNotFound_WithHttpStatusAndHeaders() {
        Optional<String> optionalValue = Optional.of("Hello, World!");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Header-Value");
        ResponseEntity<String> responseEntity = ResponseUtil.wrapOrNotFound(optionalValue, headers, HttpStatus.ACCEPTED);
        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        assertEquals("Hello, World!", responseEntity.getBody());
        assertEquals("Header-Value", responseEntity.getHeaders().getFirst("Custom-Header"));
    }

    // Vous pouvez ajouter d'autres tests pour les autres variations des méthodes wrapOrNotFound si nécessaire
}

