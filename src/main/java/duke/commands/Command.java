package duke.commands;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

import java.text.ParseException;

public abstract class Command {
    protected String command;

    public abstract void execute(TaskList taskList, Ui uiInput, Storage storage) throws DukeException, ParseException;

    public abstract boolean isExit();

}
