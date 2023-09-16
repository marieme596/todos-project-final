package sn.ept.git.seminaire.cicd.models;

import java.time.Instant;
import java.util.UUID;

public class BaseEntityConcrete extends BaseEntity {
    // Constructeur pour les tests
    public BaseEntityConcrete(UUID id, Instant createdDate, Instant lastModifiedDate, int version, boolean enabled, boolean deleted) {
        super(id, createdDate, lastModifiedDate, version, enabled, deleted);
    }
}