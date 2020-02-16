package duke;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;


public class Duke {

    private static final String COMMAND_LIST_WORD = "list";
    private static final String COMMAND_DONE_WORD = "done";
    private static final String COMMAND_EVENT_WORD = "event";
    private static final String COMMAND_DEADLINE_WORD = "deadline";
    private static final String COMMAND_TODO_WORD = "todo";
    private static final String COMMAND_DELETE_WORD = "delete";
    private static final String COMMAND_BYE_WORD = "bye";
    private static final String MESSAGE_LIST_TASKS = " Here are the tasks in your list:";
    private static final String MESSAGE_ADD_TASK = " Got it. I've added this task:";
    private static final String MESSAGE_MARK_DONE = " Nice! I've marked this task as done:";
    private static final String MESSAGE_GOODBYE = " Bye. Hope to see you again soon!";

    private static String divider = "____________________________________________________________";
    private static String description = null;
    private static String deleteIndex = null;
    String by;
    String date;
    private static int totalTasks = 0;
    private static String filePath;

    public static void main(String[] args) throws DukeException {
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

        ArrayList<Tasks> listOfTasks = new ArrayList<Tasks>();
        //Tasks[] listOfTasks = new Tasks[100];

        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                String firstCommandType = null;
                String secondCommandType = null;
                String inputLine = in.nextLine();

                String[] commandType = inputLine.split(" ", 2);
                if (commandType.length > 1) {
                    firstCommandType = commandType[0];
                    secondCommandType = commandType[1];
                } else {
                    firstCommandType = commandType[0];
                    secondCommandType = "";
                }

                switch (firstCommandType) {

                case COMMAND_LIST_WORD:
                    printMessage(MESSAGE_LIST_TASKS, divider);
                    for (int i = 0; i < totalTasks; ++i) {
                        int index = i + 1;
                        System.out.print("  " + index + ". " + listOfTasks.get(i) + "\n");
                    }
                //    System.out.println(divider);
                    break;
                case COMMAND_BYE_WORD:
                    saveDataToFile(listOfTasks);
                    printMessage(MESSAGE_GOODBYE, divider);
                  //  System.out.println(divider);
                    break;
                case COMMAND_DONE_WORD:
                    int ID = Integer.parseInt(secondCommandType);
                    ID -= 1;
                    listOfTasks.get(ID).markAsDone(true);
                    printMessage(MESSAGE_MARK_DONE, divider);
                    printMessage(divider, "\t\t" + listOfTasks.get(ID).toString());
                    break;
                case COMMAND_EVENT_WORD:
                    String[] events = secondCommandType.split("/at");
                    if (events[0] == "") {
                        throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
                    }
                    Event newEvent = new Event(events[0], events[1]);
                    printMessage(MESSAGE_ADD_TASK + "\n" + "  " + newEvent, divider);
                    totalTasks += 1;
                    printTaskCount();
               //     System.out.println(divider);
                    listOfTasks.add(newEvent);
                    break;
                case COMMAND_DEADLINE_WORD:
                    String[] deadlines = secondCommandType.split("/by");
                    if (deadlines[0] == "") {
                        throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                    }
                    Deadline newDeadLine = new Deadline(deadlines[0], deadlines[1]);
                    printMessage(MESSAGE_ADD_TASK + "\n" + "  " + newDeadLine, divider);
                    totalTasks += 1;
                    printTaskCount();
                //    System.out.println(divider);
                    listOfTasks.add(newDeadLine);
                    break;
                case COMMAND_TODO_WORD:
                    description = secondCommandType;
                    if (description == "") {
                        throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                    }
                    Todo newToDo = new Todo(description, "T");
                    printMessage(MESSAGE_ADD_TASK + "\n" + "  " + newToDo, divider);
                    totalTasks += 1;
                    printTaskCount();
                //    System.out.println(divider);
                    listOfTasks.add(newToDo);
                    break;
                case COMMAND_DELETE_WORD:
                    deleteIndex = secondCommandType;
                    if (deleteIndex == "") {
                        throw new DukeException("☹ OOPS!!! The description of a delete cannot be empty.");
                    }
                    int intDeleteIndex = Integer.parseInt(deleteIndex) - 1;
                    printDeleteMsg(listOfTasks.get(intDeleteIndex));
                    listOfTasks.remove(intDeleteIndex);
                    //printMessage(MESSAGE_DELETE_TASK +"\n" + " " + newDelete, divider);
                    //printTaskCount();
                    break;
                default:
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e) {
                System.out.println(divider);
                System.out.println(e);
            }
            System.out.println(divider);
        }
    }

    private static void printMessage(String msg, String divider) {
        System.out.println(divider);
        System.out.println(msg);
    }

    private static void printTaskCount() {
        System.out.println(" Now you have " + totalTasks + " tasks in the list.");
    }
    private static void printDeleteMsg(Tasks task) {
        System.out.println(" Noted. I've removed this task: ");
        System.out.println(" " + task);
        totalTasks -= 1;
        System.out.println(" Now you have " + totalTasks + " task(s) in the list. ");
    }

    private static void saveDataToFile(ArrayList<Tasks> listOfTasks) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            for (Tasks tasks: listOfTasks) {
                fileWriter.write(tasks.getFileString() + "\n");
            }
            fileWriter.close();
            System.out.println("The tasks have been saved to disk.")

        } catch (IOException e) {
            System.out.println("An error occurred when saving data to file.");
        }
    }
}
