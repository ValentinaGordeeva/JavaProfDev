package Service;


import classforcoordinates.Coordinates;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ServiceSendingMesTest {
    @Mock
    RestTemplate restTemplate;
    @InjectMocks
    ServiceSendingMes sendmec;

    @Before
    public void setup() {
        restTemplate = mock(RestTemplate.class);
        sendmec = new ServiceSendingMes(restTemplate);
    }

    @Test
    public void testSendCoordinates() {
        String item = "[42.47788551372969,43.266325763217,2353,4],0";
        String expectedResponse = "<200 OK OK,The coordinates are received and written to a file,[]>";

        String url = "http://localhost:";
        Coordinates coordinates = new Coordinates();
        coordinates.setIthem(item);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Coordinates> requestEntity = new HttpEntity<>(coordinates, headers);
        ResponseEntity<String> responseEntity = ResponseEntity.ok(expectedResponse);
        when(restTemplate.postForEntity(url, requestEntity, String.class)).thenReturn(responseEntity);

        sendmec.sendCoordinates(item);

        ResponseEntity<String> actualResponseEntity = restTemplate.postForEntity(url, requestEntity, String.class);
        assertEquals(expectedResponse, actualResponseEntity.getBody());
    }

}