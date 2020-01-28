import java.util.Scanner;

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
                + "Hello! I'm Duke \n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";
        System.out.println (lvlzero);

        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        if (line.equals("bye")) {
            System.out.println(divider);
            System.out.println("Bye. Hope to see you again soon!");
            System.out.println(divider);
        }
        else {
            System.out.println(divider);
            System.out.println(line);
            System.out.println(divider);
        }
    }
}
