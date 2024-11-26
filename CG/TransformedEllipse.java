import java.awt.*;
import javax.swing.*;

public class TransformedEllipse {
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
            drawTransformedEllipse(100, 60, 150, 150, 50, 50, Math.toRadians(45), g);  // Rotate by 45 degrees
        }

        private void drawTransformedEllipse(int rx, int ry, int cx, int cy, int tx, int ty, double angle, Graphics g) {
            int x = 0;
            int y = ry;
            int dx = 0;
            int dy = 2 * rx * rx * y;
            int p1 = (int) (ry * ry - rx * rx * ry + (0.25 * rx * rx));

            plotTransformedPixel(g, x, y, cx, cy, tx, ty, angle);
            plotTransformedPixel(g, -x, y, cx, cy, tx, ty, angle);
            plotTransformedPixel(g, x, -y, cx, cy, tx, ty, angle);
            plotTransformedPixel(g, -x, -y, cx, cy, tx, ty, angle);
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
                plotTransformedPixel(g, x, y, cx, cy, tx, ty, angle);
                plotTransformedPixel(g, -x, y, cx, cy, tx, ty, angle);
                plotTransformedPixel(g, x, -y, cx, cy, tx, ty, angle);
                plotTransformedPixel(g, -x, -y, cx, cy, tx, ty, angle);
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

                plotTransformedPixel(g, x, y, cx, cy, tx, ty, angle);
                plotTransformedPixel(g, -x, y, cx, cy, tx, ty, angle);
                plotTransformedPixel(g, x, -y, cx, cy, tx, ty, angle);
                plotTransformedPixel(g, -x, -y, cx, cy, tx, ty, angle);
            }
        }
        private void plotTransformedPixel(Graphics g, int x, int y, int cx, int cy, int tx, int ty, double angle) {
            int translatedX = x + tx;
            int translatedY = y + ty;
            int rotatedX = (int) (translatedX * Math.cos(angle) - translatedY * Math.sin(angle));
            int rotatedY = (int) (translatedX * Math.sin(angle) + translatedY * Math.cos(angle));
            plotPixel(g, rotatedX, rotatedY, cx, cy);
        }
    }

    TransformedEllipse(int h, int w) {
        JFrame frm = new JFrame("Transformed Ellipse Demo");
        frm.setSize(w, h);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas(w, h);
        frm.add(canvas);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TransformedEllipse(400, 400);  // Change window size as needed
            }
        });
    }
}
