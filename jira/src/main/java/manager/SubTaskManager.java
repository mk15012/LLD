package manager;

import entity.SubTask;

import java.util.Date;

public interface SubTaskManager {

    SubTask createSubtask(String parentTaskId, String title, String description, Date deadline) throws Exception;

    SubTask getSubTask(String subTaskId) throws Exception ;

    SubTask updateSubTask(String subTaskId, SubTask subTask) throws Exception ;

    boolean deleteSubTask(String subTaskId) throws Exception ;

    void moveSubTask(String subTaskId, String newParentId) throws Exception;
}
