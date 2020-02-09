public class Event extends Tasks {
    protected String date;

    public Event (String description, String date) {
        super(description, "E");
        this.date = date;
    }
    public void setDate (String data) {
        this.date = date;
    }
    @Override
    public String toString() {
        return super.toString() + " (at: " + date + ")";
    }
}

