import java.awt.*;
import java.awt.event.*;
import javax.swing.*;   
/**
 * Write a description of class TreeViewer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TreeViewer
{
    private final int WIDTH = 400;
    private final int HEIGHT = 500;


    
    private JLabel titleLabel;
    private TreePanel tree;
    private JPanel panel, tools;
    private JFrame frame;
    public static void main(String[] args)
    {
        TreeViewer viewer = new TreeViewer();
    }
    
    /**
     * Constructor for objects of class TreeViewer
     */
    public TreeViewer()
    {

        panel = new JPanel();
        panel.add(tools);
        panel.add(tree);

        frame = new JFrame();
        frame.setTitle("Knoch Snowflake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setVisible(true);
    }

}
