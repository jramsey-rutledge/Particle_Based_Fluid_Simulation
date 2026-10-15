import java.util.ArrayList;
import javax.swing.*;

public class Simulation {

    public static void main(String[] args) {

        // time variables
        double dt = 0.1;
        double tf = 10;

        // particle information
        int numParticles = 500;

        // window dimensions
        int height=500, width=500;

        // set up window
        JFrame frame = new JFrame("Simulation");

        // create particle list
        ArrayList<Particle> particleList = new ArrayList<>();

        for (int i =0; i < numParticles; i++){
            Particle temp = new Particle();
            particleList.add(temp);
        }
        
        // simulation panel
        SimulationPanel simPan = new SimulationPanel(particleList);
        frame.add(simPan);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // simulation loop
        Timer timer = new Timer(16, e ->
        {
            for (Particle i : particleList) 
            {
                i.updateVelocity(dt);
                i.updatePosition(dt);
                i.handleBorders(width,height);
            }

            // handle particle collisions
            for (int i = 0; i < particleList.size(); i++)
            {
                for (int j = i + 1; j < particleList.size(); j++)
                {
                    Particle p1 = particleList.get(i);
                    Particle p2 = particleList.get(j);

                    ParticleInteractions.handleCollision(p1, p2);
                }
            }

            simPan.repaint();
        });

        timer.start();
        
    }
}