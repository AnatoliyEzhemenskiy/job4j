package ru.job4j.tictactoe;
import javafx.scene.shape.Rectangle;

public class Figure3T extends Rectangle {
    private boolean markX;
    private boolean markO;

    public Figure3T(boolean markX) {
        this.markX = false;
        this.markO = false;
    }

    public void take(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    public boolean hasMarkX() {
        return this.markX;
    }

    public boolean hasMarkO() {
        return this.markO;
    }
}