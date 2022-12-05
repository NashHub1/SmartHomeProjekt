package smarthomeapp.backend.entity;

import com.vaadin.flow.spring.annotation.SpringComponent;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;



@SpringComponent
public class Daten{

    @Bean
    public CommandLineRunner loadData(ContactRepository contactRepository) {

        return args -> {
            Contact michael = new Contact();
            michael.setFirstName("Michael");
            michael.setLastName("Stephens");
            michael.setEmail("step@gmx.de");
            contactRepository.save(michael);
            Contact bi = new Contact();
            bi.setFirstName("Büsra");
            bi.setLastName("Altas");
            bi.setEmail("bi@gmx.de");
            contactRepository.save(bi);


        };

    }

}