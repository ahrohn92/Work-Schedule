package column.taskgroup;

import column.taskgroup.task.Task;

import java.util.List;

public class TaskGroup {

    private String mTitle;
    private List<Task> mTasks;
    private int mColumnIndex;

    private TaskGroup(TaskGroupBuilder pBuilder) {
        mTitle = pBuilder.mTitle;
        mTasks = pBuilder.mTasks;
        mColumnIndex = pBuilder.mColumnIndex;
    }

    public void setTitle(String pTitle) {
        // NEED VALIDATION
        mTitle = pTitle;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTasks(List<Task> pTasks) {
        // NEED VALIDATION
        mTasks = pTasks;
    }

    public List<Task> getTasks() {
        return mTasks;
    }

    public void setColumnIndex(int pColumnIndex) {
        // NEED VALIDATION
        mColumnIndex = pColumnIndex;
    }

    public int getColumnIndex() {
        return mColumnIndex;
    }

    @Override
    public String toString() {
        return "TaskGroup{" +
                "title='" + mTitle + '\'' +
                ", tasks=" + mTasks +
                ", columnIndex=" + mColumnIndex +
                '}';
    }

    public static class TaskGroupBuilder {

        private String mTitle;
        private List<Task> mTasks; // SET TO FINAL
        private int mColumnIndex;

        public TaskGroupBuilder() {
            // MANDATORY VARIABLES ARE SET HERE, THESE VARIABLES SHOULD BE SET TO FINAL
        }

        public TaskGroupBuilder setTitle(String pTitle) {
            mTitle = pTitle;
            return this;
        }

        public TaskGroupBuilder setTasks(List<Task> pTasks) {
            mTasks = pTasks;
            return this;
        }

        public TaskGroupBuilder setColumnIndex(int pColumnIndex) {
            mColumnIndex = pColumnIndex;
            return this;
        }

        public TaskGroup build() {
            TaskGroup taskGroup = new TaskGroup(this);
            validateTaskGroup(taskGroup);
            return taskGroup;
        }

        private void validateTaskGroup(TaskGroup pTaskGroup) {
            // DO VALIDATION OF TASK GROUP OBJECT HERE
        }
    }
}