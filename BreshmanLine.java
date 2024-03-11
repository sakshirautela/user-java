import javax.swing.*;
import java.awt.*;

public class BreshmanLine extends JFrame {

    private int x0, y0, x1, y1;

    public BreshmanLine() {
        super("Line Drawing");

        // Taking user input for coordinates
        x0 = Integer.parseInt(JOptionPane.showInputDialog("Enter x-coordinate of the first point: "));
        y0 = Integer.parseInt(JOptionPane.showInputDialog("Enter y-coordinate of the first point: "));
        x1 = Integer.parseInt(JOptionPane.showInputDialog("Enter x-coordinate of the second point: "));
        y1 = Integer.parseInt(JOptionPane.showInputDialog("Enter y-coordinate of the second point: "));

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawLine(g, x0, y0, x1, y1);
    }

    private void drawLine(Graphics g, int x0, int y0, int x1, int y1) {
        int dx = x1 - x0;
        int dy = y1 - y0;
        int p = 2 * dy - dx;
        int x = x0;
        int y = y0;

        while (x < x1) {
            if (p >= 0) {
                g.drawLine(x, y, x, y + 1);
                y = y + 1;
                p = p + 2 * dy - 2 * dx;
            } else {
                g.drawLine(x, y, x, y);
                p = p + 2 * dy;
            }
            x = x + 1;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BreshmanLine lineDrawing = new BreshmanLine();
            lineDrawing.setVisible(true);
        });
    }
}
