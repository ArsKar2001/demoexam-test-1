package karmanchik.demoexam.uijfx.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import karmanchik.demoexam.dbservice.models.Agent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AgentView extends HBox {
    private final Agent agent;

    public AgentView(Agent agent) {
        this.agent = agent;
    }

    public AgentView build() {
        this.setPadding(new Insets(10));
        ImageView imageView = new ImageView();
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        try {
            imageView.setImage(new Image(new FileInputStream("img" + agent.getLogo())));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        VBox vBox = new VBox(3);
        vBox.setPadding(new Insets(10));
        vBox.setPrefWidth(1000);

        Label lb1 = new Label(agent.getType().getTitle() + " | " + agent.getTitle());
        lb1.setStyle("-fx-font-weight: bold;");
        vBox.getChildren().addAll(
                lb1,
                new Label(agent.getAverage() + " продаж за год"),
                new Label(agent.getPhone()),
                new Label("Приоритет: " + agent.getPriority())
        );
        this.getChildren().addAll(
                imageView,
                vBox,
                new Label(agent.getPercent() + "%"));
        return this;
    }
}
