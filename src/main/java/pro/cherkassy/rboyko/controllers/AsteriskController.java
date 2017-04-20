package pro.cherkassy.rboyko.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import pro.cherkassy.rboyko.session.CrmWebSocketSession;
import pro.cherkassy.rboyko.websocket.dom.Message;


/**
 * Created by rboyko on 06.03.17.
 */
@Controller
public class AsteriskController {
    private Logger log= LoggerFactory.getLogger(AsteriskController.class);

    /*
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/asterisk")
    public void receiveMessage(Message message){
        log.info("Message get text: "+message.getMessage());
    }*/
}
