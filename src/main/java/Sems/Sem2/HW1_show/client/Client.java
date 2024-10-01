package Sems.Sem2.HW1_show.client;


// Логика работы
public class Client {
    private ServerWindow server;
    private boolean connected;
    private String name;

    private ClientView view;

    public Client(ClientView view) {
        this.view = view;
    }

}
