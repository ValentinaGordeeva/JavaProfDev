package Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.micromata.opengis.kml.v_2_2_0.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;


@Service
public class ServiceSendingMes {


    @Autowired
    ServiceKeeping keeping;

    public void printQueueAsJson() throws InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();


        while (!keeping.queue.isEmpty()) {
            try {
                String item = keeping.queue.take();
                String json = objectMapper.writeValueAsString(item);
                System.out.println(json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

    }
}
