package Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
class ServiceGPSTest {
    @Mock
    BufferedReader br;
    @InjectMocks
    ServiceGPS servergps;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        servergps = new ServiceGPS();
        servergps.br = br;
    }
    @Test
    void testReadCoordinates() throws IOException {
        String testcoordinat = "42.47788551372969,43.266325763217,2353,4";

        when(br.readLine()).thenReturn(testcoordinat);

        servergps.readCoordinates();

        List<String> expectedCoordinates = Arrays.asList("42.47788551372969,43.266325763217,2353,4");

        assertEquals(expectedCoordinates,  servergps.result);
        
    }
    @Test
    void testTimer() throws IOException {
        when(br.readLine()).thenReturn("42.47788551372969,43.266325763217,2353,4");

        List<String> result = servergps.timer();

        List<String> expectedCoordinates = Arrays.asList("42.47788551372969,43.266325763217,2353,4");
        assertEquals(expectedCoordinates, result);


    }
}