package ru.example_JavaFX;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

/**
 * Created by Рома on 28.11.2016.
 * Определяем главный класс приложения JavaFx
 */

@Lazy
@SpringBootApplication
public class Application extends  JavaFXApplication_Support {

    @Value("${ui.title:Example_JavaFX_and_Spring-Boot}")
    private String windowsTitle;

    @Qualifier("mainView")
    @Autowired
    private ConfigControllers.View view;

    @Override
    public void start(Stage stage) throws  Exception {
        stage.setTitle(windowsTitle);
        stage.setScene(new Scene(view.getView()));
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {

        launchApp(Application.class, args);
    }
}
