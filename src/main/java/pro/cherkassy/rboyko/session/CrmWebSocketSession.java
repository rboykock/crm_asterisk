package pro.cherkassy.rboyko.session;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import pro.cherkassy.rboyko.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rboyko on 09.03.17.
 */
@Component
public class CrmWebSocketSession {
    protected List<User> users=new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUserSession(User user) {
        this.users.add(user);
    }

    public void rmUserSession(int index){
        users.remove(index);
    }
}
