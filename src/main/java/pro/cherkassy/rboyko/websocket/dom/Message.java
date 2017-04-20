package pro.cherkassy.rboyko.websocket.dom;

/**
 * Created by rboyko on 06.03.17.
 */
public class Message {
    protected String message;

    public Message() {
    }

    public Message(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
