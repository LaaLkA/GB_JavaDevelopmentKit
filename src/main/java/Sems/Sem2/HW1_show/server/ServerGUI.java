package Sems.Sem2.HW1_show.server;

import javax.swing.*;
import java.awt.*;

public class ServerGUI extends JFrame implements ServerView {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;

    private JTextArea log;
    private JButton btnStart, btnStop, btnClrHistory, btnDisAllUsers;

    public ServerGUI() {
        setting();
        createPanel();

        setVisible(true);
    }

    private void createPanel() {
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createLog());
        add(createFooter(), BorderLayout.SOUTH);
    }

    private String createHeaderPanel() {

    }

    private void setting() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Server");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void showMessage(String message) {

    }

    @Override
    public void disconnectedFromServer() {

    }
}
