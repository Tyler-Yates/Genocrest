import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Viewer extends JPanel implements KeyListener {
    private final JFrame frame;

    public Viewer() {
        frame = new JFrame("Test");
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
        frame.add(this);
    }

    public static void main(String[] args) {
        new Viewer();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        new Crest().draw(graphics, 100, 100);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            repaint();
        }
    }
}
