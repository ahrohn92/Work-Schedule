package column.taskgroup.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import column.taskgroup.EPriority;

public class Task {

    private String mName;
    private Optional<List<Task>> mSubTasks;
    private boolean mIsComplete;
    private EPriority ePriority;

    private Task(Task.TaskBuilder pBuilder) {
        mName = pBuilder.mName;
        mSubTasks = pBuilder.mSubTasks;
        mIsComplete = pBuilder.mIsComplete;
        ePriority = pBuilder.ePriority;
    }

    public void addSubTask(Task pTask) {
        if (!Optional.ofNullable(mSubTasks).isPresent()) {
            mSubTasks = Optional.ofNullable(new ArrayList<Task>());
        }
        mSubTasks.get().add(pTask);
    }

    public void setName(String pName) {
        // NEED VALIDATION
        mName = pName;
    }

    public String getName() {
        return mName;
    }

    public Optional<List<Task>> getSubTasks() {
        return mSubTasks;
    }

    public void setComplete(boolean pIsComplete) {
        // NEED VALIDATION
        mIsComplete = pIsComplete;
    }

    public boolean isComplete() {
        return mIsComplete;
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
        return "Task{" +
                "mName='" + mName + '\'' +
                ", mSubTasks=" + mSubTasks +
                ", mIsComplete=" + mIsComplete +
                ", ePriority=" + ePriority +
                '}';
    }

    public static class TaskBuilder {

        private String mName;
        private Optional<List<Task>> mSubTasks;
        private boolean mIsComplete;
        private EPriority ePriority;

        public TaskBuilder setName(String pName) {
            mName = pName;
            return this;
        }

        public TaskBuilder setSubTasks(List<Task> pSubTasks) {
            mSubTasks = Optional.ofNullable(pSubTasks);
            return this;
        }

        public TaskBuilder setIsComplete(boolean pIsComplete) {
            mIsComplete = pIsComplete;
            return this;
        }

        public TaskBuilder setPriority(EPriority pPriority) {
            ePriority = pPriority;
            return this;
        }

        public Task build() {
            mName = mName == null || mName.isEmpty() ? "New Task" : mName;
            ePriority = ePriority == null ? EPriority.UNKNOWN : ePriority;
            return new Task(this);
        }
    }
}
