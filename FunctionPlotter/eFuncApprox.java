/**
 * Write a description of class eFuncApprox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class eFuncApprox extends Function 
{
    int iApproxFactor=1;
    public double calcValue(double x)
    {
        if (iApproxFactor<=0)
        {
            return 0.0;
        }
        double dVal=1.0;
        for (int i=1;i<=iApproxFactor;i++)
        {
            dVal+=Math.pow(x,(double)i)/fac(i);
        }
        return dVal;
    }
    
    public void setApproxFactor(int iNewFactor)
    {
        this.iApproxFactor=iNewFactor;
    }

}
