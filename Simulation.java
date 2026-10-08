import java.util.ArrayList;
import javax.swing.*;

public class Simulation {

    public static void main(String[] args) {

        // time and spatial variables
        double dt = 0.01;
        double tf = 10;
        double numTimesteps = tf/dt;
        int numParticles = 10;

        // set up window
        JFrame frame = new JFrame("Simulation");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // create particle list
        ArrayList<Particle> particleList = new ArrayList<>();

        for (int i =0; i < numParticles; i++){
            Particle temp = new Particle();
            particleList.add(temp);
        }
        
        // simulation panel
        SimulationPanel simPan = new SimulationPanel(particleList);
        frame.add(simPan);

        // simulation loop
        Timer timer = new Timer(16, e ->
        {
            for (Particle i : particleList) 
            {
                i.updateVelocity(dt);
                i.updatePosition(dt);
            }

            simPan.repaint();
        });
        
    }
}