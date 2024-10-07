package HW.HW2.server;

import HW.HW2.client.ClientController;
import java.util.ArrayList;

public class ServerController {
    private boolean serverStatus;
    private ServerRepository serverRepository;
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
        return serverRepository.getHistory();
    }

    public void clearChatHistory() {
        serverRepository.clear();
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
        serverRepository.addMessage(message);
    }

    public void setServerRepository(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }
}
