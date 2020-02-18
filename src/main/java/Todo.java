package duke; 

public class Todo extends Tasks {

    protected String type;

    public Todo (String description, String type) {
        super(description, type);

    }
    @Override
    public String getFileContents() {
        return String.format("T|%s|%s", this.isDone, this.description);
    }
}
