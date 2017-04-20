package pro.cherkassy.rboyko;

import ch.loway.oss.ari4java.ARI;
import ch.loway.oss.ari4java.AriFactory;
import ch.loway.oss.ari4java.AriVersion;
import ch.loway.oss.ari4java.generated.AsteriskInfo;
import ch.loway.oss.ari4java.generated.Channel;
import ch.loway.oss.ari4java.generated.Endpoint;
import ch.loway.oss.ari4java.tools.ARIException;
import ch.loway.oss.ari4java.tools.http.NettyHttpClient;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.socket.TextMessage;
import pro.cherkassy.rboyko.model.User;
import pro.cherkassy.rboyko.session.CrmWebSocketSession;

import javax.persistence.EntityManagerFactory;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by rboyko on 28.11.16.
 */
@SpringBootApplication
@Import({CrmWebSocketConfig.class,DataJPAConfig.class})
public class Application {

    @Autowired
    private CrmWebSocketSession crmWebSocketSession;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    private Logger log= LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

    //@Scheduled(fixedDelay = 5000)
    private void checkChanalsStatus() throws IOException, URISyntaxException, ARIException {
        ARI  ari= AriFactory.nettyHttp("http://192.168.56.101:8088/","test","q1w2e3r4",AriVersion.ARI_1_5_0);
        AsteriskInfo info = ari.asterisk().getInfo("");
        List<Channel> channels = ari.channels().list();
        List<Endpoint> endpoints = ari.endpoints().list();

        for (Endpoint endpoint : endpoints) {
            System.out.println("Ресурс " + endpoint.getResource());
            System.out.println("Технология " + endpoint.getTechnology());
            System.out.println("Состояние " + endpoint.getState());
        }


        System.out.println("There are " + channels.size() + " active channels now.");
        System.out.println( "System up since " + info.getStatus().getStartup_time() );
        System.out.println("OS: " + info.getBuild().getOs());
        System.out.println("Ядро: " + info.getBuild().getKernel());
        System.out.println("Архитектура: " + info.getBuild().getMachine());
        System.out.println("Последний reload: " + info.getStatus().getLast_reload_time());
        System.out.println("Версия Астериска" + info.getSystem().getVersion());

    }
}
