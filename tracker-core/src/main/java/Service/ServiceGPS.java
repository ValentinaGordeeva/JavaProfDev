package Service;

import de.micromata.opengis.kml.v_2_2_0.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import de.micromata.opengis.kml.v_2_2_0.Document;

import javax.annotation.PostConstruct;
import javax.sound.midi.Track;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ServiceGPS {
    String filePath = "data.txt";

    BufferedReader br;
    List<String> result;
    //Чтение из файла и запись в список
    public  void readCoordinates() {

        try {
            if (br == null) {
                br = new BufferedReader(new FileReader(filePath));
            }
            String line = br.readLine();

            if (line != null) {
                 result = new ArrayList<>(Collections.singleton(line));

            }else {
                br.close();
                result.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //запуск по расписанию
    @Scheduled(fixedDelay = 6000)
    public List<String> timer() {
        readCoordinates();
        return result;

    }

}
    /*
    double latitude = 5.0;
    double longitude = 3.0;
    double azimuth = 1.0;
    double speed = 3.2;
    List<String> dataGPS = new ArrayList<>();
    @Scheduled(fixedDelay = 6000)
    public List<String> timer() {
        dataGPS.add(latitude + ", " + longitude + ", " + azimuth + ", " + speed);
        // System.out.println(latitude + ", " + longitude + ", " + azimuth + ", " + speed );
        //System.out.println();
        return  dataGPS;
    }


     */






