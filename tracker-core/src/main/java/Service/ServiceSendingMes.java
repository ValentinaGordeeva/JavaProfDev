package Service;


import jp.JpaApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import classforcoordinates.Coordinates;
@Service
@Component
public class ServiceSendingMes {

    @Autowired
    ServiceKeeping keeping;

    @Autowired         //  раскоментировать для 5 пр.р.
    RestTemplate restTemplate;

 /*

       private final RestTemplate restTemplate;

       public ServiceSendingMes(@Autowired RestTemplate restTemplate){
           this.restTemplate=restTemplate;
       }
*/

    public void sendCoordinates(String item) {
        // Создаем объект с данными координат

        Coordinates coordinates = new Coordinates();
        coordinates.setIthem(item);
        // Отправляем данные в виде jcon на адрес
        String url = "http://localhost:8080/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //для отправки запроса
        HttpEntity<Coordinates> requestEntity = new HttpEntity<>(coordinates, headers);
        restTemplate.postForObject(url, requestEntity, String.class);

    }

}
