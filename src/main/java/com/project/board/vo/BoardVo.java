package com.project.board.vo;

public class BoardVo {
    // Fields
    private int boardNumber;
    private String menuId;
    private String userid;
    private String title;
    private String writer;
    private String boardLocal;
    private String cont;
    private String indate;

    // Getter / Setter

    public int getBoardNumber() {
        return boardNumber;
    }

    public void setBoardNumber(int boardNumber) {
        this.boardNumber = boardNumber;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
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

    public String getBoardLocal() {
        return boardLocal;
    }

    public void setBoardLocal(String boardLocal) {
        this.boardLocal = boardLocal;
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
    public BoardVo(int boardNumber, String menuId, String userid, String title, String writer, String boardLocal, String cont, String indate) {
        this.boardNumber = boardNumber;
        this.menuId = menuId;
        this.userid = userid;
        this.title = title;
        this.writer = writer;
        this.boardLocal = boardLocal;
        this.cont = cont;
        this.indate = indate;
    }


    // toString

    @Override
    public String toString() {
        return "BoardVo{" +
                "boardNumber=" + boardNumber +
                ", menuId='" + menuId + '\'' +
                ", userid='" + userid + '\'' +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", boardLocal='" + boardLocal + '\'' +
                ", cont='" + cont + '\'' +
                ", indate='" + indate + '\'' +
                '}';
    }
}
