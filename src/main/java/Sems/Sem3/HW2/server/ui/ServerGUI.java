package Sems.Sem3.HW2.server.ui;

import Sems.Sem3.HW2.server.domain.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;

    private JTextArea log;
    private JButton btnStart, btnStop, btnClrHistory, btnDisAllUsers;
    private JPanel header, footer;
    private JScrollPane scroll;


    private boolean flagStatusServer;
    private Server server;

    public ServerGUI(Server server) {
        this.server = server;
        setting();
        createPanel();

        setVisible(true);
    }

    private void createPanel() {
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createLog());
        add(createFooter(), BorderLayout.SOUTH);
    }

    private Component createFooter() {
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.start();
                if (server.getStatus())
                    flagStatusServer = true;
                else
                    flagStatusServer = false;
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.stop();
                if (server.getStatus())
                    flagStatusServer = true;
                else
                    flagStatusServer = false;
            }
        });

        footer = new JPanel(new GridLayout(1, 2));
        footer.add(btnStart);
        footer.add(btnStop);
        return footer;
    }

    private Component createHeaderPanel() {
        btnDisAllUsers = new JButton("Disconnect all users");
        btnClrHistory = new JButton("Clear CHAT history");
        btnDisAllUsers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                server.disconnectAllUsers();
            }
        });
        btnClrHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.clearChatHistory();
            }
        });
        header = new JPanel(new GridLayout(1, 2));
        header.add(btnDisAllUsers);
        header.add(btnClrHistory);
        return header;
    }

    private Component createLog() {
        log = new JTextArea();
        log.setEditable(false);
        log.setText(getHistoryMessages().toString());
        return new JScrollPane(log);
    }

    private StringBuilder getHistoryMessages() {
        return server.getHistoryMessages();
    }

    private void setting() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Server");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
