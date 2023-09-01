package controller;

import classforcoordinates.Coordinates;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
class ControllerPOSTTest {
    @Mock
    Model modelMock;
    @InjectMocks
    ControllerPOST controller;

    @Test
    void receiveCoordinates() throws Exception {
        Coordinates coordinates = new Coordinates();
        coordinates.setIthem("[42.47788551372969,43.266325763217,2353,4],0");

        Model modelMock = Mockito.mock(Model.class);
        ControllerPOST controller = new ControllerPOST();

        String result = String.valueOf(controller.receiveCoordinates( coordinates,modelMock));
        assertEquals("<200 OK OK,The coordinates are received and written to a file,[]>",result);

    }
}