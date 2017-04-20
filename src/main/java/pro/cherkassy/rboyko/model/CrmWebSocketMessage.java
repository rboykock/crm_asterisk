package pro.cherkassy.rboyko.model;

/**
 * Created by rboyko on 09.03.17.
 */
public class CrmWebSocketMessage {
    protected String extention;
    protected String user;

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
