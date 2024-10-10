package Sems.Sem3.HW2;

import Sems.Sem3.HW2.client.ClientController;
import Sems.Sem3.HW2.client.ClientGUI;
import Sems.Sem3.HW2.server.domain.Server;
import Sems.Sem3.HW2.server.ui.ServerGUI;
import Sems.Sem3.HW2.server.repository.FileStorage;

public class Main {
    public static void main(String[] args) {
        try {
            Server server = new Server();
            FileStorage serverFileStorage = new FileStorage();
            server.setServerRepository(serverFileStorage);
            ServerGUI serverGUI = new ServerGUI(server);

            ClientGUI clientGUI = new ClientGUI();
            ClientController clientController = new ClientController();

            clientGUI.setClient(clientController);


            clientController.setClientView(clientGUI);
            clientController.


                    setServer(server);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
