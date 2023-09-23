package controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import services.MySrvice;

import java.io.*;
import java.nio.charset.Charset;

import org.springframework.stereotype.Service;
import classforcoordinates.Coordinates;
@Service
@RestController
public class ControllerPOST {

    private final Logger logger = LoggerFactory.getLogger(ControllerPOST.class);
    @PostMapping("/")
    public ResponseEntity<String> receiveCoordinates(Coordinates coordinates, Model modelMock) {
        logger.info("Received coordinates: {}", coordinates);

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

            logger.info("The coordinates are written to a file");
            return ResponseEntity.ok("The coordinates are received and written to a file");
        } catch (IOException e) {
            logger.error("Error when writing coordinates: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error when writing coordinates to a file");
        }

    }

}