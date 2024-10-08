package Sems.Sem2.HW1_show.server;

import Sems.Sem2.HW1_show.client.ClientController;

public class ServerController {
    private boolean serverStatus;

    private ServerRepository serverRepository;
    private ServerGUI serverGUI;

    public void message(String s) {
    }

    public boolean connectUser(ClientController clientController) {
        return false;
    }


    public void disconnectUser(ClientController clientController) {
    }

    public StringBuilder getHistoryMessages() {
        return serverRepository.getHistory();
    }

    public void disconnectAllUsers() {
    }

    public void clearChatHistory() {
        serverRepository.clear();
    }

    public void start() {
        serverStatus = true;
        addMessage("Server is ON");
    }

    public boolean getStatus() {
        return serverStatus;
    }

    public void stop() {
        serverStatus = false;
        addMessage("Server is OFF");
    }

    public void addMessage(String message) {
        serverRepository.addMessage(message);
    }

    public void setServerGUI(ServerGUI serverGUI) {
        this.serverGUI = serverGUI;
    }
}
