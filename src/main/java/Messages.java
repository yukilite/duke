public class Messages extends Duke {

    //private static final String DUKE_FILE_PATH = "data/duke.txt";
    static final String COMMAND_LIST_WORD = "list";
    static final String COMMAND_DONE_WORD = "done";
    static final String COMMAND_EVENT_WORD = "event";
    static final String COMMAND_DEADLINE_WORD = "deadline";
    static final String COMMAND_TODO_WORD = "todo";
    static final String COMMAND_DELETE_WORD = "delete";
    static final String COMMAND_BYE_WORD = "bye";
    static final String MESSAGE_LIST_TASKS = " Here are the tasks in your list:";
    static final String MESSAGE_ADD_TASK = " Got it. I've added this task:";
    static final String MESSAGE_MARK_DONE = " Nice! I've marked this task as done:";
    static final String MESSAGE_GOODBYE = " Bye. Hope to see you again soon!";
    public static final String divider = "____________________________________________________________";

    public static final String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    public static final String lvlzero = "____________________________________________________________\n"
            + " Hello! I'm Duke \n"
            + " What can I do for you?\n"
            + "____________________________________________________________\n";
    public static void printWelcomeMessage(String logo) {
        System.out.println("Hello from\n" + logo);
    }
    public static void printLogoMessage(String lvlzero) {
        System.out.println(lvlzero);
    }

}
