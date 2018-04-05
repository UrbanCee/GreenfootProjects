import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Write a description of class Tex here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tex extends Actor
{
    static List<Palette> palettes = null;
    static List<GreenfootImage> baseImages = null;
    //baseImages:   first 5 straight left
    static List<GreenfootImage> baseImagesShroom = null;
    //shrooms 0-3 first type, 4-7 inverted type
    static List<GreenfootImage> imageCatalogueBody = null;
    static List<GreenfootImage> imageCatalogueHead = null;
    //catalogue: 0-5 left, 6-10 right
    static List<GreenfootImage> shroomCatalogue = null;

    //8 palettes with 3 colors each, first and 3rd for body first 2 for head
    //palette 0 is same as in base Images
    static Palette basePalette = null;


    static public void loadImagesFromFile()
    {
        palettes = new ArrayList<Palette>(8);
        for (int i=0;i<8;i++)
        {
            GreenfootImage image = new GreenfootImage(new String("palette_0")+String.valueOf(i+1)+".png");
            ArrayList<Color> c = new ArrayList<Color>(3);
            for (int j=0;j<3;j++)
                c.add(image.getColorAt(1+8*j,0));
            palettes.add(new Palette(c.get(0),c.get(1),c.get(2)));
            if (i==0)
                basePalette = new Palette(palettes.get(0));
        }
        baseImages = new ArrayList<GreenfootImage>(12);
        for (int i=1;i<6;i++)
        {
            baseImages.add(new GreenfootImage(new String("straight_0")+String.valueOf(i)+".png"));
        }
        List<GreenfootImage> diags = new ArrayList<GreenfootImage>(2);
        for (int i=1;i<3;i++)
        {
            GreenfootImage diag=new GreenfootImage(new String("diag_0")+String.valueOf(i)+".png");
            baseImages.add(new GreenfootImage(diag));
            diag.mirrorHorizontally();
            diags.add(diag);
        }
        for (int i=1;i<4;i++)
        {
            baseImages.add(new GreenfootImage(new String("down_0")+String.valueOf(i)+".png"));
        }
        baseImages.add(diags.get(0));
        baseImages.add(diags.get(1));
        baseImagesShroom = new ArrayList<GreenfootImage>(8);
        for (int i=1;i<5;i++)
        {
            baseImagesShroom.add(new GreenfootImage(new String("shrooma_0")+String.valueOf(i)+".png"));
        }
        for (int i=1;i<5;i++)
        {
            baseImagesShroom.add(new GreenfootImage(new String("shroomb_0")+String.valueOf(i)+".png"));
        }
        
        
        createImageCatalogue(0);
    }

    static public void createImageCatalogue(int iPalette)
    {
        imageCatalogueBody = new ArrayList<GreenfootImage>(baseImages.size()*2);
        imageCatalogueHead = new ArrayList<GreenfootImage>(baseImages.size()*2);
        shroomCatalogue = new ArrayList<GreenfootImage>(baseImagesShroom.size());
        Palette bodyPalette = new Palette(palettes.get(iPalette));
        bodyPalette.makeBodyPalette();
        //normal
        for (int i=0;i<baseImages.size();i++)
        {
            GreenfootImage head = changePalette(baseImages.get(i),palettes.get(iPalette));
            GreenfootImage body = changePalette(baseImages.get(i),bodyPalette);
            int iScaleX=2*head.getWidth();
            int iScaleY=2*head.getHeight();
            head.scale(iScaleX,iScaleY);
            body.scale(iScaleX,iScaleY);
            imageCatalogueHead.add(head);
            imageCatalogueBody.add(body);
        }
        //inverted
        for (int i=0;i<baseImages.size();i++)
        {
            GreenfootImage head = changePalette(baseImages.get(i),palettes.get(iPalette));
            GreenfootImage body = changePalette(baseImages.get(i),bodyPalette);
            head.mirrorHorizontally();
            body.mirrorHorizontally();
            int iScaleX=2*head.getWidth();
            int iScaleY=2*head.getHeight();
            head.scale(iScaleX,iScaleY);
            body.scale(iScaleX,iScaleY);
            imageCatalogueHead.add(head);
            imageCatalogueBody.add(body);
        }
        for (int i=0;i<baseImagesShroom.size();i++)
        {
            GreenfootImage shroom = changePalette(baseImagesShroom.get(i),bodyPalette);
            int iScaleX=2*shroom.getWidth();
            int iScaleY=2*shroom.getHeight();
            shroom.scale(iScaleX,iScaleY);
            shroomCatalogue.add(shroom);
        }

    }
    
    static public GreenfootImage changePalette(GreenfootImage baseImage,Palette newPal)
    {
        GreenfootImage newImage = new GreenfootImage(baseImage);
        for (int iCol=0;iCol<3;iCol++)
        for (int iy=0;iy<newImage.getHeight();iy++)
            for (int ix=0;ix<newImage.getWidth();ix++)
            {
                if (newImage.getColorAt(ix,iy).equals(basePalette.get(iCol)))
                    newImage.setColorAt(ix,iy,newPal.get(iCol));
            }
        return newImage;
    }
    
    static public int baseSegmentImageSize()
    {
        return baseImages.size();
    }

}
