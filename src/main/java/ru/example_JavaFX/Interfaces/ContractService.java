package ru.example_JavaFX.Interfaces;

import ru.example_JavaFX.Entity.Contact;
import java.util.List;

/**
 * Created by Рома on 28.11.2016.
 */
public interface ContractService {

    Contact save(Contact contact);

    List<Contact> findAll();
}
