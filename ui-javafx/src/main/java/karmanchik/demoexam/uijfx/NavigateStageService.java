package karmanchik.demoexam.uijfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import karmanchik.demoexam.uijfx.controller.UIController;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NavigateStageService {
    private final List<UIController> controllers = new ArrayList<>();
    private final ApplicationContext context;
    private final Scene scene;

    public NavigateStageService(Stage stage,
                                ApplicationContext context) {
        this.context = context;
        scene = new Scene(new Pane());
        stage.setScene(scene);
    }

    public UIController load(Resource resource) {
        try {
            FXMLLoader loader = new FXMLLoader(resource.getURL());
            loader.setControllerFactory(context::getBean);

            Node root = loader.load();
            UIController controller = loader.getController();

            controller.setRoot(root);
            return controller;
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).showAndWait();
            throw new RuntimeException(e);
        }
    }

    public void show(UIController controller) {
        controllers.add(controller);
        scene.setRoot((Parent) controller.getRoot());
    }
}
