import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;

public class TreePanel extends JPanel
{
    private final int PANEL_WIDTH = 1620;
    private final int PANEL_HEIGHT = 980;

    private final double SQ = Math.sqrt(3.0) / 6;

    private final int TOPX = 810, TOPY = 470;
    private final double SCALING_FACTOR = .8;
    private final int BRANCH_ANGLE = 30;
    private int current; //current order
    private double minBranch;
    //-----------------------------------------------------------------
    //  Sets the initial fractal order to the value specified.
    //-----------------------------------------------------------------
    public TreePanel (int currentOrder)
    {
        current = currentOrder;
        setBackground (Color.black);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    //-----------------------------------------------------------------
    //  Draws the fractal recursively. Base case is an order of 1 for
    //  which a simple straight line is drawn. Otherwise three
    //  intermediate points are computed, and each line segment is
    //  drawn as a fractal.
    //-----------------------------------------------------------------
    public void drawFractal (int x1, int y1, double angle, int length, Graphics page)
    {
        Graphics2D g2 = (Graphics2D) page;


        if (length==0)
        {
            Graphics2D g2d = (Graphics2D) page;
            g2d.fillOval(x1-4, y1-4, 9, 9);
           
            return;
        }
        else
        {

            int x2 = x1 + (int)(Math.cos(Math.toRadians(angle)) * length * 13.0);
            int y2 = y1 + (int)(Math.sin(Math.toRadians(angle)) * length * 13.0);

            minBranch = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));

            Graphics2D g2d = (Graphics2D) page;
            g2d.setStroke(new BasicStroke(3));
            g2d.drawLine(x1, y1, x2, y2);


            
            drawFractal (x2, y2, angle + 20, length-1, page);
            drawFractal (x2, y2, angle - 20, length-1, page);

        }
    }
    //-----------------------------------------------------------------
    //  Performs the initial calls to the drawFractal method.
    //-----------------------------------------------------------------
    @Override
    public void paintComponent (Graphics page)
    {
        super.paintComponent (page);

        page.setColor (Color.white);

        drawFractal (TOPX, TOPY, 0, 10, page);
        drawFractal (TOPX, TOPY, 180, 10, page);
    }
}
