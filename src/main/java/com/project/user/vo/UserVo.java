package com.project.user.vo;

public class UserVo {

    private String userid;
    private String passwd;
    private String nickname;
    private String email;
    private String user_local;
    private String rider;
    private String indate;
    private String phonenumber;

    public UserVo (){}

    public UserVo(String userid, String passwd, String nickname, String email, String user_local, String rider, String indate, String phonenumber) {
        this.userid = userid;
        this.passwd = passwd;
        this.nickname = nickname;
        this.email = email;
        this.user_local = user_local;
        this.rider = rider;
        this.indate = indate;
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() { return phonenumber; }

    public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }

    public String getUserid() {
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

    public void setUser_local(String user_local) {
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
                "userid='" + userid + '\'' +
                ", passwd='" + passwd + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", user_local='" + user_local + '\'' +
                ", rider='" + rider + '\'' +
                ", indate='" + indate + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
