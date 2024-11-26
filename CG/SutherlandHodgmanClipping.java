package javalab.CG;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class SutherlandHodgmanClipping extends JPanel {
    private List<Point> polygon;
    private int xMin = 100, yMin = 100, xMax = 300, yMax = 200; 

    public SutherlandHodgmanClipping() {
    
        polygon = new ArrayList<>();
        polygon.add(new Point(80, 150));
        polygon.add(new Point(200, 50));
        polygon.add(new Point(320, 150));
        polygon.add(new Point(250, 250));
        polygon.add(new Point(120, 240));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        g.setColor(Color.RED);
        g.drawRect(xMin, yMin, xMax - xMin, yMax - yMin);

        
        g.setColor(Color.BLUE);
        drawPolygon(polygon, g);


        List<Point> clippedPolygon = clipPolygon(polygon, xMin, yMin, xMax, yMax);


        g.setColor(Color.GREEN);
        drawPolygon(clippedPolygon, g);
    }

    private void drawPolygon(List<Point> points, Graphics g) {
        int n = points.size();
        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % n);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    private List<Point> clipPolygon(List<Point> polygon, int xMin, int yMin, int xMax, int yMax) {
        List<Point> clippedPolygon = polygon;

    
        clippedPolygon = clipEdge(clippedPolygon, "LEFT", xMin, yMin, xMax, yMax);
        clippedPolygon = clipEdge(clippedPolygon, "RIGHT", xMin, yMin, xMax, yMax);
        clippedPolygon = clipEdge(clippedPolygon, "BOTTOM", xMin, yMin, xMax, yMax);
        clippedPolygon = clipEdge(clippedPolygon, "TOP", xMin, yMin, xMax, yMax);

        return clippedPolygon;
    }

    private List<Point> clipEdge(List<Point> polygon, String edge, int xMin, int yMin, int xMax, int yMax) {
        List<Point> newPolygon = new ArrayList<>();
        int n = polygon.size();

        for (int i = 0; i < n; i++) {
            Point current = polygon.get(i);
            Point next = polygon.get((i + 1) % n);

            boolean currentInside = isInside(current, edge, xMin, yMin, xMax, yMax);
            boolean nextInside = isInside(next, edge, xMin, yMin, xMax, yMax);

            if (currentInside && nextInside) {
                
                newPolygon.add(next);
            } else if (currentInside) {
                
                newPolygon.add(intersection(current, next, edge, xMin, yMin, xMax, yMax));
            } else if (nextInside) {
                
                newPolygon.add(intersection(current, next, edge, xMin, yMin, xMax, yMax));
                newPolygon.add(next);
            }
            
        }
        
        return newPolygon;
    }

    private boolean isInside(Point p, String edge, int xMin, int yMin, int xMax, int yMax) {
        switch (edge) {
            case "LEFT":   return p.x >= xMin;
            case "RIGHT":  return p.x <= xMax;
            case "BOTTOM": return p.y <= yMax;
            case "TOP":    return p.y >= yMin;
            default:       return false;
        }
    }

    private Point intersection(Point p1, Point p2, String edge, int xMin, int yMin, int xMax, int yMax) {
        double x = 0, y = 0;
        double dx = p2.x - p1.x;
        double dy = p2.y - p1.y;

        switch (edge) {
            case "LEFT":
                x = xMin;
                y = p1.y + dy * (xMin - p1.x) / dx;
                break;
            case "RIGHT":
                x = xMax;
                y = p1.y + dy * (xMax - p1.x) / dx;
                break;
            case "BOTTOM":
                y = yMax;
                x = p1.x + dx * (yMax - p1.y) / dy;
                break;
            case "TOP":
                y = yMin;
                x = p1.x + dx * (yMin - p1.y) / dy;
                break;
        }
        return new Point((int) Math.round(x), (int) Math.round(y));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sutherland-Hodgman Clipping Algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new SutherlandHodgmanClipping());
        frame.setVisible(true);
    }
}

