package Sems.Sem3.HW2.server.domain;

import Sems.Sem3.HW2.client.ClientController;
import Sems.Sem3.HW2.server.repository.FileStorage;

import java.util.ArrayList;

public class Server {
    private boolean serverStatus;
    private FileStorage serverFileStorage;
    private int countUsers;
    private ArrayList<ClientController> users = new ArrayList<>();

    public boolean connectUser(ClientController clientController) {
        users.add(clientController);
        countUsers++;
        return true;
    }


    public void disconnectUser(ClientController clientController) {
        users.remove(clientController);
        countUsers--;
    }

    public void disconnectAllUsers() {
        users.clear();
        countUsers = 0;
    }

    public StringBuilder getHistoryMessages() {
        return serverFileStorage.getHistory();
    }

    public void clearChatHistory() {
        serverFileStorage.clear();
    }

    public void start() {
        serverStatus = true;
        addMessage("Server is ON");
        countUsers = 0;
    }

    public boolean getStatus() {
        return serverStatus;
    }

    public void stop() {
        serverStatus = false;
        addMessage("Server is OFF");
    }

    public void addMessage(String message) {
        serverFileStorage.addMessage(message);
    }

    public void setServerRepository(FileStorage serverFileStorage) {
        this.serverFileStorage = serverFileStorage;
    }
}
