package HW.HW2.server;

public class ServerRepository {
    private StringBuilder historyOfMessages;

    public ServerRepository() {
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
