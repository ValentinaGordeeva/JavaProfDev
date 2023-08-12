package controller;

import application.Coordinates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.MySrvice;

import java.io.*;
import java.nio.charset.Charset;

import org.springframework.stereotype.Service;
@Service
@RestController
public class ControllerPOST {
    MySrvice mesrvice;
    private final Logger logger = LoggerFactory.getLogger(ControllerPOST.class);
    @PostMapping("/")
    public ResponseEntity<String> receiveCoordinates(@RequestBody Coordinates coordinates) {
        logger.info("Полученные коордитаны: {}", coordinates);

        try {
            //запись координат в файл
            FileOutputStream fileOutputStream = new FileOutputStream("coordinates.txt", true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, Charset.forName("UTF-8"));
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(coordinates.toString());
            bufferedWriter.newLine();

            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();

            logger.info("Координаты записаны в файл");
            return ResponseEntity.ok("Координаты получены и записаны в файл");
        } catch (IOException e) {
            logger.error("Ошибка при записи координат: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка при записи координат в файл");
        }

    }

}