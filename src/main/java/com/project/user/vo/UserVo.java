package com.project.user.vo;

public class UserVo {

    private String userId;
    private String passwd;
    private String username;
    private String email;
    private String userLocal;
    private String rider;
    private String indate;

    public UserVo (){}
    public UserVo(String userId, String passwd, String username, String email, String userLocal, String rider, String indate) {
        this.userId = userId;
        this.passwd = passwd;
        this.username = username;
        this.email = email;
        this.userLocal = userLocal;
        this.rider = rider;
        this.indate = indate;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserLocal() {
        return this.userLocal;
    }

    public void setUserLocal(String userLocal) {
        this.userLocal = userLocal;
    }

    public String getRider() {
        return this.rider;
    }

    public void setRider(String rider) {
        this.rider = rider;
    }

    public String getIndate() {
        return this.indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userid='" + this.userId + '\'' +
                ", passwd='" + this.passwd + '\'' +
                ", username='" + this.username + '\'' +
                ", email='" + this.email + '\'' +
                ", userLocal='" + this.userLocal + '\'' +
                ", rider='" + this.rider + '\'' +
                ", indate='" + this.indate + '\'' +
                '}';
    }
}
