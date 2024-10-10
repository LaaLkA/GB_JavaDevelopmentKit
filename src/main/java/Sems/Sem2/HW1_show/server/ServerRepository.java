package Sems.Sem2.HW1_show.server;

import java.util.ArrayList;

public class ServerRepository {
    private StringBuilder historyOfMessages;


    public StringBuilder getHistory() {
        return historyOfMessages;
    }

    public void clear() {
        historyOfMessages = new StringBuilder();
    }

    public void addMessage(String message) {
        historyOfMessages.append(message).append("\n");
    }
}
