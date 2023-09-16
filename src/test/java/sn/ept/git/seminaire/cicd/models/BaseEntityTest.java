package sn.ept.git.seminaire.cicd.models;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class BaseEntityTest {

    @Test
    public void testEquals_SameInstance() {
        BaseEntityConcrete entity1 = createBaseEntity();
        BaseEntityConcrete entity2 = entity1;

        assertTrue(entity1.equals(entity2));
    }

    @Test
    public void testEquals_NullObject() {
        BaseEntityConcrete entity1 = createBaseEntity();
        BaseEntityConcrete entity2 = null;

        assertFalse(entity1.equals(entity2));
    }

    @Test
    public void testEquals_DifferentClass() {
        BaseEntityConcrete entity1 = createBaseEntity();
        Object entity2 = new Object();

        assertFalse(entity1.equals(entity2));
    }

    @Test
    public void testEquals_DifferentId() {
        BaseEntityConcrete entity1 = createBaseEntity();
        BaseEntityConcrete entity2 = createBaseEntityWithDifferentId();

        assertFalse(entity1.equals(entity2));
    }

    @Test
    public void testEquals_SameId() {
        BaseEntityConcrete entity1 = createBaseEntity();
        BaseEntityConcrete entity2 = entity1;

        assertTrue(entity1.equals(entity2));
    }

    @Test
    public void testHashCode() {
        BaseEntityConcrete entity1 = createBaseEntity();
        BaseEntityConcrete entity2 = entity1;

        assertEquals(entity1.hashCode(), entity2.hashCode());
    }

    @Test
    public void testToString() {
        BaseEntityConcrete entity = createBaseEntity();
        String expectedToString = "BaseEntity(" +
                "id=" + entity.getId() +
                ", createdDate=" + entity.getCreatedDate() +
                ", lastModifiedDate=" + entity.getLastModifiedDate() +
                ", version=" + entity.getVersion() +
                ", enabled=" + entity.isEnabled() +
                ", deleted=" + entity.isDeleted() +
                ')';

        assertEquals(expectedToString, entity.toString());
    }

    @Test
    public void testSetCreatedDate() {
        BaseEntityConcrete entity = createBaseEntity();
        Instant newCreatedDate = Instant.now();

        entity.setCreatedDate(newCreatedDate);

        assertEquals(newCreatedDate, entity.getCreatedDate());
    }

    @Test
    public void testSetLastModifiedDate() {
        BaseEntityConcrete entity = createBaseEntity();
        Instant newLastModifiedDate = Instant.now();

        entity.setLastModifiedDate(newLastModifiedDate);

        assertEquals(newLastModifiedDate, entity.getLastModifiedDate());
    }

    @Test
    public void testSetVersion() {
        BaseEntityConcrete entity = createBaseEntity();
        int newVersion = 2;

        entity.setVersion(newVersion);

        assertEquals(newVersion, entity.getVersion());
    }

    @Test
    public void testCanEqual() {
        BaseEntityConcrete entity1 = createBaseEntity();
        BaseEntityConcrete entity2 = createBaseEntity();

        assertTrue(entity1.canEqual(entity2));
    }


    @Test
    public void testEquals_DifferentCreatedDate() {
        BaseEntityConcrete entity1 = createBaseEntity();
        BaseEntityConcrete entity2 = createBaseEntity();
        entity2.setCreatedDate(entity1.getCreatedDate().plusSeconds(1)); // Different createdDate

        assertFalse(entity1.equals(entity2));
    }

    @Test
    public void testEquals_DifferentLastModifiedDate() {
        BaseEntityConcrete entity1 = createBaseEntity();
        BaseEntityConcrete entity2 = createBaseEntity();
        entity2.setLastModifiedDate(entity1.getLastModifiedDate().plusSeconds(1)); // Different lastModifiedDate

        assertFalse(entity1.equals(entity2));
    }

    @Test
    public void testEquals_DifferentVersion() {
        BaseEntityConcrete entity1 = createBaseEntity();
        BaseEntityConcrete entity2 = createBaseEntity();
        entity2.setVersion(entity1.getVersion() + 1); // Different version

        assertFalse(entity1.equals(entity2));
    }

    @Test
    public void testEquals_DifferentEnabled() {
        BaseEntityConcrete entity1 = createBaseEntity();
        BaseEntityConcrete entity2 = createBaseEntity();
        entity2.setEnabled(!entity1.isEnabled()); // Different enabled

        assertFalse(entity1.equals(entity2));
    }

    @Test
    public void testEquals_DifferentDeleted() {
        BaseEntityConcrete entity1 = createBaseEntity();
        BaseEntityConcrete entity2 = createBaseEntity();
        entity2.setDeleted(!entity1.isDeleted()); // Different deleted

        assertFalse(entity1.equals(entity2));
    }


    private BaseEntityConcrete createBaseEntity() {
        UUID id = UUID.randomUUID();
        Instant createdDate = Instant.now();
        Instant lastModifiedDate = Instant.now();
        int version = 1;
        boolean enabled = true;
        boolean deleted = false;

        return new BaseEntityConcrete(id, createdDate, lastModifiedDate, version, enabled, deleted);
    }

    private BaseEntityConcrete createBaseEntityWithDifferentId() {
        UUID id = UUID.randomUUID(); // Different ID
        Instant createdDate = Instant.now();
        Instant lastModifiedDate = Instant.now();
        int version = 1;
        boolean enabled = true;
        boolean deleted = false;

        return new BaseEntityConcrete(id, createdDate, lastModifiedDate, version, enabled, deleted);
    }

}


