package com.project.pds.rider.reply.vo;

public class RRFilesVo {
    private String file_num;
    private String rider_reply_number;
    private String fileName;
    private String fileExit;
    private String sFileName;

    public RRFilesVo (){}
    public RRFilesVo(String file_num, String rider_reply_number, String fileName, String fileExit, String sFileName) {
        this.file_num = file_num;
        this.rider_reply_number = rider_reply_number;
        this.fileName = fileName;
        this.fileExit = fileExit;
        this.sFileName = sFileName;
    }

    public RRFilesVo(String rider_reply_number, String fileName, String fileExit, String sFileName) {
        this.rider_reply_number = rider_reply_number;
        this.fileName = fileName;
        this.fileExit = fileExit;
        this.sFileName = sFileName;
    }

    public String getFile_num() {
        return this.file_num;
    }

    public void setFile_num(String file_num) {
        this.file_num = file_num;
    }

    public String getRider_reply_number() {
        return this.rider_reply_number;
    }

    public void setRider_reply_number(String rider_reply_number) {
        this.rider_reply_number = rider_reply_number;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExit() {
        return this.fileExit;
    }

    public void setFileExit(String fileExit) {
        this.fileExit = fileExit;
    }

    public String getsFileName() {
        return this.sFileName;
    }

    public void setsFileName(String sFileName) {
        this.sFileName = sFileName;
    }

    @Override
    public String toString() {
        return "RRFilesVo{" +
                "file_num='" + this.file_num + '\'' +
                ", rider_reply_number='" + this.rider_reply_number + '\'' +
                ", fileName='" + this.fileName + '\'' +
                ", fileExit='" + this.fileExit + '\'' +
                ", sFileName='" + this.sFileName + '\'' +
                '}';
    }
}
