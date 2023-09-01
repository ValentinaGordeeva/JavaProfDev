package Service;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
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
                br = null;
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







