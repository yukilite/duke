
public class Tasks {

    protected String description;
    protected boolean isDone;
    protected int number;
    protected String type;

    private static int currTaskNumber = 1;

    public Tasks(String description, String type) {
        this.description = description;
        this.type = type;
        this.number = currTaskNumber;
        currTaskNumber += 1;

    }

    public Tasks(String description) {
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone (boolean isDone) {
        this.isDone = true;
    }
    public int getTaskNumber() {
        return number;
    }
    public void setTaskNumber() {
        this.number = number;
    }


    @Override
    public String toString() {
        return "[" + type + "]" + "[" + getStatusIcon() + "] " + description;
    }
    
}
