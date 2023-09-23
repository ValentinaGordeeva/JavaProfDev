package jp;
import jp.CoordRepository;

import Service.ServiceSendingMes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//jdbc:h2:mem:test
@SpringBootApplication
@EnableJpaRepositories({"Service","jp"})
@EntityScan(basePackageClasses = CoordinatesTable.class)

public class JpaApplication implements CommandLineRunner {


    private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);
    private List<CoordinatesTable> all;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Autowired
    CoordRepository coordRepository;
    private String coordinates;

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

 public String processString(String ithe){
     return  ithe;
 }
    @Override
    public void run(String... args) throws Exception {

        read();
        CoordinatesTable  model = create(getCoordinates());
        log.info("=========== after create");
        read();

    }

    private void delete(CoordinatesTable coord) {
        coordRepository.delete(coord);
    }

    private void update(CoordinatesTable coord, String model) {
        coord.setModel(model);
        coordRepository.save(coord);
    }

    private void read() {
        all = (List<CoordinatesTable>)  coordRepository.findAll();

        if (all.size() == 0) {
            log.info("NO RECORDS");
        }

        all.stream().forEach(rocket -> log.info(rocket.toString()));
    }

    private CoordinatesTable create(String model) {
        CoordinatesTable coord = new CoordinatesTable();
        coord.setModel(model);
        return  coordRepository.save(coord);
    }
}