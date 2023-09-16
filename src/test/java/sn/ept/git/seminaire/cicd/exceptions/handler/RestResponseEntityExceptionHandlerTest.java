package sn.ept.git.seminaire.cicd.exceptions.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import sn.ept.git.seminaire.cicd.exceptions.ForbiddenException;
import sn.ept.git.seminaire.cicd.exceptions.InvalidException;
import sn.ept.git.seminaire.cicd.exceptions.ItemExistsException;
import sn.ept.git.seminaire.cicd.exceptions.ItemNotFoundException;
import sn.ept.git.seminaire.cicd.exceptions.message.ErrorMessage;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RestResponseEntityExceptionHandlerTest {

    @InjectMocks
    private RestResponseEntityExceptionHandler exceptionHandler;

    @Mock
    private WebRequest webRequest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testNotFound() {
        // Créez une exception ItemNotFoundException simulée
        ItemNotFoundException ex = new ItemNotFoundException("Item not found");

        // Configurez le comportement de la WebRequest simulée
        when(webRequest.getDescription(false)).thenReturn("Description");

        // Appelez la méthode notFound de l'exceptionHandler
        ResponseEntity<ErrorMessage> response = exceptionHandler.notFound(ex, webRequest);

        // Vérifiez la réponse HTTP générée
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        ErrorMessage errorMessage = response.getBody();
        assert errorMessage != null;
        assertEquals(HttpStatus.NOT_FOUND.value(), errorMessage.getStatus());
        assertEquals("Item not found", errorMessage.getMessage());
        assertEquals("Description", errorMessage.getDescription());
    }
    @Test
    void internalErrorShouldReturnInternalServerErrorResponse() {
        Exception ex = new Exception("Internal error");
        ResponseEntity<ErrorMessage> response = exceptionHandler.internalError(ex, webRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);

        ErrorMessage errorMessage = response.getBody();
        assertThat(errorMessage).isNotNull();
        assertThat(errorMessage.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
        assertThat(errorMessage.getMessage()).isEqualTo("Internal error");
    }

    @Test
    void permissionDeniedShouldReturnForbiddenResponse() {
        ForbiddenException ex = new ForbiddenException("Permission denied");
        ResponseEntity<ErrorMessage> response = exceptionHandler.permissionDenied(ex, webRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);

        ErrorMessage errorMessage = response.getBody();
        assertThat(errorMessage).isNotNull();
        assertThat(errorMessage.getStatus()).isEqualTo(HttpStatus.FORBIDDEN.value());
        assertThat(errorMessage.getMessage()).isEqualTo("Permission denied");
    }

    @Test
    void badRequestShouldReturnBadRequestResponse() {
        InvalidException ex = new InvalidException("Bad request");
        ResponseEntity<ErrorMessage> response = exceptionHandler.badRequest(ex, webRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

        ErrorMessage errorMessage = response.getBody();
        assertThat(errorMessage).isNotNull();
        assertThat(errorMessage.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        assertThat(errorMessage.getMessage()).isEqualTo("Bad request");
    }

    @Test
    void conflictShouldReturnConflictResponse() {
        ItemExistsException ex = new ItemExistsException("Conflict");
        ResponseEntity<ErrorMessage> response = exceptionHandler.conflict(ex, webRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);

        ErrorMessage errorMessage = response.getBody();
        assertThat(errorMessage).isNotNull();
        assertThat(errorMessage.getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
        assertThat(errorMessage.getMessage()).isEqualTo("Conflict");
    }



}
