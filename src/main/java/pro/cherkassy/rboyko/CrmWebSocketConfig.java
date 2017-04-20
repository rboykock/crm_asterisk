package pro.cherkassy.rboyko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import pro.cherkassy.rboyko.websocket.CrmWebSocketHandler;

/**
 * Created by rboyko on 06.03.17.
 */
@Configuration
@EnableWebSocket
@EnableScheduling
public class CrmWebSocketConfig implements WebSocketConfigurer {

    protected Logger log= LoggerFactory.getLogger(CrmWebSocketConfig.class);

    @Autowired
    CrmWebSocketHandler webSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        log.info("CrmWebSocket register");
        webSocketHandlerRegistry.addHandler(webSocketHandler,"/asterisk").withSockJS();
    }
}
