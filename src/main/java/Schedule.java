import column.Column;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private List<Column> mColumns;

    public Schedule() {
        // LOAD COLUMNS FROM FILE OR DATABASE
        mColumns = getColumnsFromFile();
    }

    private List<Column> getColumnsFromFile() {
        // LOAD COLUMNS FROM FILE OR DATABASE
        // HANDLE ERRORS
        // SET TO mColumns
        return new ArrayList<>();
    }

    public List<Column> getColumns() {
        return mColumns;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "mColumns=" + mColumns +
                '}';
    }
}
