package HW.HW2.client;

import HW.HW2.server.ServerController;

/**
 * класс содержащий логику работы клиента
 *
 * @clientView абстракция графического интерфейса
 * @server объект для связи с сервером
 */
public class ClientController {
    private boolean connectStatus;
    private String name;
    private ClientView clientView;
    private ServerController server;

    private StringBuilder historyOfMessages;

    //сеттеры
    public void setClientView(ClientView clientView) {
        this.clientView = clientView;
    }

    public void setServer(ServerController server) {
        this.server = server;
    }

    private void getHistoryOfMessages() {
        this.historyOfMessages = server.getHistoryMessages();
    }

    public boolean connectToServer(String name) {
        this.name = name;
        if (server.connectUser(this)){
            showOnWindow("Вы успешно подключились!\n");
            connectStatus = true;
            StringBuilder log = server.getHistoryMessages();
            if (log != null){

            }
            return true;
        } else {
            showOnWindow("Подключение не удалось");
            return false;
        }
    }

    public void disconnectedFromServer() {
        if (connectStatus) {
            connectStatus = false;
            clientView.disconnectedFromServer();
            showOnWindow("Вы были отключены от сервера!");
        }
    }

    public void disconnectFromServer() {
        server.disconnectUser(this);
    }

    public void answerFromServer(String text) {
        showOnWindow(text);
    }

    public void message(String text) {
        if (connectStatus) {
            if (!text.isEmpty()) {
                server.addMessage(name + ": " + text);
            }
        } else {
            showOnWindow("Нет подключения к серверу");
        }
    }

    private void showOnWindow(String text) {
        clientView.showMessage(text);
    }
}
