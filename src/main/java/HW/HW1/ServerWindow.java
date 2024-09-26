package HW.HW1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ServerWindow extends JFrame {
    private static final int WINDOW_WIDTH = 230;
    private static final int WINDOW_HEIGHT = 460;

    private static final String SERVER_OFFLINE = "Server is offline";
    private static final String SERVER_ONLINE = "Server is online";
    private boolean flagStatusServer = false;

    private ArrayList<String> historyOfMessages = new ArrayList<>();;

    JTextField fieldServerStatus;
    JPanel panControl, panControlButtons;
    JTextArea areaHistoryOfMessages;
    JButton btnStart, btnStop, btnAddUserWindow;

    ServerWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server");
        setResizable(false);

        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        btnAddUserWindow = new JButton("Add user window");

        fieldServerStatus = new JTextField(SERVER_OFFLINE);

        panControlButtons = new JPanel(new GridLayout(1, 2));
        panControlButtons.add(btnStart);
        panControlButtons.add(btnStop);

        panControl = new JPanel(new GridLayout(2, 1));
        panControl.add(fieldServerStatus);
        panControl.add(panControlButtons);

        areaHistoryOfMessages = new JTextArea();
        areaHistoryOfMessages.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaHistoryOfMessages);

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateHistoryOfMessages();
            }
        });
        timer.start();

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldServerStatus.setText(SERVER_OFFLINE);
                flagStatusServer = false;
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldServerStatus.setText(SERVER_ONLINE);
                flagStatusServer = true;
            }
        });
        btnAddUserWindow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flagStatusServer) return;
                ClientGUI clientWindow = new ClientGUI(ServerWindow.this);
                clientWindow.setVisible(true);
            }
        });

        add(btnAddUserWindow, BorderLayout.NORTH);
        add(scrollPane);
        add(panControl, BorderLayout.SOUTH);

        setVisible(true);
    }

    public ArrayList<String> getHistoryOfMessages() {
        return historyOfMessages;
    }

    public void addMessage(String message) {
        historyOfMessages.add(message);
    }

    public void updateHistoryOfMessages() {
        if(historyOfMessages.isEmpty()) return;
        StringBuilder fullHistoryOfMessagesOnArea = new StringBuilder();
        for (String message : historyOfMessages)
            fullHistoryOfMessagesOnArea.append(message).append("\n");
        areaHistoryOfMessages.setText(fullHistoryOfMessagesOnArea.toString());
    }
}
