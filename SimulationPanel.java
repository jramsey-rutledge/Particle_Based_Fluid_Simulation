import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class SimulationPanel extends JPanel
{
    private ArrayList<Particle> particles;

    public SimulationPanel(ArrayList<Particle> particles)
    {
        this.particles = particles;
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.BLUE);

        for (Particle p : particles)
        {
            int x = (int)p.getX();
            int y = (int)p.getY();

            g.fillOval(x, y, 10, 10);
        }
    }
}