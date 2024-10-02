package Sems.Sem2.HW1_show;

import HW.HW1.ServerWindow;
import Sems.Sem2.HW1_show.client.ClientController;
import Sems.Sem2.HW1_show.client.ClientGUI;
import Sems.Sem2.HW1_show.client.ClientView;
import Sems.Sem2.HW1_show.server.ServerController;
import Sems.Sem2.HW1_show.server.ServerGUI;
import Sems.Sem2.HW1_show.server.ServerRepository;

public class Main {
    public static void main(String[] args) {
        ServerController serverController = new ServerController();
        ServerRepository serverRepository = new ServerRepository();
        ServerGUI serverGUI = new ServerGUI();
        ClientGUI clientGUI = new ClientGUI();
        ClientController clientController = new ClientController();

        // Устанавливаем связи между объектами
        serverController.setServerGUI(serverGUI);
        clientController.setClientView(clientGUI);
        clientController.setServer(serverController);

        // Дополнительная логика и инициализация
        serverGUI.setVisible(true);
        clientGUI.setVisible(true);

    }
}
