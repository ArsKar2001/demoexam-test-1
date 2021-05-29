package karmanchik.demoexam.uijfx.controller;

import javafx.scene.Node;
import karmanchik.demoexam.uijfx.StageRunner;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractUIController implements UIController {
    @Getter
    @Setter
    private Node root;

    @Override
    public void show() {
        preShow();
        StageRunner.getNavigate().show(this);
        postShow();
    }

    protected abstract void postShow();

    protected abstract void preShow();
}
