import java.awt.*;
import javax.swing.*;

public class Polygon {
    private class Canvas extends JPanel {
        int w, h;

        Canvas(int w, int h) {
            this.w = w;
            this.h = h;
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int[] x = {50, 150, 200, 100};
            int[] y = {50, 50, 150, 200};
            drawPolygon(x, y, g);
        }

        private void drawPolygon(int[] x, int[] y, Graphics g) {
            int n = x.length;
            for (int i = 0; i < n - 1; i++) {
                g.drawLine(x[i], y[i], x[i + 1], y[i + 1]);
            }
            g.drawLine(x[n - 1], y[n - 1], x[0], y[0]);
        }
    }

    Polygon(int h, int w) {
        JFrame frm = new JFrame("Draw Polygon Demo");
        frm.setSize(w, h);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas(w, h);
        frm.add(canvas);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Polygon(400, 400);
            }
        });
    }
}
