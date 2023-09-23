package jp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("jp")
@EntityScan(basePackageClasses = CoordinatRepositorySC.class)

public class JpaApplicationSC implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger( JpaApplicationSC.class);
    private List<CoordinatTableSC> all;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplicationSC.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Autowired
    CoordinatRepositorySC coordRepositorySC;
    private String coordinates;

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
    @Override
    public void run(String... args) throws Exception {

        read();
        CoordinatTableSC model = create(getCoordinates());
        log.info("=========== after create");
        read();
    }


    private void delete(CoordinatTableSC coord) {
        coordRepositorySC.delete(coord);
    }

    private void update(CoordinatTableSC coord, String model) {
        coord.setModel(model);
        coordRepositorySC.save(coord);
    }

    private void read() {
        all = (List<CoordinatTableSC>)coordRepositorySC.findAll();

        if (all.size() == 0) {
            log.info("NO RECORDS");
        }

        all.stream().forEach(rocket -> log.info(rocket.toString()));
    }

    private CoordinatTableSC create(String model) {
        CoordinatTableSC coord = new CoordinatTableSC();
        coord.setModel(model);
        return   coordRepositorySC.save(coord);
    }
}
