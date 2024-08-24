package manager;

import entity.Task;
import enums.Status;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TaskManager {

    Task getTask(String taskId) throws Exception;

    List<Task> getAllTasks() throws Exception;

    Task createTask(String description, String headline, Date deadLine) throws Exception;

    Task updateTask(String taskId, Task task) throws Exception;

    boolean deleteTask(String taskId) throws Exception;

    List<Task> getAllTasksAssignedToUser(String email) throws Exception;

    void moveTask(String taskId, String newParentId) throws Exception;

    boolean assignTaskToUser(String taskId, String email) throws Exception;

    Map<Status, Long> getTaskCountByStatus() throws Exception;


}
