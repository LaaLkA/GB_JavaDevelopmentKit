package Sems.Sem2.HW1_show.client;

import javax.swing.*;

public class ClientGUI extends JFrame implements ClientView {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private JTextArea log;
    private JTextField tfIpAddress, tfPort, tfLogin, tfMessage;
    private JPasswordField fldPassword;
    private JButton btnLogin, btnSend;
    private JPanel headerPanel;

    private Client client;

    public ClientGUI(ServerWIndow server) {
        client = new Client();
        

    }

    private void appendLog(String text) {
        log.append((text + "\n"));
    }

    @Override
    public void sendMessage(String message) {
        appendLog(message);
    }

}
