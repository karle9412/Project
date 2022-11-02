package com.project.board.vo;

public class BoardVo {
    // Fields
    private int boardnumber;
    private String menuid;
    private String userid;
    private String title;
    private String writer;
    private String boardlocal;
    private String cont;
    private String indate;

    // Getter / Setter
    public int getBoardnumber() {
        return boardnumber;
    }

    public void setBoardnumber(int boardnumber) {
        this.boardnumber = boardnumber;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getBoardlocal() {
        return boardlocal;
    }

    public void setBoardlocal(String boardlocal) {
        this.boardlocal = boardlocal;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    // Constructor
    public BoardVo(){}
    public BoardVo(int boardnumber, String menuid, String userid, String title, String writer, String boardlocal, String cont, String indate) {
        this.boardnumber = boardnumber;
        this.menuid = menuid;
        this.userid = userid;
        this.title = title;
        this.writer = writer;
        this.boardlocal = boardlocal;
        this.cont = cont;
        this.indate = indate;
    }

    // toString
    @Override
    public String toString() {
        return "BoardVo{" +
                "boardnumber=" + boardnumber +
                ", menuid='" + menuid + '\'' +
                ", userid='" + userid + '\'' +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", boardlocal='" + boardlocal + '\'' +
                ", cont='" + cont + '\'' +
                ", indate='" + indate + '\'' +
                '}';
    }
}
