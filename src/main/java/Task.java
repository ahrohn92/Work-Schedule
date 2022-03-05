import java.util.Date;
import java.util.List;

public class Task {

    private String desc;
    private List<Task> subTasks;
    private boolean isComplete = false;
    private Date date;


    public Task(String desc) {
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "";
    }
}
