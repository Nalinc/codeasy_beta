package frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.JPopupMenu.Separator;
import tabbedpane.ClosableTabbedPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.awt.geom.Rectangle2D;
import java.io.IOException;




public class TabFrame extends JFrame implements ActionListener{
        static public ClosableTabbedPane tabbedPane;
        public static int flag;
        private javax.swing.JButton btn_about;
        private javax.swing.JButton btn_close;
        private javax.swing.JButton btn_compile;
        private javax.swing.JButton btn_new;
        private javax.swing.JButton btn_open;
        private javax.swing.JButton btn_run;
        private javax.swing.JButton btn_save;
        private javax.swing.JButton btn_search;
        private javax.swing.JButton btn_settings;
        private javax.swing.JPanel jPanel1;
        public static javax.swing.JTextField txt_search;

        static SplashScreen mySplash;                   // instantiated by JVM we use it to get graphics
        static Graphics2D splashGraphics;               // graphics context for overlay of the splash image
        static Rectangle2D.Double splashTextArea;       // area where we draw the text
        static Rectangle2D.Double splashProgressArea;   // area where we draw the progress bar
        static Font font;                               // used to draw our text

        
        
        
        
        public static int count=0;
        String filename,tabname;
    private Separator jSeparator2;
    private Separator jSeparator1;
        /*
      static void renderSplashFrame(Graphics2D g, int frame) 
      {
        final String[] comps = {"foo", "bar", "baz"};
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(120,140,200,40);
        g.setPaintMode();
        g.setColor(Color.BLACK);
        g.drawString("Loading "+comps[(frame/5)%3]+"...", 120, 150);
       }
    */
    public TabFrame() 
        {	
                     
                //---------------------------------
        this.getContentPane().setBackground( new Color(0,0,0) );
  
        
        
        
        /*      final SplashScreen splash = SplashScreen.getSplashScreen();
        if (splash == null) {
            System.out.println("SplashScreen.getSplashScreen() returned null");
//            return;
        }
        else
        {
            Graphics2D g = splash.createGraphics();
            if (g == null) {
                System.out.println("g is null");
                return;
            }
            for(int i=0; i<100; i++) 
            {
                renderSplashFrame(g, i);
                splash.update();
                try 
                {
                    Thread.sleep(90);
                }
                catch(InterruptedException e) 
                {
                }
            }
            splash.close();
            setVisible(true);
            toFront();            
        }      
    */
    //-------------------------------
                addMenu();    
                addTabbedPane();
             Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                             

        }

