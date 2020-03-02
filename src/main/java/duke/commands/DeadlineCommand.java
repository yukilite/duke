package duke.commands;

import duke.converter.timeConverter;
import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Deadline;
import duke.task.Tasks;
import duke.tasklist.TaskList;
import duke.ui.Ui;

import java.text.ParseException;

import static duke.constants.Messages.MESSAGE_DEADLINE_DESCRIPTION_CANNOT_BE_EMPTY;
import static duke.constants.Messages.MESSAGE_TIME_DEADLINE_CANNOT_BE_EMPTY;

public class DeadlineCommand extends Command {

    public DeadlineCommand (String command) {
        super();
        this.command = command;
    }

    public void execute(TaskList taskList, Ui uiInput, Storage storage) throws DukeException, ParseException {
        String[] words = command.split(" ",2);
        if (words.length == 1) {
            throw new DukeException(MESSAGE_DEADLINE_DESCRIPTION_CANNOT_BE_EMPTY);
        }
        String[] wordSplitter = words[1].split("/by");
        String[] dateTime = wordSplitter[1].trim().split(" ");
        if (dateTime.length > 1) {
            Tasks task = new Deadline(wordSplitter[0].trim(), timeConverter.dateTime(wordSplitter[1].trim()));
            taskList.addTasks(task);
            storage.writeFile(taskList);

        }
        else {
            throw new DukeException(MESSAGE_TIME_DEADLINE_CANNOT_BE_EMPTY);
        }
    }
    public boolean isExit() {
        return false;
    }
}
