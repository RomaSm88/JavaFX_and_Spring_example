package ru.example_JavaFX.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example_JavaFX.Entity.Contact;
import ru.example_JavaFX.Interfaces.ContactRepository;
import ru.example_JavaFX.Interfaces.ContractService;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 * Created by Рома on 28.11.2016.
 * Реализуем сервис для работы с контактами, средствами Spring-Boot
 */

@Service
@Transactional
public class ContactService implements ContractService{

    @Autowired
    private ContactRepository repository;


    /**
     * Добавдяем тестовые записи в БД при старте приложения
     */
    @PostConstruct
    public void genarate_Data() {
        save(new Contact("Петров Иван", "88001123", "petro@gmail.com"));
        save(new Contact("Иванов Сергей", "999009123", "serg@gmail.com"));
        save(new Contact("Гришин Федор", "89910012323", "fedor@gmail.com"));
    }

    @Override
    public Contact save(Contact contact) {
        return  repository.save(contact);
    }

    @Override
    public List<Contact> findAll() {
        return repository.findAll();
    }

}
