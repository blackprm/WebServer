package com.sinjinsong.webserver.sample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sinjinsong
 * @date 2018/5/3
 */
@Data
public class User {
    private String username;
    private String password;
    private String realName;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public User() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public String getRealName() {
        return realName;
    }

    public Integer getAge() {
        return age;
    }

    public User(String username, String password, String realName, Integer age) {
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.age = age;
    }
}
