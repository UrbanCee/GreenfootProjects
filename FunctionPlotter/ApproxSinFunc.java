/**
 * Write a description of class ApproxSinFunc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ApproxSinFunc extends Function 
{
    int iApproxFactor=1;
    public double calcValue(double x)
    {
        if (iApproxFactor<=0)
        {
            return 0.0;
        }
        double dVal=0.0;
        for (int i=0;i<iApproxFactor;i++)
        {
            int iExponent=1+2*i;
            double dSign=1.0;
            if (i%2==1)
                dSign=-1.0;
            dVal+=Math.pow(x,(double)iExponent)/fac(iExponent)*dSign;
        }
        return dVal;
    }
    
    public void setApproxFactor(int iNewFactor)
    {
        this.iApproxFactor=iNewFactor;
    }
}
