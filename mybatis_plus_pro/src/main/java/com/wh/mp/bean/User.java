package com.wh.mp.bean;

import com.baomidou.mybatisplus.annotation.TableLogic;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-04-23 16:15
 */
public class User {

    private Integer id;
    private String username;
    @TableLogic
    private Integer logicDel;

    public User() {
    }

    public User(Integer id, String username, Integer logicDel) {
        this.id = id;
        this.username = username;
        this.logicDel = logicDel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getLogicDel() {
        return logicDel;
    }

    public void setLogicDel(Integer logicDel) {
        this.logicDel = logicDel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", logicDel=" + logicDel +
                '}';
    }
}
