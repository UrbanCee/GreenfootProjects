import greenfoot.*;
import java.util.ArrayList;

public class Palette  
{
    ArrayList<Color> cols = new ArrayList<Color>(3);
    public Palette(Palette pal)
    {
        for (int i=0;i<3;i++)
            cols.add(pal.get(i));
    }
    public Palette(Color c1, Color c2, Color c3)
    {
        cols.add(c1);
        cols.add(c2);
        cols.add(c3);
    }
    
    public Color get(int i)
    {
        return cols.get(i);
    }
    
    public void set(int i, Color col)
    {
        if (i<0 || i>2)
            return;
        cols.set(i,col);
    }
    
    public void makeBodyPalette()
    {
        cols.set(1,cols.get(2));
    }
    
}
