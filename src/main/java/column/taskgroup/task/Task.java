package column.taskgroup.task;

import java.util.List;

public class Task {

    private String mName;
    private List<Task> mSubTasks;
    private boolean mIsComplete;

    private Task(Task.TaskBuilder pBuilder) {
        mName = pBuilder.mName;
        mSubTasks = pBuilder.mSubTasks;
        mIsComplete = pBuilder.mIsComplete;
    }

    public void setName(String pName) {
        // NEED VALIDATION
        mName = pName;
    }

    public String getName() {
        return mName;
    }

    public void setSubTasks(List<Task> pSubTasks) {
        // NEED VALIDATION
        mSubTasks = pSubTasks;
    }

    public List<Task> getSubTasks() {
        return mSubTasks;
    }

    public void setComplete(boolean pIsComplete) {
        // NEED VALIDATION
        mIsComplete = pIsComplete;
    }

    public boolean isComplete() {
        return mIsComplete;
    }

    @Override
    public String toString() {
        return "Task{" +
                "mName='" + mName + '\'' +
                ", mSubTasks=" + mSubTasks +
                ", mIsComplete=" + mIsComplete +
                '}';
    }

    public static class TaskBuilder {

        private String mName;
        private List<Task> mSubTasks;
        private boolean mIsComplete;

        public TaskBuilder() {
            // MANDATORY VARIABLES ARE SET HERE, THESE VARIABLES SHOULD BE SET TO FINAL
        }

        public TaskBuilder setName(String pName) {
            mName = pName;
            return this;
        }

        public TaskBuilder setSubTasks(List<Task> pSubTasks) {
            mSubTasks = pSubTasks;
            return this;
        }

        public TaskBuilder setIsComplete(boolean pIsComplete) {
            mIsComplete = pIsComplete;
            return this;
        }

        public Task build() {
            Task task = new Task(this);
            validateTask(task);
            return task;
        }

        private void validateTask(Task task) {
            // DO VALIDATION OF TASK OBJECT HERE
        }
    }
}
