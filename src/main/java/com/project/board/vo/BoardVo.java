package com.project.board.vo;

public class BoardVo {

    private int board_number;
    private String menu_id;
    private String title;
    private String writer;
    private String board_local;
    private String cont;
    private String indate;
    private String board_check;

    public BoardVo(){}
    public BoardVo(int board_number, String menu_id, String title, String writer, String board_local, String cont, String indate, String board_check) {
        this.board_number = board_number;
        this.menu_id = menu_id;
        this.title = title;
        this.writer = writer;
        this.board_local = board_local;
        this.cont = cont;
        this.indate = indate;
        this.board_check = board_check;
    }

    public int getBoard_number() {
        return this.board_number;
    }

    public void setBoard_number(int board_number) {
        this.board_number = board_number;
    }

    public String getMenu_id() {
        return this.menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return this.writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getBoard_local() {
        return this.board_local;
    }

    public void setBoard_local(String board_local) {
        this.board_local = board_local;
    }

    public String getCont() {
        return this.cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getIndate() {
        return this.indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public String getBoard_check() {
        return this.board_check;
    }
    public void setBoard_check (String board_check) {
        this.board_check = this.board_check;
    }

    public BoardVo(int board_number, String menu_id,String title, String writer, String board_local, String cont, String indate) {
        this.board_number = board_number;
        this.menu_id = menu_id;
        this.title = title;
        this.writer = writer;
        this.board_local = board_local;
        this.cont = cont;
        this.indate = indate;
    }

    @Override
    public String toString() {
        return "BoardVo{" +
                "board_number=" + this.board_number +
                ", menu_id='" + this.menu_id + '\'' +
                ", title='" + this.title + '\'' +
                ", writer='" + this.writer + '\'' +
                ", board_local='" + this.board_local + '\'' +
                ", cont='" + this.cont + '\'' +
                ", indate='" + this.indate + '\'' +
                ", board_check='" + this.board_check + '\'' +
                '}';
    }
}
