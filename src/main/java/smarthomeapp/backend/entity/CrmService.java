package smarthomeapp.backend.entity;


import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

//Code wurde vom Tutorial entnommen https://vaadin.com/docs/latest/tutorial/database-access

@Service
public class CrmService {

    private final ContactRepository contactRepository;


    public CrmService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> findAllContacts(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return contactRepository.findAll();
        } else {
            return contactRepository.search(stringFilter);
        }
    }

    public long countContacts() {
        return contactRepository.count();
    }

    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }

    public void saveContact(Contact contact) {
        if (contact == null) {
            System.err.println("Contact is null.");
            return;
        }
        contactRepository.save(contact);
    }

}
