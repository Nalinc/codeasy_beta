package frame;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

// This class will display an image at a specified location on file system.
// If the image is larger than the screen size, scrollbars will be created
// so you can scroll through the image.
// This program uses ImageIO class which is powerful class
// in package, javax.imageio.

class JImagePanel extends JPanel
{
    private BufferedImage image;
    int x, y;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int w=screenSize.width;
    int h=screenSize.height;
    public JImagePanel(BufferedImage image, int x, int y) 
    {
        super();
        this.image = image;
        this.x = x;
        this.y = y;
    }
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.setColor(Color.white);
       g.fillRect(x, y,w,h*2);
        g.drawImage(image, x, y, null);
    }

    public JImagePanel() throws IOException
    {
        this.setOpaque(true);
    this.setBackground(Color.white);
        loadAndDisplayImage();
    }
    
    
    public static void main(String[] args) 
    {
        
  //      JFrame frame = new JFrame("Display Image");
     //   new JImagePanel();
    }
    
    
    //--------------
    
    public void loadAndDisplayImage() throws IOException 
    {
     InputStream stream =this.getClass().getResourceAsStream( "/frame/cover.png" );
     BufferedImage loadImg = ImageIO.read( stream );
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension dimension = toolkit.getScreenSize();
 
        JImagePanel imagePanel = new JImagePanel(loadImg, 0, 0);

// Earlier the image displayed fine, but the scrollbars were missing.
// The following did the trick. When preferredSize is higher than
// the frame size, both scrollbars are automatically created.
// Because imagePanel does not have layout manager, we need to invoke
// setPreferredSize()
	imagePanel.setPreferredSize(new Dimension(
	loadImg.getWidth(), loadImg.getHeight()));

	          JScrollPane osp = new JScrollPane(imagePanel);
          osp. setVerticalScrollBarPolicy( JScrollPane. VERTICAL_SCROLLBAR_ALWAYS );
 osp.setPreferredSize(new Dimension(1000, 450));

      
      // add(imagePanel); 
      add(osp);
    } 

    public static BufferedImage loadImage(String ref) 
    {
	  BufferedImage bimg = null;
	  try 
          {
            bimg = ImageIO.read(new File(ref));
	  } catch (Exception e) 
              { e.printStackTrace();
	        }
          return bimg;
    }
    
    
    
    
    
    
}