package entity;

import enums.Status;
import lombok.Data;

import java.util.Date;

@Data
public class SubTask {

    private String id;
    private String userId;
    private String parentTaskId;
    private String title;
    private String description;
    private Status status;
    private Date createdOn;
    private Date deadLine;

    public SubTask(String parentTaskId, String title, String description, Date deadLine) {
        this.parentTaskId = parentTaskId;
        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
    }
}
