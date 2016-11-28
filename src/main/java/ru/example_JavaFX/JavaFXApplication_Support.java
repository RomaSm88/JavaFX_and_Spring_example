package ru.example_JavaFX;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * Created by Рома on 27.11.2016.
 * Абстрактый класс, в котором переопределяется метод init(), что необходимо для инициализации Spring контекста
 * в момент запуска JavaFX приложения.
 */
public abstract  class JavaFXApplication_Support extends Application {

    private static  String[] savedArgs;

    // Свойство для инициализации контекста spring
    protected ConfigurableApplicationContext context;

    /**
     * Перегруженный метод производит инициализацию контекста Spring, в момент старта JavaFX
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        context = SpringApplication.run(getClass(), savedArgs);
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }

    /**
     * Для закрытия контекста spring
     * @throws Exception
     */
    @Override
    public void stop() throws  Exception {
        super.stop();
        context.close();
    }

    protected static void launchApp(Class<? extends JavaFXApplication_Support> appClass, String[] args) {
        JavaFXApplication_Support.savedArgs = args;
        Application.launch(appClass, args);
    }
}
