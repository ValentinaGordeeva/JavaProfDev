package Service;

import application.Coordinates;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Component
public class ServiceSendingMes {
    @Autowired
    ServiceKeeping keeping;
    @Autowired
    RestTemplate restTemplate;

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