package sn.ept.git.seminaire.cicd.utils;

import org.junit.jupiter.api.Test;
import sn.ept.git.seminaire.cicd.models.BaseEntity;
import sn.ept.git.seminaire.cicd.models.BaseEntityConcrete;

import java.time.Instant;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {

    @Test
    public void testContains_WhenItemExists() {
        UUID id = UUID.randomUUID();
        Instant createdDate = Instant.now();
        Instant lastModifiedDate = Instant.now();
        int version = 1;
        boolean enabled = true;
        boolean deleted = false;

        BaseEntityConcrete entity = new BaseEntityConcrete(id, createdDate, lastModifiedDate, version, enabled, deleted);
        Set<BaseEntity> entitySet = new HashSet<>();
        entitySet.add(entity);

        boolean result = Utils.contains(entitySet, id);

        assertTrue(result);
    }

    @Test
    public void testContains_WhenItemDoesNotExist() {
        Set<BaseEntity> entitySet = new HashSet<>();
        UUID idToFind = UUID.randomUUID();

        boolean result = Utils.contains(entitySet, idToFind);

        assertFalse(result);
    }
    @Test
    void findAbsentIdsSetShouldReturnAbsentIds() {
        // Arrange
        Set<BaseEntity> list = new HashSet<>();
        Set<UUID> ids = new HashSet<>(Arrays.asList(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID()));

        // Act
        Set<UUID> absentIds = Utils.findAbsentIds(list, ids);

        // Assert
        assertEquals(ids, absentIds);
    }

    @Test
    void findAbsentIdsListShouldReturnAbsentIds() {
        // Arrange
        List<BaseEntity> list = new ArrayList<>();
        Set<UUID> ids = new HashSet<>(Arrays.asList(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID()));

        // Act
        Set<UUID> absentIds = Utils.findAbsentIds(list, ids);

        // Assert
        assertEquals(ids, absentIds);
    }


}
