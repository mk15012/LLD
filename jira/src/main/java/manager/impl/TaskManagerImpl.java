package manager.impl;

import dao.StoryDao;
import dao.TaskDao;
import dao.UserDao;
import entity.Story;
import entity.Task;
import entity.User;
import enums.Status;
import lombok.AllArgsConstructor;
import manager.TaskManager;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@AllArgsConstructor
public class TaskManagerImpl implements TaskManager {

    
    TaskDao taskDao;
    UserDao userDao;
    StoryDao storyDao;

    @Override
    public Task getTask(String taskId) throws Exception {
        return taskDao.getTask(taskId);
    }

    @Override
    public List<Task> getAllTasks() throws Exception {
        return taskDao.getAllTasks();
    }

    @Override
    public Task createTask(String description, String headline, Date deadLine) throws Exception {
        return taskDao.addTask(description, headline, deadLine);
    }

    @Override
    public Task updateTask(String taskId, Task task) throws Exception {
        return taskDao.updateTask(taskId, task);
    }

    @Override
    public boolean deleteTask(String taskId) throws Exception {
        taskDao.deleteTask(taskId);
        return true;
    }

    @Override
    public List<Task> getAllTasksAssignedToUser(String email) throws Exception {

        User user = userDao.getUser(email);
        if (Objects.isNull(user)) {
            throw new Exception("No such user exists");
        }
        return taskDao.getAllTasksAssignedToUser(user.getUserId());
    }


    @Override
    public void moveTask(String taskId, String newParentId) throws Exception {
        Task task = taskDao.getTask(taskId);
        if (Objects.isNull(task)) {
            throw new Exception("Task not found");
        }

        Story newParentTask = storyDao.getStory(newParentId);
        if (Objects.isNull(newParentTask)) {
            throw new Exception("New parent task not found");
        }

        task.setParentStoryId(newParentTask.getId());
        taskDao.updateTask(taskId, task);
    }


    @Override
    public boolean assignTaskToUser(String taskId, String email) throws Exception {
        Task task = taskDao.getTask(taskId);
        if (task == null) {
            throw new Exception("Task not found");
        }

        User user = userDao.getUser(email);
        if (user == null) {
            throw new Exception("User not found");
        }

        task.setUserId(user.getUserId());
        task.setStatus(Status.ASSIGNED);
        taskDao.updateTask(taskId, task);
        return true;
    }

    @Override
    public Map<Status, Long> getTaskCountByStatus() throws Exception {
        return taskDao.getTaskCountByStatus();
    }
}
