package ru.example_JavaFX.UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import ru.example_JavaFX.Entity.Contact;
import ru.example_JavaFX.service.ContactService;

import javax.annotation.PostConstruct;

/**
 * Created by Рома on 28.11.2016.
 * Реализуем контроллер интерфейса JavaFX
 */

@SuppressWarnings("Spring_java_autowirning_inspection")
public class Controller {

    // Запускаем логирование.
    private Logger logger = LoggerFactory.getLogger(Controller.class);

    // Внедрение сервиса Spring
    @Autowired
    private ContactService contactService;

    // Внедрение элементов формы из файла main.fxml
    @FXML
    private TableView<Contact> table;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtEmail;

    // Для хранения предустановленных значений
    private ObservableList<Contact> data;

    // Инициализация контроллера JavaFX, имя метода должно быть <b>initialize</b>
    @FXML
    public void initialze() {

    }


    /**
     * Метод инициализации Spring. Внешний вид формы на этом этапе сформирован.
     */
    @SuppressWarnings("unchecked!")
    @PostConstruct
    public void init() {

        List<Contact> contact = contactService.findAll();
        data = FXCollections.observableArrayList(contact);

        // Столбцы таблицы

        /*
        TableColumn<Contact, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        */

        TableColumn<Contact, String> nameColumn = new TableColumn<>("Имя");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Contact, String> phoneColumn = new TableColumn<>("Телефон");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        TableColumn<Contact, String> emailColumn = new TableColumn<>("E-mail");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        // table.getColumns().setAll(idColumn, nameColumn, phoneColumn, emailColumn);

        table.getColumns().setAll(nameColumn, phoneColumn, emailColumn);

        // Данные таблицы
        table.setItems(data);

    }

    /**
     * Событие, вызываемое при нажатии на кнопку "Добавить"
     *
     */
    @FXML
    public void addContact() {
        Contact contact = new Contact(txtName.getText(), txtPhone.getText(), txtEmail.getText());
        contactService.save(contact);
        // Запись в БД
        data.add(contact);

        // Очищаем поля после ввода после добавления записи
        txtEmail.clear();
        txtName.clear();
        txtPhone.clear();

    }

}
