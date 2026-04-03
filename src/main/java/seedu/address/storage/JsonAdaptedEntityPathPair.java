package seedu.address.storage;

import java.nio.file.Path;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.entity.EntityPathPair;

/**
 * Jackson-friendly version of {EntityPathPair}.
 */
class JsonAdaptedEntityPathPair {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "EntityPathPair's %s field is missing!";

    private final JsonAdaptedEntity entity;
    private final String iconPath;

    /**
     * Constructs a {@code JsonAdaptedEntityPathPair} with the given entity details.
     */
    @JsonCreator
    public JsonAdaptedEntityPathPair(
        @JsonProperty("entity") JsonAdaptedEntity entity,
        @JsonProperty("iconPath") String iconPath) {
        this.entity = entity;
        this.iconPath = iconPath;
    }

    /**
     * Converts a given {@code JsonAdaptedEntityPathPair} into this class for Jackson use.
     */
    public JsonAdaptedEntityPathPair(EntityPathPair pair) {
        entity = new JsonAdaptedEntity(pair.getEntity());
        iconPath = pair.getPath().toString();
    }

    /**
     * Converts this Jackson-friendly adapted entity object into the model's {@code Entity} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted entity.
     */
    public EntityPathPair toModelType() throws IllegalValueException {
        if (iconPath == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "iconPath"));
        }
        if (iconPath.isEmpty()) {
            throw new IllegalValueException("Entity iconPath cannot be empty.");
        }

        return new EntityPathPair(this.entity.toModelType(), Path.of(iconPath));
    }

}
