package Sems.Sem3.HW2.server.repository;

public class FileStorage {
    private StringBuilder historyOfMessages;

    public FileStorage() {
        historyOfMessages = new StringBuilder();
    }

    public StringBuilder getHistory() {
        return historyOfMessages;
    }

    public void clear() {
        historyOfMessages = new StringBuilder();
    }

    public void addMessage(String message) {
        historyOfMessages.append(message).append("\n");
//        System.out.println(message);
    }
}
