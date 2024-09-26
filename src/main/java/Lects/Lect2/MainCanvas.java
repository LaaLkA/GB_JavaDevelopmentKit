package Lects.Lect2;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {
    private final MainWindow controller;

    MainCanvas(MainWindow controller) {
        setBackground(Color.BLUE);
        this.controller = controller;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        controller.onDrawFrame();
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBottom() {
        return getHeight() - 1;
    }
}
