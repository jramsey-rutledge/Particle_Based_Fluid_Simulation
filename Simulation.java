import java.util.ArrayList;
import javax.swing.*;

public class Simulation {

    public static void main(String[] args) {

        // time variables
        double dt = 0.1;
        double tf = 10;

        // particle information
        int numParticles = 100;

        // window dimensions
        int height =500, width=500;

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

            simPan.repaint();
        });

        timer.start();
        
    }
}