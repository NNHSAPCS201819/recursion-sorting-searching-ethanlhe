import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;
public class TreePanel2 extends JPanel
{
    private final int PANEL_WIDTH = 1620;
    private final int PANEL_HEIGHT = 980;
    private final double SQ = Math.sqrt(3.0) / 6;
    private final int c1 = 128;
    private final int c2 = 128;
    private final int c3 = 128;
    private final int TOPX = 810, TOPY = 800;
    private final double SCALING_FACTOR = .8;
    private final int BRANCH_ANGLE = 30;
    private int current; //current order
    private double minBranch;
    private Color babyBlue = new Color(135,206,250);
    private Color hotPink = new Color(255,20,147);
    //-----------------------------------------------------------------
    //  Sets the initial fractal order to the value specified.
    //-----------------------------------------------------------------
    public TreePanel2 (int currentOrder)
    {
        current = currentOrder;
        setBackground (babyBlue);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    //-----------------------------------------------------------------
    //  Draws the fractal recursively. Base case is an order of 1 for
    //  which a simple straight line is drawn. Otherwise three
    //  intermediate points are computed, and each line segment is
    //  drawn as a fractal.
    //-----------------------------------------------------------------
    public void drawFractal (int x1, int y1, double angle, int length, Color custom, Graphics page, int thicc)
    {
        Graphics2D g2 = (Graphics2D) page;
        int change;
        int change2;
        int change3;
        if (length==0)
        {
            Graphics2D g2d = (Graphics2D) page;
            Ellipse2D.Double flower
            = new Ellipse2D.Double(x1-4, y1-4, 9, 9);
            g2d.setColor(Color.white);
            g2d.fill(flower);
            g2d.draw(flower);
            Ellipse2D.Double bud
            = new Ellipse2D.Double(x1-2, y1-2, 3, 3);
            g2d.setColor(hotPink);
            g2d.fill(bud);
            g2d.draw(bud);
            return;
        }
        else
        {

            int x2 = x1 + (int)(Math.cos(Math.toRadians(angle)) * length * 12.0);
            int y2 = y1 + (int)(Math.sin(Math.toRadians(angle)) * length * 12.0);

            minBranch = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));

            Graphics2D g2d = (Graphics2D) page;
            g2d.setStroke(new BasicStroke(thicc));
            change = custom.getRed()+9;
            change2 = custom.getGreen()+9;
            change3 = custom.getBlue()+9;
            Color customColor = new Color(c1,c2,c1);
            page.setColor(customColor);
            g2d.drawLine(x1, y1, x2, y2);

            drawFractal (x2, y2, angle + 20, length-1, customColor, page, thicc-1);
            drawFractal (x2, y2, angle - 20, length-1, customColor, page, thicc-1);

        }
    }

    //-----------------------------------------------------------------
    //  Performs the initial calls to the drawFractal method.
    //-----------------------------------------------------------------
    @Override
    public void paintComponent (Graphics page)
    {
        super.paintComponent (page);
        Color customColor = new Color(c1,c2,c3);
        //page.setColor (Color.white);

        drawFractal (TOPX, TOPY, -90, 11, customColor, page, 10);
    }
}
