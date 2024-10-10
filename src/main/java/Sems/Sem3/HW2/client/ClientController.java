package Sems.Sem3.HW2.client;

import Sems.Sem3.HW2.server.domain.Server;

public class ClientController {
    private boolean connectStatus;
    private String name;
    private ClientView clientView;
    private Server server;

    private StringBuilder historyOfMessages;

    //сеттеры
    public void setClientView(ClientView clientView) {
        this.clientView = clientView;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public StringBuilder getHistoryOfMessages() {
        this.historyOfMessages = server.getHistoryMessages();
        return historyOfMessages;
    }

    public boolean connectToServer(String name) {
        this.name = name;
        if (server.connectUser(this)) {
            showOnWindow("You connected!\n");
            connectStatus = true;
            StringBuilder log = server.getHistoryMessages();
            return true;
        } else {
            showOnWindow("Connected failed!\n");
            return false;
        }
    }

    public void disconnectedFromServer() {
        if (connectStatus) {
            connectStatus = false;
            clientView.disconnectedFromServer();
            showOnWindow("You was disconnected!\n");
        }
    }

    public void disconnectFromServer() {
        server.disconnectUser(this);
    }

    public void message(String text) {
        if (connectStatus) {
            if (!text.isEmpty()) {
                server.addMessage(name + ": " + text);
            }
        } else {
            showOnWindow("Not connected to server!\n");
        }
    }

    private void showOnWindow(String text) {
        clientView.showMessage(text);
    }
}
