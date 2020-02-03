public class Tasks {

    protected String description;
    protected boolean isDone;
    protected int taskNumber;
    protected String type;
    private static int totalTasks = 0;

    public Tasks(String description, String type) {
        this.description = description;
        totalTasks += 1;
        this.taskNumber = totalTasks;
        this.type = type;

    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone (boolean isDone) {
        this.isDone = true;
    }
    public static int getTotalTask() {
        return totalTasks;
    }
    public int getTaskNumber() {
        return taskNumber;
    }
    @Override
    public String toString() {
        return "[" + type + "]" + "[" + getStatusIcon() + "] " + description;
    }

}
