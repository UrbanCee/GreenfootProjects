public class Vector  
{
    public double x=0.0,y=0.0;
    public double r=0.0,phi=0.0,phiDeg=0.0;
    public Vector()
    {
    }
    public Vector(double x, double y)
    {
        this.x=x;
        this.y=y;
        calcPolar();
    }
    public Vector(Vector v)
    {
        this.x=v.x;
        this.y=v.y;
        calcPolar();
    }
    
    private void calcPolar()
    {
        r=Math.sqrt(x*x+y*y);
        if (r!=0.0)
        {
            phi=Math.atan2(x,y);
            phiDeg=Math.toDegrees(phi);
        }
    }
    private void calcCartesian()
    {
        x=r*Math.sin(phi);
        y=r*Math.cos(phi);
    }
    public Vector normalize()
    {
        if (r==0.0)
            return this;
        r=1;
        calcCartesian();
        return this;
    }
    public Vector setLength(double r)
    {
        this.r=r;
        calcCartesian();
        return this;
    }
    public Vector setAngleRad(double phi)
    {
        this.phi=phi;
        calcCartesian();
        return this;
    }
    public  Vector setAngleDeg(double phiDeg)
    {
        this.phiDeg=phiDeg;
        this.phi=Math.toRadians(phiDeg);
        calcCartesian();
        return this;
    }
    public Vector setX(double x)
    {
        this.x=x;
        calcPolar();
        return this;
    }
    public Vector setY(double y)
    {
        this.y=y;
        calcPolar();
        return this;
    }
    public Vector setXY(double x, double y)
    {
        this.x=x;
        this.y=y;
        calcPolar();
        return this;
    }
    public Vector setR(double r)
    {
        setLength(r);
        return this;
    }
    public Vector setRPhi(double r, double phi)
    {
        this.r=r;
        this.phi=phi;
        calcCartesian();
        return this;
    }
    public Vector add(Vector v)
    {
        x+=v.x;
        y+=v.y;
        calcPolar();
        return this;
    }
    public Vector sub(Vector v)
    {
        x-=v.x;
        y-=v.y;
        calcPolar();
        return this;
    }
    public Vector negative()
    {
        x=-x;
        y=-y;
        calcPolar();
        return this;
    }
    public Vector mult(double k)
    {
        x*=k;
        y*=k;
        calcPolar();
        return this;
    }
    public double dot(Vector v)
    {
        return x*v.x+y*v.y;
    }
    public static Vector add(Vector v1, Vector v2)
    {
        Vector v = new Vector(v1);
        return v.add(v2);
    }
    public static Vector sub(Vector v1, Vector v2)
    {
        Vector v = new Vector(v1);
        return v.sub(v2);
    }
    public static double dot(Vector v1, Vector v2)
    {
        return v1.x*v2.x+v1.y*v2.y;
    }
    public static Vector mult(Vector v1, double k)
    {
        Vector v= new Vector(v1);
        return v.mult(k);
    }
    public int getGreenfootRotation()
    {
        return (int) Math.round(Math.toDegrees(Math.atan2(x,-y)));
    }
    
}
