public class Particle 
{
    protected double xLocation, yLocation; // location
    protected double vx, vy; // velocity
    protected double ax, ay; // acceleration
    protected final double MASS = 1.0; // 2.99e-23; 
    protected final double RADIUS = 5;

    public Particle() 
    {
     xLocation = Math.random()*500;
     yLocation = Math.random()*500;
     vx = 0;
     vy = 0;
     ax = Math.random()*20-10;
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

    public void handleBorders(int width, int height)
    {
        if (xLocation - RADIUS < 0)
        {
            xLocation = RADIUS;
            vx = -vx;
        }

        if (xLocation + RADIUS > width)
        {
            xLocation = width-RADIUS;
            vx = -vx;
        }

        if (yLocation - RADIUS < 0)
        {
            yLocation = RADIUS;
            vy = -vy;
        }

        if (yLocation + RADIUS > height)
        {
            yLocation = height - RADIUS;
            vy = -vy;
        }
    }

    public void updateVelocity(double dt) {
        vx += dt*ax;
        vy += dt*ay;
    }

    public void updatePosition(double dt){
        if (xLocation < 500 && xLocation > 0) 
        {
            xLocation += dt*vx;
            yLocation += dt*vy;
        }
    }




}