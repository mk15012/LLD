package manager.impl;

import dao.SubTaskDao;
import dao.TaskDao;
import entity.SubTask;
import entity.Task;
import lombok.AllArgsConstructor;
import manager.SubTaskManager;

import java.util.Date;
import java.util.Objects;


@AllArgsConstructor
public class SubTaskManagerImpl implements SubTaskManager {

    SubTaskDao subTaskDao;
    TaskDao taskDao;

    @Override
    public SubTask createSubtask(String parentTaskId, String title, String description, Date deadline) throws Exception {
        Task parentTask = taskDao.getTask(parentTaskId);
        if (Objects.isNull(parentTask)) {
            throw new Exception("Parent task not found");
        }
        SubTask subTask = new SubTask(parentTaskId, description, title, deadline);
        parentTask.getSubTaskList().add(subTask);
        taskDao.updateTask(parentTaskId, parentTask);
        return subTask;
    }

    @Override
    public SubTask getSubTask(String subTaskId) throws Exception {
        return subTaskDao.getSubTask(subTaskId);
    }

    @Override
    public SubTask updateSubTask(String subTaskId, SubTask subTask) throws Exception {
        return subTaskDao.updateSubTask(subTaskId, subTask);
    }
    
    @Override
    public boolean deleteSubTask(String subTaskId) throws Exception {
        subTaskDao.deleteSubTask(subTaskId);
        return true;
    }

    @Override
    public void moveSubTask(String subTaskId, String newParentId) throws Exception {
        SubTask subTask = subTaskDao.getSubTask(subTaskId);
        if (Objects.isNull(subTask)) {
            throw new Exception("Sub Task not found");
        }

        Task newParentTask = taskDao.getTask(newParentId);
        if (Objects.isNull(newParentTask)) {
            throw new Exception("New parent task not found");
        }

        subTask.setParentTaskId(newParentTask.getId());
        subTaskDao.updateSubTask(subTaskId, subTask);
    }

}
