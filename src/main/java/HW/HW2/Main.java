package HW.HW2;

import HW.HW2.client.ClientController;
import HW.HW2.client.ClientGUI;
import HW.HW2.server.ServerController;
import HW.HW2.server.ServerGUI;
import HW.HW2.server.ServerRepository;

public class Main {
    public static void main(String[] args) {
        ServerController serverController = new ServerController();
        ServerRepository serverRepository = new ServerRepository();
        ServerGUI serverGUI = new ServerGUI();

        ClientGUI clientGUI = new ClientGUI();
        ClientController clientController = new ClientController();

        serverController.setServerRepository(serverRepository);
        clientController.setClientView(clientGUI);
        clientController.setServer(serverController);

    }
}
