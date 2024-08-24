package dao;

import entity.SubTask;

import java.util.Date;

public interface SubTaskDao {

    SubTask getSubTask(String subTaskId) throws Exception;

    SubTask addSubTask(String parentTaskId, String description, String headline, Date deadLine);

    SubTask updateSubTask(String subTaskId, SubTask subTask) throws Exception;

    boolean deleteSubTask(String subTaskId) throws Exception;

}
