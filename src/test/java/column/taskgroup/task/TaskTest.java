package column.taskgroup.task;

import column.taskgroup.EPriority;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest {

    private static Task mTask1;
    private static Task mTask2;
    private static Task mSubTask;

    @BeforeAll
    static void setup() {
        mSubTask = new Task.TaskBuilder()
                .build();

        List<Task> subTasks = new ArrayList<Task>();
        subTasks.add(mSubTask);

        mTask1 = new Task.TaskBuilder()
                .setName("Task 1")
                .setSubTasks(subTasks)
                .setIsComplete(false)
                .setPriority(EPriority.LOW)
                .build();

        mTask2 = new Task.TaskBuilder()
                .build();
    }
    
    @Test
    void build_AllParams() {
        assertEquals("Task 1", mTask1.getName());
        assertTrue(Optional.ofNullable(mTask1.getSubTasks()).isPresent());
        assertEquals(1, mTask1.getSubTasks().get().size());
        assertFalse(mTask1.isComplete());
        assertEquals(EPriority.LOW, mTask1.getPriority());
    }
    
    @Test
    void build_NoParams() {
        assertEquals("New Task", mTask2.getName());
        assertEquals(Optional.empty(), Optional.ofNullable(mTask2.getSubTasks()));
        assertFalse(mTask2.isComplete());
        assertEquals(EPriority.UNKNOWN, mTask2.getPriority());
    }

    @Test
    void settersAndGetters_AllParamsBuild() {
        mTask1.setName("Task 2");
        mTask1.addSubTask(mSubTask);
        mTask1.setComplete(true);
        mTask1.setPriority(EPriority.HIGH);

        assertEquals("Task 2", mTask1.getName());
        assertEquals(2, mTask1.getSubTasks().get().size());
        assertTrue(mTask1.isComplete());
        assertEquals(EPriority.HIGH, mTask1.getPriority());
    }

    @Test
    void settersAndGetters_NoParamsBuild() {
        mTask2.setName("Task 3");
        mTask2.addSubTask(mSubTask);
        mTask2.setComplete(true);
        mTask2.setPriority(EPriority.MEDIUM);

        assertEquals("Task 3", mTask2.getName());
        assertTrue(Optional.ofNullable(mTask2.getSubTasks()).isPresent());
        assertEquals(1, mTask2.getSubTasks().get().size());
        assertTrue(mTask2.isComplete());
        assertEquals(EPriority.MEDIUM, mTask2.getPriority());
    }
}
