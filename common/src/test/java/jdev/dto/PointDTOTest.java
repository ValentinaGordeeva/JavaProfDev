package jdev.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by jdev on 06.03.2017.
 */
public class PointDTOTest {

    private String expected = "{\"lat\":56.0,\"lon\":74.0,\"time\":1689922014518,\"autoId\":\"o567gfd\"}";
    private String aotoId = "o567gfd";

    @Test
    public void toJson() throws Exception {
        PointDTO point = new PointDTO();
        point.setLat(56);
        point.setLon(74);
        point.setAutoId("o567gfd");
        point.setTime(System.currentTimeMillis());
        assertTrue(point.toJson().contains("\"lat\":56"));
        assertTrue(point.toJson().contains("\"time\":"));
        System.out.println(point.toJson());
    }
    //  преобразования из объекта в json
    @Test
    public void decodeDto() throws Exception{
        ObjectMapper mapper = new ObjectMapper(); // создаем объект, который будет использоваться для преобразования json в объект
        PointDTO dto =mapper.readValue(expected, PointDTO.class);// метод readValue преобразовывает json в объект PointDTO
        assertEquals(aotoId, dto.getAutoId()); // проверка вывода
        assertEquals(1689922014518L, dto.getTime());// проверка вывода
    }

}