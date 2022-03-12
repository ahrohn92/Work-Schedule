package column;

import column.taskgroup.TaskGroup;

import java.util.Date;
import java.util.List;

public class Column {

    private final Date mDate;
    private List<TaskGroup> mTaskGroups;

    private Column(ColumnBuilder builder) {
        mDate = builder.mDate;
        mTaskGroups = builder.mTaskGroups;
    }

    public Date getDate() {
        return mDate;
    }

    public void setTaskGroups(List<TaskGroup> pTaskGroups) {
        // NEED VALIDATION
        mTaskGroups = pTaskGroups;
    }

    public List<TaskGroup> getTaskGroups() {
        return mTaskGroups;
    }

    @Override
    public String toString() {
        return "Column{" +
                "mDate=" + mDate +
                ", mTaskGroups=" + mTaskGroups +
                '}';
    }

    public static class ColumnBuilder {

        private final Date mDate;
        private List<TaskGroup> mTaskGroups;

        public ColumnBuilder(Date pDate) {
            // MANDATORY VARIABLES ARE SET HERE, THESE VARIABLES SHOULD BE SET TO FINAL
            mDate = pDate;
        }

        public ColumnBuilder setTaskGroups(List<TaskGroup> pTaskGroups) {
            mTaskGroups = pTaskGroups;
            return this;
        }

        public Column build() {
            Column column = new Column(this);
            validateColumn(column);
            return column;
        }

        private void validateColumn(Column pColumn) {
            // DO VALIDATION OF COLUMN OBJECT HERE
        }
    }
}
