package Lects.Lect2.Packages.common;

import Lects.Lect2.WithInterfaces.MainCanvas;

import java.awt.*;

public interface CanvasRepaintListener {
    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime);
}
