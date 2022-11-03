package com.project.board.vo;

public class BoardVo {

    private int boardNumber;
    private String menuId;
    private String userId;
    private String title;
    private String writer;
    private String boardLocal;
    private String cont;
    private String indate;

    public int getBoard_number() {
        return board_number;
    }

    public void setBoard_number(int board_number) {
        this.board_number = board_number;
    }

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
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

    public String getBoard_local() {
        return board_local;
    }

    public void setBoard_local(String board_local) {
        this.board_local = board_local;
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

    public BoardVo(){}

    public BoardVo(int board_number, String menu_id, String userid, String title, String writer, String board_local, String cont, String indate) {
        this.board_number = board_number;
        this.menu_id = menu_id;
        this.userid = userid;
        this.title = title;
        this.writer = writer;
        this.board_local = board_local;
        this.cont = cont;
        this.indate = indate;
    }

    @Override
    public String toString() {
        return "BoardVo{" +
                "board_number=" + board_number +
                ", menu_id='" + menu_id + '\'' +
                ", userid='" + userid + '\'' +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", board_local='" + board_local + '\'' +
                ", cont='" + cont + '\'' +
                ", indate='" + indate + '\'' +
                '}';
    }
}
