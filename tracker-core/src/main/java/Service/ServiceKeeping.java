package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Service
@Component
public class ServiceKeeping {
    public long previous;
    BlockingDeque<String> queue =  new LinkedBlockingDeque<>(100);
    @Autowired
    ServiceGPS servergps;
    @Autowired
    ServiceSendingMes serviceSendingMes;
    private int putCount;


   @PostConstruct
   @Scheduled (fixedDelay = 2_000)
  void put() throws InterruptedException {
       int i = putCount++;
       List<String> data = servergps.timer();
       queue.add(data + "," + i);
       //System.out.println(queue);
   }

    @Scheduled (fixedDelay =4000)
    void take() throws InterruptedException { //извлекаем  данные из очереди
        long current = System.currentTimeMillis();
        // String item = queue.take();
        //System.out.println((current - previous) + " Очередь по расписанию " + queue.poll(500, TimeUnit.MILLISECONDS));
        serviceSendingMes.sendCoordinates(queue.take());

        previous = current;

    }
 }



