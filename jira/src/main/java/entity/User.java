package entity;

import lombok.Data;

@Data
public class User {

    private String userId;
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
