import java.awt.*;
import javax.swing.*;

public class BresenhamCircle {
    private class Canvas extends JPanel {
        int w, h;

        Canvas(int w, int h) {
            this.w = w;
            this.h = h;
        }

        private void plotPixel(Graphics g, int x, int y) {
            g.fillRect(x + (w / 2), (h / 2) - y, 1, 1);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawBresenhamCircle(50, g);
        }

        private void drawBresenhamCircle(int r, Graphics g) {
            int x = 0;
            int y = r;
            int d = 3 - 2 * r;

            while (x <= y) {
                plotPixel(g, x, y);
                plotPixel(g, y, x);
                plotPixel(g, y, -x);
                plotPixel(g, x, -y);
                plotPixel(g, -x, -y);
                plotPixel(g, -y, -x);
                plotPixel(g, -y, x);
                plotPixel(g, -x, y);

                if (d < 0) {
                    d += 4 * x + 6;
                } else {
                    d += 4 * (x - y) + 10;
                    y--;
                }
                x++;
            }
        }
    }

    BresenhamCircle(int h, int w) {
        JFrame frm = new JFrame("Bresenham Circle Demo");
        frm.setSize(w, h);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas(w, h);
        frm.add(canvas);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BresenhamCircle(300, 300);
            }
        });
    }
}