        private void addMenu() 
        {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
                
      //-----
                
        jPanel1 = new javax.swing.JPanel();
        btn_new = new javax.swing.JButton();
        btn_open = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_settings = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        btn_compile = new javax.swing.JButton();
        btn_run = new javax.swing.JButton();
        btn_about = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new.png"))); // NOI18N
        btn_new.addActionListener(this);
        
        btn_open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open.png"))); // NOI18N
        btn_open.addActionListener(this);

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btn_save.addActionListener(this);

        btn_settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/settings.png"))); // NOI18N
        btn_settings.addActionListener(this);

        txt_search.setText("search");
        txt_search.addActionListener(this);

        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        btn_search.addActionListener(this);

        btn_compile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/compile.png"))); // NOI18N
        btn_compile.addActionListener(this);

        btn_run.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/run.png"))); // NOI18N
        btn_run.addActionListener(this);

        btn_about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/about.png"))); // NOI18N
        btn_about.addActionListener(this);

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png"))); // NOI18N
        btn_close.addActionListener(this);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_new)
                .addGap(18, 18, 18)
                .addComponent(btn_open)
                .addGap(18, 18, 18)
                .addComponent(btn_save)
                .addGap(18, 18, 18)
                .addComponent(btn_settings)
                .addGap(18, 18, 18)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search)
                .addGap(18, 18, 18)
                .addComponent(btn_compile, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_run, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_about)
                .addGap(18, 18, 18)
                .addComponent(btn_close)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_new)
                        .addComponent(btn_open))
                    .addComponent(btn_save)
                    .addComponent(btn_settings)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_search))
                    .addComponent(btn_compile)
                    .addComponent(btn_run)
                    .addComponent(btn_about)
                    .addComponent(btn_close))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //-----
                jPanel1.setSize(screenSize);
                add(jPanel1,BorderLayout.NORTH);
                JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("File");
                JMenu menu2 = new JMenu("Edit");
                JMenu menu3 = new JMenu("Build");
                JMenu menu4 = new JMenu("Settings");
                JMenu menu5 = new JMenu("Help");
                
		JMenuItem filemenu1 = new JMenuItem("New");
      		JMenuItem filemenu2 = new JMenuItem("Open");
                jSeparator1 = new javax.swing.JPopupMenu.Separator();
                JMenuItem filemenu3 = new JMenuItem("Save");
                JMenuItem filemenu4 = new JMenuItem("Exit");


                JMenuItem editmenu1 = new JMenuItem("Copy");
                JMenuItem editmenu2 = new JMenuItem("Paste");
                jSeparator2 = new javax.swing.JPopupMenu.Separator(); 
                JMenuItem editmenu4 = new JMenuItem("Find");
                JMenuItem editmenu5 = new JMenuItem("Find Next");

                JMenuItem buildmenu1 = new JMenuItem("Compile");
                JMenuItem buildmenu2 = new JMenuItem("Run");
                
                JMenuItem settingsmenu1 = new JMenuItem("Configure IDE");

                JMenuItem helpmenu1 = new JMenuItem("Start Page");
                JMenuItem helpmenu2 = new JMenuItem("License");
                JMenuItem helpmenu3 = new JMenuItem("About");



                filemenu1.addActionListener(this) ;
                filemenu2.addActionListener(this) ;
                filemenu3.addActionListener(this) ;
                filemenu4.addActionListener(this) ;

                editmenu1.addActionListener(this);
                editmenu2.addActionListener(this);
                editmenu4.addActionListener(this);
                editmenu5.addActionListener(this);

                buildmenu1.addActionListener(this);
                buildmenu2.addActionListener(this);

                settingsmenu1.addActionListener(this);
                
                helpmenu1.addActionListener(this);
                helpmenu2.addActionListener(this);
                helpmenu3.addActionListener(this);

                menu1.add(filemenu1);
                menu1.add(filemenu2);
                menu1.add(jSeparator1);
                menu1.add(filemenu3);
                menu1.add(filemenu4);

                menu2.add(editmenu1);
                menu2.add(editmenu2);
                menu2.add(jSeparator2);
                menu2.add(editmenu4);
                menu2.add(editmenu5);
                
                menu3.add(buildmenu1);
                menu3.add(buildmenu2);
                menu4.add(settingsmenu1);
                
                menu5.add(helpmenu1);
                menu5.add(helpmenu2);
                menu5.add(helpmenu3);
                
                
                
                menuBar.add(menu1);
                menuBar.add(menu2);
		menuBar.add(menu3);
                menuBar.add(menu4);
                menuBar.add(menu5);
                setJMenuBar(menuBar);
                
	}

        
        public void actionPerformed(ActionEvent arg0) 
        { 
            Object source=arg0.getSource();
            String str=arg0.getActionCommand();
            if(source==btn_new||str.equals("New"))
            {tabbedPane.addTab("Untitled " + (tabbedPane.getTabCount() + 1),
						new MyJPanel());
                   tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
            }
            else  if(source==btn_close||str.equals("Exit"))
               System.exit(0);      
            
            else if(source==btn_search||str.equals("Find"))
            {
                count++;
                MyJPanel tmp=(MyJPanel) tabbedPane.getSelectedComponent();
                if(str.equals("Find"))
                 flag=1;
                   tmp.find();
            }
            
            else if(source==btn_open||str.equals("Open"))
            {
                 FileDialog fd = new FileDialog(TabFrame.this, "select File",FileDialog.LOAD);
                 fd.show();
                 
                 if (fd.getFile()!=null)
                 {
                     tabbedPane.addTab("Untitled " + (tabbedPane.getTabCount() + 1),
						new MyJPanel());                  
                 MyJPanel tmp=(MyJPanel) tabbedPane.getComponentAt(tabbedPane.getTabCount() - 1);
                   tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
                     filename = fd.getDirectory() + fd.getFile();
                 tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(),fd.getFile());
                     tmp.ReadFile(fd.getDirectory() , fd.getFile());
                   
                 }
            }
            else if(source==btn_save||str.equals("Save"))
            {
             FileDialog fd = new FileDialog(TabFrame.this,"Save File",FileDialog.SAVE);
             fd.show();
             if (fd.getFile()!=null)
            {
                 filename = fd.getDirectory() + fd.getFile();
                 MyJPanel tmp=(MyJPanel) tabbedPane.getSelectedComponent();
                 tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(),fd.getFile());
                 tmp.SaveFile(fd.getDirectory(),fd.getFile());
             }

            }
            
            else if(source==btn_compile||str.equals("Compile"))
            {
                 MyJPanel tmp=(MyJPanel) tabbedPane.getSelectedComponent();
                 int tabIndex=tabbedPane.getSelectedIndex();
                 
                 tabname=tabbedPane.getTabTitleAt(tabIndex);
                 tmp.CompileFile(tmp.path+tabname);
                 
            }
            else if(source==btn_run||str.equals("Run"))
            {
                
                 MyJPanel tmp=(MyJPanel) tabbedPane.getSelectedComponent();
                 int tabIndex=tabbedPane.getSelectedIndex();
                 
                 tabname=tabbedPane.getTabTitleAt(tabIndex);
                 StringTokenizer st =new StringTokenizer(tabname,".");
                 String s=st.nextToken();
             //    JOptionPane.showMessageDialog(this, s);
                 tmp.RunFile(s);
            }
            else if(str.equals("Copy"))
            {
               MyJPanel tmp=(MyJPanel) tabbedPane.getSelectedComponent();
                tmp.copy();   
            }
            else if(str.equals("Paste"))
            {
               MyJPanel tmp=(MyJPanel) tabbedPane.getSelectedComponent();
                tmp.paste();
            }
            
            else if(str.equals("About")||source==btn_about)
            {
                JOptionPane.showMessageDialog(this,"CodeEasy 1.1.0 (Beta)\n\nWebsite:www.sourceforge.org/projects/codeasy\nLicense : GNU GPL(version 3)\nCopyright 2012\n\nDeveloped By:\nNalin Chhibber");
            }
            else if(str.equals("License"))
            {
                try
                { new NewJFrame().setVisible(true);
                }catch(Exception e){JOptionPane.showMessageDialog(null,getClass().getResource("licence.txt").toString());
                }
            }

        
        }

        
        
        
	private void addTabbedPane() {
		// Create ClosableTabbedPane and override the tabAboutToClose
		// to be notified when certain tab is going to close.
		tabbedPane = new ClosableTabbedPane() {

			public boolean tabAboutToClose(int tabIndex) {
				String tab = tabbedPane.getTabTitleAt(tabIndex);
				int choice = JOptionPane.showConfirmDialog(null,
						"You are about to close '" + tab
								+"\ncontinue ?",
						"Confirmation Dialog", JOptionPane.INFORMATION_MESSAGE);
				return choice == 0; // if returned false tab closing will be
								// canceled
			}
		};
		getContentPane().add(tabbedPane);
	}

        
     static private void looknfeel()
      {         
        try 
        {
          for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
          {
            if ("Nimbus".equals(info.getName())) 
             { javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
              }
           }
         }catch (ClassNotFoundException ex) 
         {
          java.util.logging.Logger.getLogger(TabFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }catch (InstantiationException ex) 
          {
            java.util.logging.Logger.getLogger(TabFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }catch (IllegalAccessException ex) 
          {
            java.util.logging.Logger.getLogger(TabFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }catch (javax.swing.UnsupportedLookAndFeelException ex) 
          {
            java.util.logging.Logger.getLogger(TabFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
           }

        }
        
       private static void splashInit()
    {
        mySplash = SplashScreen.getSplashScreen();
        if (mySplash != null)
        {   // if there are any problems displaying the splash this will be null
            Dimension ssDim = mySplash.getSize();
            int height = ssDim.height;
            int width = ssDim.width;
            // stake out some area for our status information
            splashTextArea = new Rectangle2D.Double(15., height*0.88, width * .45, 32.);
            splashProgressArea = new Rectangle2D.Double(width * .55, height*.92, width*.4, 12 );

            // create the Graphics environment for drawing status info
            splashGraphics = mySplash.createGraphics();
            font = new Font("Dialog", Font.PLAIN, 14);
            splashGraphics.setFont(font);
            
            // initialize the status info
            splashText("Starting");
            splashProgress(0);
        }
        else
        {
            System.out.print("errorrr");
        }
    }
       
       
       public static void splashText(String str)
    {
        if (mySplash != null && mySplash.isVisible())
        {   // important to check here so no other methods need to know if there
            // really is a Splash being displayed

            // erase the last status text
            splashGraphics.setPaint(Color.LIGHT_GRAY);
            splashGraphics.fill(splashTextArea);

            // draw the text
            splashGraphics.setPaint(Color.BLACK);
            splashGraphics.drawString(str, (int)(splashTextArea.getX() + 10),(int)(splashTextArea.getY() + 15));

            // make sure it's displayed
            mySplash.update();
        }
    }
       
       //---------------------
        public static void splashProgress(int pct)
    {
        if (mySplash != null && mySplash.isVisible())
        {

            // Note: 3 colors are used here to demonstrate steps
            // erase the old one
            splashGraphics.setPaint(Color.LIGHT_GRAY);
            splashGraphics.fill(splashProgressArea);

            // draw an outline
            splashGraphics.setPaint(Color.BLUE);
            splashGraphics.draw(splashProgressArea);

            // Calculate the width corresponding to the correct percentage
            int x = (int) splashProgressArea.getMinX();
            int y = (int) splashProgressArea.getMinY();
            int wid = (int) splashProgressArea.getWidth();
            int hgt = (int) splashProgressArea.getHeight();

            int doneWidth = Math.round(pct*wid/100.f);
            doneWidth = Math.max(0, Math.min(doneWidth, wid-1));  // limit 0-width

            // fill the done part one pixel smaller than the outline
            splashGraphics.setPaint(Color.GREEN);
            splashGraphics.fillRect(x, y+1, doneWidth, hgt-1);

            // make sure it's displayed
            mySplash.update();
        }
    }
       
       
     //---
        
        
         private static void appInit()
    {
        String task[]={"Loading core","Reading Files","Loading cache","Initializing IDE","Done"};
        for(int i=0;i<5;i++)
        {
            int pctDone = i * 20;
            splashText(task[i]);
            splashProgress(pctDone);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                // ignore it
            }
        }
    }
       
     
     
     
	public static void main(String[] args) throws IOException 
        {
            splashInit();           // initialize splash overlay drawing parameters
            appInit();              // simulate what an application would do 
                                // before starting
         if (mySplash != null)   // check if we really had a spash screen
            mySplash.close();   // if so we're now done with it
            
            
           looknfeel();   
           TabFrame tb= new TabFrame();
            
            tabbedPane.addTab("GettingStarted",new JImagePanel());
            tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
            
            
            
        }

}
