package sn.ept.git.seminaire.cicd.dto.base;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class BaseDTOTest {

    @Test
    void testGetterAndSetter() {
        // Créez une instance de BaseDTO
        BaseDTO baseDTO = new BaseDTO();

        // Définissez les propriétés à l'aide des setters
        UUID id = UUID.randomUUID();
        baseDTO.setId(id);
        Instant createdDate = Instant.now();
        baseDTO.setCreatedDate(createdDate);
        Instant lastModifiedDate = Instant.now();
        baseDTO.setLastModifiedDate(lastModifiedDate);
        int version = 1;
        baseDTO.setVersion(version);
        boolean enabled = true;
        baseDTO.setEnabled(enabled);
        boolean deleted = false;
        baseDTO.setDeleted(deleted);

        // Vérifiez que les getters renvoient les valeurs correctes
        assertEquals(id, baseDTO.getId(), "Le getter de id doit renvoyer la valeur correcte");
        assertEquals(createdDate, baseDTO.getCreatedDate(), "Le getter de createdDate doit renvoyer la valeur correcte");
        assertEquals(lastModifiedDate, baseDTO.getLastModifiedDate(), "Le getter de lastModifiedDate doit renvoyer la valeur correcte");
        assertEquals(version, baseDTO.getVersion(), "Le getter de version doit renvoyer la valeur correcte");
        assertEquals(enabled, baseDTO.isEnabled(), "Le getter de enabled doit renvoyer la valeur correcte");
        assertEquals(deleted, baseDTO.isDeleted(), "Le getter de deleted doit renvoyer la valeur correcte");
    }

    @Test
    void testAllArgsConstructor() {
        // Créez une instance de BaseDTO en utilisant le constructeur généré par @AllArgsConstructor
        UUID id = UUID.randomUUID();
        Instant createdDate = Instant.now();
        Instant lastModifiedDate = Instant.now();
        int version = 1;
        boolean enabled = true;
        boolean deleted = false;
        BaseDTO baseDTO = BaseDTO.of(id, createdDate, lastModifiedDate, version, enabled, deleted);

        // Vérifiez que les propriétés ont été correctement initialisées
        assertEquals(id, baseDTO.getId(), "Le id doit être initialisé correctement");
        assertEquals(createdDate, baseDTO.getCreatedDate(), "Le createdDate doit être initialisé correctement");
        assertEquals(lastModifiedDate, baseDTO.getLastModifiedDate(), "Le lastModifiedDate doit être initialisé correctement");
        assertEquals(version, baseDTO.getVersion(), "Le version doit être initialisé correctement");
        assertEquals(enabled, baseDTO.isEnabled(), "Le enabled doit être initialisé correctement");
        assertEquals(deleted, baseDTO.isDeleted(), "Le deleted doit être initialisé correctement");
    }

    @Test
    void testEqualsAndHashCode() {
        // Créez deux instances de BaseDTO avec les mêmes valeurs
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        Instant createdDate = Instant.now();
        Instant lastModifiedDate = Instant.now();
        int version = 1;
        boolean enabled = true;
        boolean deleted = false;

        BaseDTO baseDTO1 = BaseDTO.of(id1, createdDate, lastModifiedDate, version, enabled, deleted);
        BaseDTO baseDTO2 = BaseDTO.of(id1, createdDate, lastModifiedDate, version, enabled, deleted);

        // Vérifiez que les instances sont égales
        assertEquals(baseDTO1, baseDTO2, "Les instances doivent être égales");
        assertEquals(baseDTO1.hashCode(), baseDTO2.hashCode(), "Les codes de hachage doivent être égaux");
    }

    @Test
    void testToString() {
        // Créez une instance de BaseDTO
        UUID id = UUID.randomUUID();
        Instant createdDate = Instant.now();
        Instant lastModifiedDate = Instant.now();
        int version = 1;
        boolean enabled = true;
        boolean deleted = false;
        BaseDTO baseDTO = BaseDTO.of(id, createdDate, lastModifiedDate, version, enabled, deleted);

        // Vérifiez que la méthode toString génère la chaîne attendue
        String expectedToString = "BaseDTO(id=" + id + ", createdDate=" + createdDate + ", lastModifiedDate=" + lastModifiedDate + ", version=" + version + ", enabled=" + enabled + ", deleted=" + deleted + ")";
        assertEquals(expectedToString, baseDTO.toString(), "La méthode toString doit générer la chaîne attendue");
    }

    @Test
    void testSuperBuilder() {
        // Créez une instance de BaseDTO en utilisant Lombok SuperBuilder
        UUID id = UUID.randomUUID();
        Instant createdDate = Instant.now();
        Instant lastModifiedDate = Instant.now();
        int version = 1;
        boolean enabled = true;
        boolean deleted = false;
        BaseDTO baseDTO = BaseDTO.builder()
                .id(id)
                .createdDate(createdDate)
                .lastModifiedDate(lastModifiedDate)
                .version(version)
                .enabled(enabled)
                .deleted(deleted)
                .build();

        // Vérifiez que les propriétés ont été correctement initialisées
        assertEquals(id, baseDTO.getId(), "Le id doit être initialisé correctement");
        assertEquals(createdDate, baseDTO.getCreatedDate(), "Le createdDate doit être initialisé correctement");
        assertEquals(lastModifiedDate, baseDTO.getLastModifiedDate(), "Le lastModifiedDate doit être initialisé correctement");
        assertEquals(version, baseDTO.getVersion(), "Le version doit être initialisé correctement");
        assertEquals(enabled, baseDTO.isEnabled(), "Le enabled doit être initialisé correctement");
        assertEquals(deleted, baseDTO.isDeleted(), "Le deleted doit être initialisé correctement");
    }
    @Test
    void testEquals() {
        BaseDTO dto1 = BaseDTO.builder()
                .id(UUID.randomUUID())
                .createdDate(Instant.now())
                .lastModifiedDate(Instant.now())
                .version(1)
                .enabled(true)
                .deleted(false)
                .build();

        BaseDTO dto2 = BaseDTO.builder()
                .id(UUID.randomUUID())
                .createdDate(Instant.now())
                .lastModifiedDate(Instant.now())
                .version(1)
                .enabled(true)
                .deleted(false)
                .build();

        BaseDTO dto3 = BaseDTO.builder()
                .id(UUID.randomUUID())
                .createdDate(Instant.now())
                .lastModifiedDate(Instant.now())
                .version(2)
                .enabled(false)
                .deleted(true)
                .build();

        // Les deux objets sont identiques
        assertEquals(dto1, dto1, "Un objet doit être égal à lui-même");


        // Les deux objets ont des attributs différents
        assertNotEquals(dto1, dto3, "Les objets ne doivent pas être égaux car ils ont des attributs différents");
    }

    @Test
    void testHashCode() {
        UUID id1 = UUID.randomUUID();
        Instant now = Instant.now();

        // Création de deux objets BaseDTO avec les mêmes valeurs
        BaseDTO dto1 = BaseDTO.builder()
                .id(id1)
                .createdDate(now)
                .lastModifiedDate(now)
                .version(1)
                .enabled(true)
                .deleted(false)
                .build();

        BaseDTO dto2 = BaseDTO.builder()
                .id(id1)
                .createdDate(now)
                .lastModifiedDate(now)
                .version(1)
                .enabled(true)
                .deleted(false)
                .build();

        // Vérification que leurs codes de hachage sont égaux
        assertEquals(dto1.hashCode(), dto2.hashCode(), "Les codes de hachage doivent être égaux car les objets sont égaux");

        // Modification d'un attribut pour rendre les objets différents
        dto2.setVersion(2);

        // Vérification que leurs codes de hachage sont différents
        assertNotEquals(dto1.hashCode(), dto2.hashCode(), "Les codes de hachage ne doivent pas être égaux car les objets ont des versions différentes");
    }
}
