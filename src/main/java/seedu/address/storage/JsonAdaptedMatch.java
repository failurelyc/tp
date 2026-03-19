package seedu.address.storage;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.match.Match;
import seedu.address.model.match.Result;

/**
 * Jackson-friendly version of {@link Match}
 */
public class JsonAdaptedMatch {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Match's %s field is missing!";

    private final String date;
    private final String result;

    /**
     * Every field must be present and not null.
     */
    public JsonAdaptedMatch(@JsonProperty("date") String date, @JsonProperty("result") String result) {
        requireAllNonNull(result);
        this.result = result;
        this.date = date;
    }

    /**
     * Converts a give {@code Match} into this class for Jackson use.
     */
    public JsonAdaptedMatch(Match source) {
        date = source.getDate().toString();
        result = source.getResult().toString();
    }

    /**
     * Converts this Jackson-friendly adapted match object into the model's {@code Match} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted match.
     */
    public Match toModelType() throws IllegalValueException {
        if (date == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "Date"));
        }
        final LocalDateTime modelDate = LocalDateTime.parse(date);

        if (result == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "Result"));
        }
        final Result modelResult = new Result(result);

        return new Match(modelDate, modelResult);
    }

}
