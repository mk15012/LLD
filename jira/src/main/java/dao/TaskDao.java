package dao;

import entity.Task;
import enums.Status;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TaskDao {

    Task getTask(String taskId) throws Exception;

    List<Task> getAllTasks();

    Task addTask(String description, String headline, Date deadLine);

    Task updateTask(String taskId, Task task) throws Exception;

    boolean deleteTask(String taskId) throws Exception;

    List<Task> getAllTasksAssignedToUser(String userId) throws Exception;

    Map<Status, Long> getTaskCountByStatus() throws Exception;


}
