package org.tosch.neverrest.service.models.read;

import org.joda.time.DateTime;
import org.tosch.neverrest.data.models.CoreDataEntity;
import org.tosch.neverrest.service.models.create.CoreServiceCreateEntity;
import org.tosch.neverrest.service.models.update.CoreServiceUpdateEntity;

import java.util.UUID;

public abstract class CoreServiceEntity<
        S extends CoreServiceEntity<S, C, U, D>,
        C extends CoreServiceCreateEntity<S, D>,
        U extends CoreServiceUpdateEntity<S, D>,
        D extends CoreDataEntity> extends ServiceEntity<S, C, U, D> {
    public CoreServiceEntity(D dataEntity) {
        super(dataEntity);
        this.uuid = UUID.fromString(dataEntity.getUuid());
        this.createdAt = dataEntity.getCreatedAt();
        this.modifiedAt = dataEntity.getModifiedAt();
    }

    private final UUID uuid;
    private final DateTime createdAt;
    private final DateTime modifiedAt;

    public UUID getUuid() {
        return uuid;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public DateTime getModifiedAt() {
        return modifiedAt;
    }
}
