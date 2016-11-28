package ru.example_JavaFX;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.example_JavaFX.UI.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * Created by Рома on 28.11.2016.
 */
@Configuration
public class ConfigControllers {

    /**
     * Класс оболочка, используется в качестве бина.
     * view - представление, используется в точке входа {@Link Application}
     */
    public class View {
        private Parent view;
        private Object controller;

        public View(Parent view, Object controller) {
            this.view = view;
            this.controller = controller;
        }

        public Parent getView() {
            return view;
        }

        public void setView(Parent view) {
            this.view = view;
        }

        public Object getController() {
            return controller;
        }

        public void setController(Objects controller) {
            this.controller = controller;
        }
    }

    /**
     * Загрузчик файла main.fxml
     * @param url
     * @return
     * @throws IOException
     */
    protected View loadView(String url) throws IOException {

        try (InputStream fxmlStream = getClass().getClassLoader().getResourceAsStream(url)){
            FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            return new View(loader.getRoot(), loader.getController());
        }
    }

    @Bean(name="mainView")
    public View getMainView() throws  IOException {

        // return FXMLLoader.load(getClass().getClassLoader().getResource("fxml/main.fxml"));
        return  loadView("fxml/main.fxml");
    }

    // Добавляем контроллер в контекст Spring, для того чтобы он сделал все необходимые включения см. класс Controller
    @Bean
    public Controller getController() throws IOException {
        return (Controller) getMainView().getController();
    }




}
