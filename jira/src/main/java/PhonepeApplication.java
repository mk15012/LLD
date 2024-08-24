import dao.StoryDao;
import dao.SubTaskDao;
import dao.TaskDao;
import dao.UserDao;
import dao.impl.StoryDaoImpl;
import dao.impl.SubTaskDaoImpl;
import dao.impl.TaskDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Story;
import entity.SubTask;
import entity.Task;
import enums.Status;
import manager.StoryManager;
import manager.SubTaskManager;
import manager.TaskManager;
import manager.UserManager;
import manager.impl.StoryManagerImpl;
import manager.impl.SubTaskManagerImpl;
import manager.impl.TaskManagerImpl;
import manager.impl.UserManagerImpl;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PhonepeApplication {

    public static void main(String[] args) {

        UserDao userDao = new UserDaoImpl();
        StoryDao storyDao = new StoryDaoImpl();
        TaskDao taskDao = new TaskDaoImpl();
        SubTaskDao subTaskDao = new SubTaskDaoImpl();

        UserManager userManager = new UserManagerImpl(userDao, taskDao);
        StoryManager storyManager = new StoryManagerImpl(storyDao, userDao);
        TaskManager taskManager = new TaskManagerImpl(taskDao, userDao, storyDao);
        SubTaskManager subTaskManager = new SubTaskManagerImpl(subTaskDao, taskDao);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        Date deadline = calendar.getTime();

        // create User
        createUser(userManager);

        // create Task
        createTask(taskManager, deadline);

        // create SubTask
        createSubTask(taskManager, subTaskManager, deadline);

        // create Story
        createStory(taskManager, storyManager, deadline);

        // Move Task
        moveTask(taskManager, storyManager, deadline);

        // assign a task to user
        assignTaskToUser(taskManager, "mukund@phonepe.com");

        // get tasks assigned to a User
        getAllTasksAssignedToUser(taskManager,"mukund@phonepe.com");

        // get UserWorkload
        getUserWorkload(userManager);

        // Get Task Count by Status
        getTaskCountByStatus(taskManager);

    }


    private static void createUser(UserManager userManager) {
        try {
            userManager.createUser("Rohan", "rohan@phonepe.com");
            userManager.createUser("Mukund", "mukund@phonepe.com");
        } catch (Exception e) {
            System.err.println("Failed to create user: " + e.getMessage());
        }
    }

    private static void createTask(TaskManager taskManager, Date deadline) {
        try {
            Task task = taskManager.createTask("Task 1", "Description for Task 1", deadline);
            System.out.println("Task created : " + task.toString());
        } catch (Exception e) {
            System.err.println("Failed to create task: " + e.getMessage());
        }
    }

    private static void createSubTask(TaskManager taskManager, SubTaskManager subTaskManager, Date deadline) {
        try {
            Task task = taskManager.createTask("Task 1", "Description for Task 1", deadline);
            SubTask subTask = subTaskManager.createSubtask(task.getId(), "Subtask 1", "Description for Subtask 1", deadline);
            System.out.println("SubTask created : " + subTask.toString());
        } catch (Exception e) {
            System.err.println("Failed to create subtask: " + e.getMessage());
        }
    }

    private static void createStory(TaskManager taskManager, StoryManager storyManager, Date deadline) {
        try {
            Task task = taskManager.createTask("Task 1", "Description for Task 1", deadline);
            List<Task> tasks = Collections.singletonList(task);
            Story story = storyManager.createStory("Story 1", "Description for Story 1", tasks);
            System.out.println("Story created : " + story.toString());
        } catch (Exception e) {
            System.err.println("Failed to create story: " + e.getMessage());
        }
    }

    private static void moveTask(TaskManager taskManager, StoryManager storyManager, Date deadline) {
        try {
            Task task1 = taskManager.createTask("Task 1", "Description for Task 1", deadline);
            Task task2 = taskManager.createTask("Task 2", "Description for Task 2", deadline);

            List<Task> initialTaskList = Collections.singletonList(task1);
            List<Task> formerTaskList = Collections.singletonList(task2);

            Story story1 = storyManager.createStory("Story 1", "Description for Story 1", initialTaskList);
            Story story2 = storyManager.createStory("Story 2", "Description for Story 2", formerTaskList);

            taskManager.moveTask(task1.getId(), story2.getId());
            System.out.println("Task moved successfully from parent " + task1.getParentStoryId() + " to " + story2.getId());
        } catch (Exception e) {
            System.err.println("Failed to move task: " + e.getMessage());
        }
    }

    private static void getUserWorkload(UserManager userManager) {
        try {
            List<Task> userWorkload = userManager.getUserWorkload("mukund@phonepe.com");
            if (userWorkload.isEmpty()) {
                System.out.println("User doesn't have any tickets assigned");
            } else {
                System.out.println("User workload : " + userWorkload);
            }
        } catch (Exception e) {
            System.err.println("Failed to get user workload : " + e.getMessage());
        }
    }

    private static void assignTaskToUser(TaskManager taskManager, String email) {
        try {
            Task task = taskManager.getAllTasks().get(0);
            boolean result = taskManager.assignTaskToUser(task.getId(), email);
            if (result) {
                System.out.println("Task assigned successfully to user.");
            } else {
                System.out.println("Failed to assign task to user.");
            }
        } catch (Exception e) {
            System.err.println("Error assigning task to user: " + e.getMessage());
        }
    }

    private static void getAllTasksAssignedToUser(TaskManager taskManager, String email) {
        try {
            List<Task> result = taskManager.getAllTasksAssignedToUser(email);
            if (result.isEmpty()) {
                System.out.println("No task assigned to user.");
            } else {
                System.out.println("Tasks assigned to the user : " + result);
            }
        } catch (Exception e) {
            System.err.println("Error fetching task assigned to user: " + e.getMessage());
        }
    }


    private static void getTaskCountByStatus(TaskManager taskManager) {
        try {
            Map<Status, Long> taskCountByStatus = taskManager.getTaskCountByStatus();
            System.out.println("Task count by status: " + taskCountByStatus);
        } catch (Exception e) {
            System.err.println("Failed to get task count by status: " + e.getMessage());
        }
    }

}
