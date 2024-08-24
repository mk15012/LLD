package dao.impl;

import dao.TaskDao;
import entity.Task;
import enums.Status;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


public class TaskDaoImpl implements TaskDao {

    private final Map<String, Task> taskMap;

    public TaskDaoImpl() {
        this.taskMap = new HashMap<>();
    }

    @Override
    public Task getTask(String taskId) throws Exception {
        validateTask(taskId);
        return taskMap.get(taskId);
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(taskMap.values());
    }


    @Override
    public Task addTask(String description, String headline, Date deadLine) {
        Task task = new Task(description, headline, deadLine);
        String taskId = UUID.randomUUID().toString();
        task.setId(taskId);
        taskMap.put(taskId, task);
        return task;
    }

    @Override
    public Task updateTask(String taskId, Task task) throws Exception {
        validateTask(taskId);
        return taskMap.put(taskId, task);
    }


    @Override
    public boolean deleteTask(String taskId) throws Exception {
        validateTask(taskId);
        taskMap.remove(taskId);
        return true;
    }

    @Override
    public List<Task> getAllTasksAssignedToUser(String userId) throws Exception {
        return taskMap.values().stream()
                .filter(task -> task.getUserId() != null && task.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Status, Long> getTaskCountByStatus() throws Exception {
        List<Task> tasks = getAllTasks();
        Map<Status, Long> taskCountByStatus = tasks.stream()
                .collect(Collectors.groupingBy(Task::getStatus, Collectors.counting()));

        for (Status status : Status.values()) {
            taskCountByStatus.putIfAbsent(status, 0L);
        }

        return taskCountByStatus;
    }

    private void validateTask(String taskId) throws Exception {
        if (!taskMap.containsKey(taskId)) {
            throw new Exception("Invalid taskId");
        }
    }
}
