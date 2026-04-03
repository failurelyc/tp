package seedu.address.model.entity;

import java.nio.file.Path;

/**
 * Represents a pair of an {@code Entity} and its corresponding file path.
 */
public class EntityPathPair {
    private final Entity entity;
    private final Path path;

    /**
     * Constructs an EntityPathPair with the given entity and file path.
     * @param entity
     * @param path
     */
    public EntityPathPair(Entity entity, Path path) {
        this.entity = entity;
        this.path = path;
    }

    /**
     * Returns the entity in this pair.
     */
    public Entity getEntity() {
        return this.entity;
    }

    /**
     * Returns the file path in this pair.
     */
    public Path getPath() {
        return this.path;
    }
}
