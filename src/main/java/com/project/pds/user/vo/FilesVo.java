package com.project.pds.user.vo;

public class FilesVo {
    private String userid;
    private String fileName;
    private String fileExit;
    private String sFileName;

    public FilesVo(){}
    public FilesVo(String userid, String fileName, String fileExit, String sFileName) {
        this.userid = userid;
        this.fileName = fileName;
        this.fileExit = fileExit;
        this.sFileName = sFileName;
    }
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExit() {
        return fileExit;
    }

    public void setFileExit(String fileExit) {
        this.fileExit = fileExit;
    }

    public String getsFileName() {
        return sFileName;
    }

    public void setsFileName(String sFileName) {
        this.sFileName = sFileName;
    }

    @Override
    public String toString() {
        return "FilesVo{" +
                " userid='" + userid + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileExit='" + fileExit + '\'' +
                ", sFileName='" + sFileName + '\'' +
                '}';
    }
}
