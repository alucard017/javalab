import java.awt.*;
import javax.swing.*;

public class MidPointCircle {
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
            drawMidpointCircle(50, g);
        }

        private void drawMidpointCircle(int r, Graphics g) {
            int x = 0;
            int y = r;
            int p = 1 - r;

            while (x <= y) {
                plotPixel(g, x, y);
                plotPixel(g, y, x);
                plotPixel(g, y, -x);
                plotPixel(g, x, -y);
                plotPixel(g, -x, -y);
                plotPixel(g, -y, -x);
                plotPixel(g, -y, x);
                plotPixel(g, -x, y);

                if (p < 0) {
                    p += 2 * x + 3;
                } else {
                    p += 2 * (x - y) + 5;
                    y--;
                }
                x++;
            }
        }
    }

    MidPointCircle(int h, int w) {
        JFrame frm = new JFrame("Midpoint Circle Demo");
        frm.setSize(w, h);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas(w, h);
        frm.add(canvas);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MidPointCircle(300, 300);
            }
        });
    }
}