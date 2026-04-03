package seedu.address.model.entity;

import java.nio.file.Path;

public class EntityPathPair {
    private final Entity entity;
    private final Path path;

    public EntityPathPair(Entity entity, Path path) {
        this.entity = entity;
        this.path = path;
    }

    public Entity getEntity() {
        return this.entity;
    }

    public Path getPath() {
        return this.path;
    }
}
