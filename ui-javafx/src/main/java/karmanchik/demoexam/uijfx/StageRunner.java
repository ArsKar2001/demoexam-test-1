package karmanchik.demoexam.uijfx;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import karmanchik.demoexam.uijfx.JavaFXApplication.StageReadyEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;

@Component
public class StageRunner implements ApplicationListener<StageReadyEvent> {
    private static NavigateStageService navigate;


    private final Resource mainRes;
    private final ApplicationContext context;
    private final String appTitle;

    public StageRunner(ApplicationContext context,
                       @Value("classpath:/fxml/main.fxml") Resource mainRes,
                       @Value("${spring.application.name}") String appTitle) {
        this.context = context;
        this.mainRes = mainRes;
        this.appTitle = appTitle;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent stageReadyEvent) {
        Stage stage = stageReadyEvent.getStage();
        navigate = new NavigateStageService(stage, context);
        run(stage);
        getNavigate().load(mainRes).show();
    }

    private void run(Stage stage) {
        try (FileInputStream stream = new FileInputStream("img/Попрыженок.png")) {
            stage.setTitle(appTitle);
            stage.getIcons().add(new Image(stream));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static NavigateStageService getNavigate() {
        return navigate;
    }
}
