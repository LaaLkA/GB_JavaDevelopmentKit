package HW.HW1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientGUI extends JFrame {
    private static final int WINDOW_WIDTH = 230;
    private static final int WINDOW_HEIGHT = 460;

    private ServerWindow serverWindow;

    private String userName;
    private String userPassword;
    private String userMessage;
    private static final String ip = "127.0.0.1";
    private static final String port = "8189";

    private boolean flagUserAuth = false;

    private ArrayList<String> historyOfMessages;

    JButton btnLogin, btnSend;
    JTextField fieldLogin, fieldMessage, fieldIp, fieldPort;
    JPasswordField fieldPassword;
    JPanel panSendMessage, panAuth, panServer, panTop;
    JTextArea areaHistoryOfMessages;

    ClientGUI(ServerWindow serverWindow) {
        this.serverWindow = serverWindow;

        setLocationRelativeTo(serverWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Client");
        setResizable(true);


        fieldIp = new JTextField(ip);
        fieldIp.setEditable(false);
        fieldPort = new JTextField(port);
        fieldPort.setEditable(false);

        fieldLogin = new JTextField();
        fieldPassword = new JPasswordField();
        fieldMessage = new JTextField();

        btnLogin = new JButton("Login");
        btnSend = new JButton("Send");
        btnSend.setSize(5,5);

        panServer = new JPanel(new GridLayout(1, 3));
        panServer.add(fieldIp);
        panServer.add(fieldPort);

        panAuth = new JPanel(new GridLayout(1, 3));
        panAuth.add(fieldLogin);
        panAuth.add(fieldPassword);
        panAuth.add(btnLogin);

        panTop = new JPanel(new GridLayout(2,1));
        panTop.add(panServer);
        panTop.add(panAuth);

        panSendMessage = new JPanel(new GridLayout(1,2));
        panSendMessage.add(fieldMessage);
        panSendMessage.add(btnSend);

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

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName = fieldLogin.getText();
                userPassword = fieldPassword.getText();
                flagUserAuth = true;
                updateHistoryOfMessages();
            }
        });
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flagUserAuth) return;
                userMessage = fieldMessage.getText();
                fieldMessage.setText("");
                serverWindow.addMessage(userName + ": " + userMessage);
                updateHistoryOfMessages();
            }
        });
        add(panTop, BorderLayout.NORTH);
        add(scrollPane);
        add(panSendMessage, BorderLayout.SOUTH);
    }

    public void updateHistoryOfMessages() {
        if (!flagUserAuth) return;
        historyOfMessages = serverWindow.getHistoryOfMessages();
        StringBuilder fullHistoryOfMessagesOnArea = new StringBuilder();
        for (String message : historyOfMessages)
            fullHistoryOfMessagesOnArea.append(message).append("\n");
        areaHistoryOfMessages.setText(fullHistoryOfMessagesOnArea.toString());
    }
}
