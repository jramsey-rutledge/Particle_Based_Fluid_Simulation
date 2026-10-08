import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class SimulationPanel extends JPanel
{
    private ArrayList<Particle> particles;

    public SimulationPanel(ArrayList<Particle> particles)
    {
        this.particles = particles;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for (Particle p : particles)
        {
            int x = (int)p.getX();
            int y = (int)p.getY();

            g.fillOval(x, y, 10, 10);
        }
    }
}