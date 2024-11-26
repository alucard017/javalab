import java.awt.*;
import javax.swing.*;

public class BresenhamLine {
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
            drawBresenhamLine(5, 50, 20, 20, g);
        }

        private void drawBresenhamLine(int x1, int y1, int x2, int y2, Graphics g) {
            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);
            int sx = x1 < x2 ? 1 : -1;
            int sy = y1 < y2 ? 1 : -1;
            int err = dx - dy;

            while (true) {
                plotPixel(g, x1, y1);
                if (x1 == x2 && y1 == y2) break;
                int e2 = 2 * err;
                if (e2 > -dy) {
                    err -= dy;
                    x1 += sx;
                }
                if (e2 < dx) {
                    err += dx;
                    y1 += sy;
                }
            }
        }
    }

    BresenhamLine(int h, int w) {
        JFrame frm = new JFrame("Bresenham Line Demo");
        frm.setSize(w, h);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas(w, h);
        frm.add(canvas);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BresenhamLine(300, 300);
            }
        });
    }
}