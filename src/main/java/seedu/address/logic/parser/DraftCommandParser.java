package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.ArrayList;
import java.util.List;

import seedu.address.logic.commands.DraftCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DraftCommand object.
 */
public class DraftCommandParser implements Parser<DraftCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DraftCommand
     * and returns a DraftCommand object for execution.
     *
     * @param args the arguments string containing space-separated indices and/or IGN arguments
     * @return a DraftCommand object
     * @throws ParseException if the user input does not conform the expected format
     */
    public DraftCommand parse(String args) throws ParseException {
        try {
            String trimmedArgs = args.trim();
            if (trimmedArgs.isEmpty()) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, DraftCommand.PARAMETERS));
            }

            String[] argStrings = trimmedArgs.split("\\s+");
            List<String> identifiers = new ArrayList<>();

            for (String argString : argStrings) {
                String identifier = ParserUtil.parseIdentifier(argString);
                identifiers.add(identifier);
            }

            return new DraftCommand(identifiers);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DraftCommand.PARAMETERS), pe);
        }
    }
}
