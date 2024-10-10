package HW.HW2;

import HW.HW2.client.ClientController;
import HW.HW2.client.ClientGUI;
import HW.HW2.server.ServerController;
import HW.HW2.server.ServerGUI;
import HW.HW2.server.ServerRepository;

public class Main {
    public static void main(String[] args) {
        try {
            ServerController serverController = new ServerController();
            ServerRepository serverRepository = new ServerRepository();
            serverController.setServerRepository(serverRepository);
            ServerGUI serverGUI = new ServerGUI(serverController);

            ClientGUI clientGUI = new ClientGUI();
            ClientController clientController = new ClientController();

            clientGUI.setClient(clientController);


            clientController.setClientView(clientGUI);
            clientController.


                    setServer(serverController);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
