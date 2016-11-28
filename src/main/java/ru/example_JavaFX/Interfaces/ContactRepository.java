package ru.example_JavaFX.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.example_JavaFX.Entity.Contact;
import java.util.List;

/**
 * Created by Рома on 28.11.2016.
 */

@Transactional(propagation = Propagation.MANDATORY)
public interface ContactRepository extends CrudRepository<Contact, Long>{

    List<Contact> findAll();
}
