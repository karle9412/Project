package com.project.user.vo;

public class UserVo {

    private String userid;
    private String passwd;
    private String nickname;
    private String email;
    private String user_local;
    private String rider;
    private String indate;

    public UserVo (){}
    public UserVo(String userid, String passwd, String nickname, String email, String user_local, String rider, String indate) {
        this.userid = userid;
        this.passwd = passwd;
        this.nickname = nickname;
        this.email = email;
        this.user_local = user_local;
        this.rider = rider;
        this.indate = indate;
    }

    public String getuserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_local() {
        return this.user_local;
    }

    public void setUserLocal(String user_local) {
        this.user_local = user_local;
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
                "userid='" + this.userid + '\'' +
                ", passwd='" + this.passwd + '\'' +
                ", nickname='" + this.nickname + '\'' +
                ", email='" + this.email + '\'' +
                ", userLocal='" + this.user_local + '\'' +
                ", rider='" + this.rider + '\'' +
                ", indate='" + this.indate + '\'' +
                '}';
    }
}
