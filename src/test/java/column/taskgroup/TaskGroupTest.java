package column.taskgroup;

import column.taskgroup.task.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskGroupTest {
	
	private static TaskGroup mTaskGroup1;
	private static TaskGroup mTaskGroup2;
	private static Task mTask;
	
	@BeforeAll
	static void setup() {
		mTask = new Task.TaskBuilder()
				.build();
		
		List<Task> mTasks = new ArrayList<Task>();
		mTasks.add(mTask);
		
		mTaskGroup1 = new TaskGroup.TaskGroupBuilder()
				.setTitle("Chores")
				.setTasks(mTasks)
				.setPriority(EPriority.VERY_LOW)
				.build();
		
		mTaskGroup2 = new TaskGroup.TaskGroupBuilder()
				.build();
	}
	
	@Test
	void build_AllParams() {
		assertTrue(Optional.ofNullable(mTaskGroup1.getTitle()).isPresent());
		assertEquals("Chores", mTaskGroup1.getTitle().get());
		assertEquals(1, mTaskGroup1.getTasks().size());
		assertEquals(EPriority.VERY_LOW, mTaskGroup1.getPriority());
	}
	
	@Test
	void build_NoParams() {
    	assertEquals(Optional.empty(), Optional.ofNullable(mTaskGroup2.getTitle()));
    	assertEquals(1, mTaskGroup2.getTasks().size());
    	assertEquals(EPriority.UNKNOWN, mTaskGroup2.getPriority());
	}
	
	@Test
	void settersAndGetters_AllParamsBuild() {
		mTaskGroup1.setTitle("Homework");
		mTaskGroup1.addTask(mTask);
		mTaskGroup1.setPriority(EPriority.VERY_HIGH);
		
		assertEquals("Homework", mTaskGroup1.getTitle().get());
		assertEquals(2, mTaskGroup1.getTasks().size());
		assertEquals(EPriority.VERY_HIGH, mTaskGroup1.getPriority());
	}
	
    @Test
    void settersAndGetters_NoParamsBuild() {
		mTaskGroup2.setTitle("Errands");
		mTaskGroup2.addTask(mTask);
		mTaskGroup2.setPriority(EPriority.MEDIUM);
		
		assertTrue(Optional.ofNullable(mTaskGroup2.getTitle()).isPresent());
		assertEquals("Errands", mTaskGroup2.getTitle().get());
    	assertEquals(2, mTaskGroup2.getTasks().size());
    	assertEquals(EPriority.MEDIUM, mTaskGroup2.getPriority());
    }
}
