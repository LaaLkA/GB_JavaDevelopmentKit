package Sems.Sem3.HW2.client;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientGUI extends JFrame implements ClientView {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private JTextArea log;
    private JTextField tfIPAddress, tfPort, tfLogin, tfMessage;
    private JPasswordField password;
    private JButton btnLogin, btnSend, btnDisconnect;
    private JPanel headerPanelConnect, headerPanelDisconnect;

    private ClientController clientController;

    public ClientGUI() {
        setting();
        createPanel();

        setVisible(true);
    }

    //сеттер
    public void setClient(ClientController clientController) {
        this.clientController = clientController;
    }

    private void setting() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat client");
//        setLocation(serverWindow.getX() - 500, serverWindow.getY());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public void showMessage(String msg) {
        log.append(msg + "\n");
    }

    @Override
    public void disconnectedFromServer(){
        hideHeaderConnectPanel(true);
        hideHeaderDisconnectPanel(false);
    }

    public void disconnectFromServer(){
        clientController.disconnectFromServer();
        disconnectedFromServer();
    }

    private void hideHeaderConnectPanel(boolean visible){
        headerPanelConnect.setVisible(visible);
    }

    private void hideHeaderDisconnectPanel(boolean visible){headerPanelDisconnect.setVisible(visible);}

    public void login(){
        if (clientController.connectToServer(tfLogin.getText())){
            headerPanelConnect.setVisible(false);
            headerPanelDisconnect.setVisible(true);
        }
    }

    private void message(){
        clientController.message(tfMessage.getText());
        tfMessage.setText("");
    }

    private void createPanel() {
        add(createHeaderPanelDisconnect(), BorderLayout.NORTH);
        add(createHeaderPanelConnect(), BorderLayout.NORTH);
        add(createLog());
        add(createFooter(), BorderLayout.SOUTH);
    }

    private Component createHeaderPanelDisconnect(){
        btnDisconnect = new JButton("Disconnect");
        btnDisconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disconnectFromServer();
            }
        });
        headerPanelDisconnect = new JPanel();
        headerPanelDisconnect.add(btnDisconnect);
        return headerPanelDisconnect;
    }

    private Component createHeaderPanelConnect() {
        headerPanelConnect = new JPanel(new GridLayout(2, 3));
        tfIPAddress = new JTextField("127.0.0.1");
        tfPort = new JTextField("8189");
        tfLogin = new JTextField("Ivan");
        password = new JPasswordField("123456");
        btnLogin = new JButton("Login");

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        headerPanelConnect.add(tfIPAddress);
        headerPanelConnect.add(tfPort);
        headerPanelConnect.add(new JPanel());
        headerPanelConnect.add(tfLogin);
        headerPanelConnect.add(password);
        headerPanelConnect.add(btnLogin);

        return headerPanelConnect;
    }

    private Component createLog() {
        log = new JTextArea();
        log.setEditable(false);
        log.setText(getHistoryMessages().toString());
        return new JScrollPane(log);
    }

    private StringBuilder getHistoryMessages() {
        if (clientController != null) {
            return clientController.getHistoryOfMessages();
        } else {
            return new StringBuilder("History is clear!\n");
        }
    }

    private Component createFooter() {
        JPanel panel = new JPanel(new BorderLayout());
        tfMessage = new JTextField();
        btnSend = new JButton("send");

        tfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    message();
                }
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message();
            }
        });

        panel.add(tfMessage);
        panel.add(btnSend, BorderLayout.EAST);

        return panel;
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            this.disconnectedFromServer();
        }
    }
}