import java.util.Scanner;
import java.util.Arrays;

public class Duke{
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        String lvlzero = "____________________________________________________________\n"
                + " Hello! I'm Duke \n"
                + " What can I do for you?\n"
                + "____________________________________________________________\n";
        System.out.println(lvlzero);

        Task[] listOfTasks = new Task[100];
        final String COMMAND_LIST_WORD = "list";
        final String COMMAND_DONE_WORD = "done";
        final String COMMAND_BYE_WORD = "bye";
        final String MESSAGE_GOODBYE = " Bye. Hope to see you again soon!";
        final String divider = "____________________________________________________________";
        int count = 0;

        Scanner in = new Scanner(System.in);

        while (true) {
            String commandType = in.nextLine();
            if (commandType.startsWith(COMMAND_DONE_WORD)) {
                String[] arrOfCommandType = commandType.split(" ");
                String StringID = arrOfCommandType[1];
                int ID = Integer.parseInt(StringID) - 1;
                System.out.println(divider);
                System.out.println(" Nice! I've marked this task as done:");
                System.out.println("\t" + listOfTasks[ID].markAsDone());
                System.out.println(divider);
                break;
            }
            switch (commandType) {
                case COMMAND_LIST_WORD:
                    System.out.println(divider);
                    for (int i = 1; i <= count; ++i) {
                        System.out.print(i);
                        System.out.print(". ["+ listOfTasks[i-1].getStatusIcon() + "] " + listOfTasks[i-1].description + "\n");
                    }
                    System.out.println(divider);
                    break;
                case COMMAND_BYE_WORD:
                    System.out.println(divider);
                    System.out.println(MESSAGE_GOODBYE);
                    System.out.println(divider);
                    break;
                default:
                    System.out.println(divider);
                    System.out.println(" added: " + commandType);
                    System.out.println(divider);
                    listOfTasks[count] = new Task(commandType);
                    count += 1;
            }
        }
    }

    private static class Task {
        protected String description;
        protected boolean isDone;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public String getStatusIcon() {
            return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
        }

        public String markAsDone () {
            this.isDone = true;
            return ("[" + this.getStatusIcon() + "]" + " " + this.description);
        }
    }
}