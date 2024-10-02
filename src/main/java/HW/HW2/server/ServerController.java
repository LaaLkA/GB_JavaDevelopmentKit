package HW.HW2.server;

import HW.HW2.client.ClientController;

public class ServerController {
    private boolean serverStatus;
    private ServerRepository serverRepository;
    private int countUsers;

    public boolean connectUser(ClientController clientController) {
        countUsers++;
        return true;
    }


    public void disconnectUser(ClientController clientController) {
        countUsers--;
    }

    public void disconnectAllUsers() {
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
