public class Tasks {

    protected String description;
    protected boolean isDone;
    protected int taskNumber;
    protected String type;
    private static int totalTasks = 0;

    public Tasks(String description, String type) {
        this.description = description;
        this.taskNumber = totalTasks;
        this.isDone = false;
        this.type = type;
        totalTasks += 1;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String markAsDone () {
        this.isDone = true;
        return ("[" + type + "] " + "[" + this.getStatusIcon() + "]" + " " + this.description);
    }

    public static int getTotalTask() {
        return totalTasks;
    }
    public int getTaskNumber() {
        return taskNumber;
    }


    public String toString() {
        return "  [" + type + "]" + "[" + getStatusIcon() + "] " + description;
    }

}
