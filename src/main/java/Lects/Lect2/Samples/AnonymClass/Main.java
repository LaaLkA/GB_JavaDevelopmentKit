package Lects.Lect2.Samples.AnonymClass;

public class Main {
    public interface MouseListener {
        void mouseUp();

        void mouseDown();
    }

    private static class MouseAdapter implements MouseListener {
        @Override
        public void mouseUp() {

        }

        @Override
        public void mouseDown() {

        }
    }

    private static void addMouseListener(MouseListener l) {
        l.mouseDown();
        l.mouseUp();
    }

    public static void main(String[] args) {
        MouseAdapter mouseAdapter = new MouseAdapter();
        addMouseListener(mouseAdapter);
        addMouseListener(new MouseAdapter());
        addMouseListener(new MouseListener() {
            @Override
            public void mouseDown() {

            }

            @Override
            public void mouseUp() {

            }
        });
    }
}
