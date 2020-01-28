import java.util.Scanner;
import java.util.Arrays;

public class Duke {
    public static void main(String[] args) {
        String divider = "____________________________________________________________";
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
        System.out.println (lvlzero);

        String[] tasks = new String[100];
        Arrays.fill(tasks, "");
        String line;
        int index = 0;
        int counter = 0;
        Scanner in = new Scanner(System.in);
        while (true) {
            line = in.nextLine();
            if (!line.equals("bye")) {
                if (line.equals("list")) {
                    for (String task: tasks) {
                        if (!task.equals("")) {
                            counter += 1;
                            System.out.println(" " + counter + ". " + task);
                        }
                        else {
                            System.out.println(divider);
                            break;
                        }
                    }
                } else {
                    tasks[index] = line;
                    index += 1;
                    System.out.println(divider);
                    System.out.println(" added: " + line);
                    System.out.println(divider);
                }
            } else {
                System.out.println(divider);
                System.out.println(" Bye. Hope to see you again soon!");
                System.out.println(divider);
                break;
            }
        }
    }
}
