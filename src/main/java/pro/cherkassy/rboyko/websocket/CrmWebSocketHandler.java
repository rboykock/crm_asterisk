package pro.cherkassy.rboyko.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import pro.cherkassy.rboyko.model.CrmWebSocketMessage;
import pro.cherkassy.rboyko.model.User;
import pro.cherkassy.rboyko.session.CrmWebSocketSession;

/**
 * Created by rboyko on 07.03.17.
 */
@Component
public class CrmWebSocketHandler extends TextWebSocketHandler{
    @Autowired
    private CrmWebSocketSession crmWebSocketSession;
    private Logger log= LoggerFactory.getLogger(CrmWebSocketHandler.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
  /*      log.info("Session id:"+session.getId()+" message: "+message.getPayload());
        ObjectMapper incomData=new ObjectMapper();
        CrmWebSocketMessage msg=incomData.readValue(message.getPayload(),CrmWebSocketMessage.class);
        log.info(msg.getExtention()+" "+msg.getUser());
        User user=new User(msg.getUser(),msg.getExtention());
        user.setSession(session);
        crmWebSocketSession.setUserSession(user);
*/
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
       log.info("Connection session id: "+session.getId());

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
/*        log.info("Disconnect session id: "+session.getId());
        int index=0;
        for (User user:crmWebSocketSession.getUsers()){
            if(user.getSession().getId()==session.getId()) {
                crmWebSocketSession.rmUserSession(index);
                return;
            }
            index++;
        }*/
    }
}
