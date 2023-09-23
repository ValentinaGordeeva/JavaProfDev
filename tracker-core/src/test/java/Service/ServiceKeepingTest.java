package Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.concurrent.BlockingDeque;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ServiceKeepingTest {
/*
    @Mock
    BlockingDeque<String> queue;
    @Mock
    ServiceGPS servergps;
    @Mock
    ServiceSendingMes serviceSendingMes;
    @InjectMocks
    ServiceKeeping serviceKeeping;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void put() throws InterruptedException{
        when(queue.take()).thenReturn("42.47788551372969,43.266325763217,2353,4");
        serviceKeeping.take();
        // Проверка вызова метода take()
        verify(queue).take();
        // Проверка вызова метода sendCoordinates
        verify(serviceSendingMes).sendCoordinates("42.47788551372969,43.266325763217,2353,4");
    }

    @Test
    void take() throws InterruptedException{
        when(servergps.timer()).thenReturn(Arrays.asList("42.47788551372969,43.266325763217,2353,4"));
        serviceKeeping.put();
        // Проверка вызова метода add()

        verify(queue).add("[42.47788551372969,43.266325763217,2353,4],0");
        // Проверка вызова метода timer()
        verify(servergps).timer();
    }

 */
}