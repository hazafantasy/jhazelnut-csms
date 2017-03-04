package jhazelnut.beans;

public class JhDriveDropBoxTestBean {
    private String statusMsg;

    public JhDriveDropBoxTestBean(String statusMsg) {
        this.setStatusMsg(statusMsg);
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
}
