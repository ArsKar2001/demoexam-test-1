package karmanchik.demoexam.uijfx.controller;

import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.Serializable;

public interface UIController extends Initializable, Serializable {
    Node getRoot();
    void setRoot(Node root);

    void show();
}
