
public class ParticleInteractions {

    public static void handleCollision(Particle p1, Particle p2)
{
    double dx = p2.getX() - p1.getX();
    double dy = p2.getY() - p1.getY();

    double distance = Math.sqrt(dx * dx + dy * dy);

    if (distance < 2 * p1.RADIUS)
    {
        // Avoid division by zero
        if (distance == 0)
        {
            return;
        }

        // Unit vector from p1 to p2
        double nx = dx / distance;
        double ny = dy / distance;

        // How much the particles overlap
        double overlap = 2 * p1.RADIUS - distance;

        // Move particles apart
        p1.xLocation -= nx * overlap / 2;
        p1.yLocation -= ny * overlap / 2;

        p2.xLocation += nx * overlap / 2;
        p2.yLocation += ny * overlap / 2;
    }
}
    
}
