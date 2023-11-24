package Notridame.com.br.Gs.application;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MyScheduledService {

    @Scheduled(fixedDelay = Long.MAX_VALUE)
    public void keepRunning() {

        System.out.println("Aplicação está em execução...");
    }
}
