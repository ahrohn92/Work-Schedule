package column.taskgroup;

import column.taskgroup.task.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskGroup {

    private Optional<String> mTitle;
    private List<Task> mTasks;
    private EPriority ePriority;

    private TaskGroup(TaskGroupBuilder pBuilder) {
        mTitle = pBuilder.mTitle;
        mTasks = pBuilder.mTasks;
        ePriority = pBuilder.ePriority;
    }
    
    public void addTask(Task pTask) {
    	mTasks.add(pTask);
    }

    public void setTitle(String pTitle) {
        // NEED VALIDATION
        mTitle = Optional.ofNullable(pTitle);
    }

    public Optional<String> getTitle() {
        return mTitle;
    }

    public List<Task> getTasks() {
        return mTasks;
    }

    public void setPriority(EPriority pPriority) {
        // NEED VALIDATION
        ePriority = pPriority;
    }

    public EPriority getPriority() {
        return ePriority;
    }

    @Override
    public String toString() {
        return "TaskGroup{" +
                "mTitle=" + mTitle +
                ", mTasks=" + mTasks +
                ", ePriority=" + ePriority +
                '}';
    }

    public static class TaskGroupBuilder {

        private Optional<String> mTitle;
        private List<Task> mTasks;
        private EPriority ePriority;

        public TaskGroupBuilder setTitle(String pTitle) {
            mTitle = Optional.ofNullable(pTitle);
            return this;
        }

        public TaskGroupBuilder setTasks(List<Task> pTasks) {
            mTasks = pTasks;
            return this;
        }

        public TaskGroupBuilder setPriority(EPriority pPriority) {
            ePriority = pPriority;
            return this;
        }

        public TaskGroup build() {
            if (mTasks == null) {
                mTasks = new ArrayList<Task>();
                mTasks.add(new Task.TaskBuilder().build());
            }
            ePriority = ePriority == null ? EPriority.UNKNOWN : ePriority;
            return new TaskGroup(this);
        }
    }
}