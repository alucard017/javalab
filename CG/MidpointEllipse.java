import java.awt.*;
import javax.swing.*;

public class MidpointEllipse {
    private class Canvas extends JPanel {
        int w, h;

        Canvas(int w, int h) {
            this.w = w;
            this.h = h;
        }
        private void plotPixel(Graphics g, int x, int y, int cx, int cy) {
            g.fillRect(cx + x, cy - y, 1, 1); // For a centered ellipse
        }
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawEllipse(100, 60, 150, 150, g);  // Example ellipse with radii 100 and 60
        }
        private void drawEllipse(int rx, int ry, int cx, int cy, Graphics g) {
            int x = 0;
            int y = ry;
            int dx = 0;
            int dy = 2 * rx * rx * y;
            int p1 = (int) (ry * ry - rx * rx * ry + (0.25 * rx * rx));
            plotPixel(g, x, y, cx, cy);
            plotPixel(g, -x, y, cx, cy);
            plotPixel(g, x, -y, cx, cy);
            plotPixel(g, -x, -y, cx, cy);
            while (dx < dy) {
                x++;
                dx += 2 * ry * ry;
                if (p1 < 0) {
                    p1 += dx + ry * ry;
                } else {
                    y--;
                    dy -= 2 * rx * rx;
                    p1 += dx - dy + ry * ry;
                }
                plotPixel(g, x, y, cx, cy);
                plotPixel(g, -x, y, cx, cy);
                plotPixel(g, x, -y, cx, cy);
                plotPixel(g, -x, -y, cx, cy);
            }

            int p2 = (int) (ry * ry * (x + 0.5) * (x + 0.5) + rx * rx * (y - 1) * (y - 1) - rx * rx * ry * ry);

            while (y >= 0) {
                y--;
                dy -= 2 * rx * rx;
                if (p2 > 0) {
                    p2 += rx * rx - dy;
                } else {
                    x++;
                    dx += 2 * ry * ry;
                    p2 += dx - dy + rx * rx;
                }
                plotPixel(g, x, y, cx, cy);
                plotPixel(g, -x, y, cx, cy);
                plotPixel(g, x, -y, cx, cy);
                plotPixel(g, -x, -y, cx, cy);
            }
        }
    }

    MidpointEllipse(int h, int w) {
        JFrame frm = new JFrame("Midpoint Ellipse Demo");
        frm.setSize(w, h);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas(w, h);
        frm.add(canvas);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MidpointEllipse(400, 400);  // Change window size as needed
            }
        });
    }
}
