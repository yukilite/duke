
import duke.commands.Command;
import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

import java.io.FileNotFoundException;
import java.text.ParseException;

import static duke.constants.Messages.*;


public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;

    public Duke (String filename) {
        ui = new Ui();
        storage = new Storage(filename);
        parser = new Parser();
        try {
            tasks = new TaskList(storage.readFile());
        } catch (FileNotFoundException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.greet();
        boolean isExit = false;
        while (!isExit) {
            try {
                String input = ui.readInput();
                Command command = parser.parseCommand(input);
                command.execute(tasks, ui, storage);
                isExit = command.isExit();
            } catch (DukeException e) {
                System.out.println(e.getMessage());
                System.out.println(MESSAGE_ENTER_TASK);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                System.out.println(MESSAGE_REENTER_DATE);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println(MESSAGE_REENTER_TASK_NUMBER);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                System.out.println(MESSAGE_NO_TASK_NUMBER_EXISTS);
            }
        }
    }

    public static void main(String[] args) {
        new Duke(DUKE_FILE_PATH).run();
    }

}
