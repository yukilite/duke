package duke.task;

public class Todo extends Tasks {

    protected String type;

    public Todo (String description) {
        super(description);

    }
    @Override
    public String getFileContents() {
        return "[T][" + super.getStatusIcon() + "] " + super.description;
    }
}
