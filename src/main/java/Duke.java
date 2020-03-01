
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Duke {
    //private static String filePath;

    private static String description = null;
    private static String deleteIndex = null;
    String by;
    String date;
    private static int totalTasks = 0;

    public static void main(String[] args) throws DukeException, IOException {

        Messages.printWelcomeMessage(Messages.logo);
        Messages.printLogoMessage(Messages.lvlzero);


        ArrayList<Tasks> listOfTasks = new ArrayList<Tasks>();
        //Tasks[] listOfTasks = new Tasks[100];
        //readDataFromFile(listOfTasks);
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

                case Messages.COMMAND_LIST_WORD:
                    printMessage(Messages.MESSAGE_LIST_TASKS, Messages.divider);
                    for (int i = 0; i < totalTasks; ++i) {
                        int index = i + 1;
                        System.out.print("  " + index + ". " + listOfTasks.get(i) + "\n");
                    }
                //    System.out.println(divider);
                    break;

                case Messages.COMMAND_BYE_WORD:
                    //   saveDataToFile(listOfTasks);
                    printMessage(Messages.MESSAGE_GOODBYE, Messages.divider);
                    //  System.out.println(divider);

                    break;
                case Messages.COMMAND_DONE_WORD:
                    int ID = Integer.parseInt(secondCommandType);
                    ID -= 1;
                    listOfTasks.get(ID).markAsDone(true);
                    printMessage(Messages.MESSAGE_MARK_DONE, Messages.divider);
                    printMessage(Messages.divider, "\t\t" + listOfTasks.get(ID).toString());
                    break;
                case Messages.COMMAND_EVENT_WORD:
                    String[] events = secondCommandType.split("/at");
                    if (events[0] == "") {
                        throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
                    }
                    Event newEvent = new Event(events[0], events[1]);
                    printMessage(Messages.MESSAGE_ADD_TASK + "\n" + "  " + newEvent, Messages.divider);
                    totalTasks += 1;
                    printTaskCount();
               //     System.out.println(divider);
                    listOfTasks.add(newEvent);
                    break;
                case Messages.COMMAND_DEADLINE_WORD:
                    String[] deadlines = secondCommandType.split("/by");
                    if (deadlines[0] == "") {
                        throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                    }
                    Deadline newDeadLine = new Deadline(deadlines[0], deadlines[1]);
                    printMessage(Messages.MESSAGE_ADD_TASK + "\n" + "  " + newDeadLine, Messages.divider);
                    totalTasks += 1;
                    printTaskCount();
                //    System.out.println(divider);
                    listOfTasks.add(newDeadLine);
                    break;
                case Messages.COMMAND_TODO_WORD:
                    description = secondCommandType;
                    if (description == "") {
                        throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                    }
                    Todo newToDo = new Todo(description, "T");
                    printMessage(Messages.MESSAGE_ADD_TASK + "\n" + "  " + newToDo, Messages.divider);
                    totalTasks += 1;
                    printTaskCount();
                //    System.out.println(divider);
                    listOfTasks.add(newToDo);
                    break;
                case Messages.COMMAND_DELETE_WORD:
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
                System.out.println(Messages.divider);
                System.out.println(e);
            }
            System.out.println(Messages.divider);
        }
    }

    private static void printLogoMessage(String lvlzero) {
        System.out.println(lvlzero);
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

//    private static void readDataFromFile(ArrayList<Tasks> listOfTasks) throws IOException {
//        FileReader fileReader = new FileReader("data/duke.txt");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String line = bufferedReader.readLine();
//        while (line!= null) {
//            line = bufferedReader.readLine();
//        }
//    }


    // private static void saveDataToFile(ArrayList<Tasks> listOfTasks) {
    //     try {
    //         FileWriter fileWriter = new FileWriter(filePath);
    //         for (Tasks tasks: listOfTasks) {
    //             fileWriter.write(tasks.getFileString() + "\n");
    //         }
    //         fileWriter.close();
    //         System.out.println("The tasks have been saved to disk.");

    //     } catch (IOException e) {
    //         System.out.println("An error occurred when saving data to file.");
    //     }
    // }


//    private static void saveDataToFile(ArrayList<Tasks> listOfTasks) throws IOException {
//        try {
//            File file = new File ("data/duke.txt");
//            file.createNewFile();
//            FileWriter fileWriter = new FileWriter("data/duke.txt", false);
//            for (Tasks tasks: listOfTasks) {
//                fileWriter.write(tasks.getFileContents());
//                fileWriter.write(System.lineSeparator());
//            }
//            fileWriter.close();
//            System.out.println("The tasks have been saved to disk.");
//        } catch (IOException e) {
//            System.out.println("An error occurred when saving data to file.");
//        }
//    }


}
