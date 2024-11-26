import java.awt.*;
import javax.swing.*;

public class DDA {

    private class Canvas extends JPanel {
        int w, h;

        Canvas(int w, int h) {
            this.w = w;
            this.h = h;
        }

        private void plotPixel(Graphics g, int x, int y) {
            g.fillRect(x+(w/2), (h/2)-y, 1, 1);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawDDALine(5, 50, 20, 20, g);
        }

        private void drawDDALine(int x1, int y1, int x2, int y2, Graphics g) {
            int dx = x2 - x1;
            int dy = y2 - y1;
            int steps = Math.max(Math.abs(dx), Math.abs(dy));
            float xInc = dx / (float) steps;
            float yInc = dy / (float) steps;
            float x = x1;
            float y = y1;

            for (int i = 0; i <= steps; i++) {
                plotPixel(g, (int) Math.round(x), (int) Math.round(y));
                x += xInc;
                y += yInc;
            }
        }
    }

    DDA(int h, int w) {
        JFrame frm = new JFrame("DDA Line Demo");
        frm.setSize(w, h);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas(w, h);
        frm.add(canvas);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DDA(300, 300);
            }
        });
    }
}