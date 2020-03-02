package duke.parser;

import duke.commands.*;
import duke.exception.DukeException;
import static duke.constants.Messages.*;

public class Parser {
    public static Command parseCommand(String input) throws DukeException {
        String[] words = input.split(" ", 2);
        String commandWord = words[0];
        Command newCommand;
        switch (commandWord.toLowerCase()) {
        case (COMMAND_BYE_WORD):
            return new ExitProgram();
        break;
        case (COMMAND_LIST_WORD):
            return new ListCommand();
        break;
        case (COMMAND_DONE_WORD):
            return new DoneCommand();
        break;
        case (COMMAND_DEADLINE_WORD):
            return new DeadlineCommand();
        break;
        case (COMMAND_EVENT_WORD):
            return new EventCommand();
        break;
        case (COMMAND_DELETE_WORD):
            return new DeleteCommand();
        break;
        case (COMMAND_TODO_WORD):
            return new TodoCommand();
        default:
            throw new DukeException(MESSAGE_NO_COMMAND_EXISTS);
        }
    }

}
