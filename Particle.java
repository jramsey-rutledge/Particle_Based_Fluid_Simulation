public class Particle 
{
    protected double xLocation; // x location
    protected double yLocation; // y location
    protected double vx; // velocity in x direction
    protected double vy; // velocity in y direction
    protected double ax, ay; 
    protected final double MASS = 1.0; // 2.99e-23; 

    public Particle() 
    {
     xLocation = Math.random()*500;
     yLocation = Math.random()*500;
     vx = 0;
     vy = 0;
     ax = 0;
     ay = 9.8;
    }

    public double getX() 
    {
        return xLocation;
    }

    public double getY()
    {
        return yLocation;
    }

    public double getVX()
    {
        return vx;
    }

    public double getVY()
    {
        return vy;
    }

    public double getForce()
    {
        return ax+ay;
    }

    public void updateVelocity(double dt) {
        vx = dt*ax;
        vy = dt*ay;
    }

    public void updatePosition(double dt){
        if (xLocation < 500 && xLocation > 0) 
        {
            xLocation += dt*vx;
            yLocation += dt*vy;
        }
    }


}