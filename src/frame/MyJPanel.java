package frame;


import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;
import javax.swing.*;
import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

public class MyJPanel extends JPanel 
{
    int x=30,width=25;
    int y=5,height=70;
    RSyntaxTextArea txtArea;
    JTextArea outarea;
    String wholeText,findString,path,mode,cmd;
    int ind;
      final Clipboard clip= Toolkit.getDefaultToolkit().getSystemClipboard();  

   private static final long serialVersionUID = 1L;
   public MyJPanel()
   {
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       int w=screenSize.width;
       int h=screenSize.height;
       setSize(w, h);
       
             Dimension outscreen = new Dimension(1000, 110);
                outarea=new JTextArea("  OUTPUT:\n");
	       // outarea.setBounds(10, 450, 1020, 200);
                
                outarea.setEditable(false);
          JScrollPane osp = new JScrollPane(outarea);
          osp. setVerticalScrollBarPolicy( JScrollPane. VERTICAL_SCROLLBAR_ALWAYS );
                osp.setPreferredSize(outscreen);
      txtArea = new RSyntaxTextArea(20,120);
      txtArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
      
      RTextScrollPane sp = new RTextScrollPane(txtArea);
   txtArea.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
          TabFrame.count=0;
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
   add(sp);
   add(osp);
   }
   
   
   public void find()
   {
       if(TabFrame.count==1||TabFrame.flag==1)
       {
            wholeText=txtArea.getText();
            if(TabFrame.flag==1)
               findString=JOptionPane.showInputDialog(null,"Find what","Find",JOptionPane.INFORMATION_MESSAGE);
            else
               findString=TabFrame.txt_search.getText();
            
            TabFrame.flag=0;
            ind = wholeText.indexOf(findString,0);
            txtArea.setCaretPosition(ind);
            txtArea.setSelectionStart(ind);
            int a = ind+findString.length();
           
            txtArea.setSelectionEnd(a);
       }
       else
       {
            wholeText=txtArea.getText();
            findString=TabFrame.txt_search.getText();            
            ind = wholeText.indexOf(findString,txtArea.getCaretPosition());
       
            TabFrame.flag=0;
            txtArea.setCaretPosition(ind);
            txtArea.setSelectionStart(ind);
            txtArea.setSelectionEnd(ind+findString.length());
       }
   }
  
   public void copy()
   {
       String selection = txtArea.getSelectedText();
       StringSelection data = new StringSelection(selection);
       clip.setContents(data, data);
   }
   
   public void paste()
   {
       Transferable clipData = clip.getContents(clip);
       try 
       {  if(clipData.isDataFlavorSupported(DataFlavor.stringFlavor)) 
          {  String s = (String)(clipData.getTransferData(DataFlavor.stringFlavor));
             txtArea.replaceSelection(s);
          }
        } catch (Exception a){}
   }
   
   public void ReadFile(String p,String f)
   {
//       redirectSystemStreams();
       path=p;
       StringBuilder sb;
       BufferedReader d;
       try
             {  sb = new StringBuilder();
             d = new BufferedReader(new FileReader(p+f));
             String line;
             while((line=d.readLine())!=null)
             sb.append(line + "\n");
             txtArea.setText(sb.toString());
             d.close();
         }
         catch(FileNotFoundException fe)
             {
             System.out.println("File not Found");
         }
         catch(IOException ioe){}
   }
   
   
   public void SaveFile(String p,String f)
   {
      path=p;
      String s = txtArea.getText();
    try {
                //File out_file = new File(file);
                BufferedWriter out = new BufferedWriter(new FileWriter(p+f));
                out.write(s);
                out.flush();
                out.close();
            } catch(IOException e) {
               System.out.println("error error");
            }    
   
             txtArea.requestFocus();

   }
   
   
   public void CompileFile(String tabname)
   {
             redirectSystemStreams();

       outarea.setText(" OUTPUT:\n");
        try
        {mode="compile";
            runProcess("javac "+tabname);

            //            JOptionPane.showMessageDialog(this, "Ok");
        }catch(Exception e)
        {
           e.printStackTrace();
        }
   }
   
   public void RunFile(String tabname)
   {          redirectSystemStreams();
       mode="run";
       outarea.setText(" OUTPUT:\n");
        try
        {
         //  JOptionPane.showMessageDialog(this,"java -cp "+path+" "+tabname);
            
            runProcess("java -cp "+path+" "+tabname);
        }catch(Exception e)
        {
           e.printStackTrace();
        }
   }
   
   
   
   
    private void printLines(String name, InputStream ins) throws Exception {
    String line = null;
    BufferedReader in = new BufferedReader(
        new InputStreamReader(ins));
           
    while ((line = in.readLine()) != null) {
      //  outarea.append( line+"\n");
    System.out.println("\t"+line);
    }
  }

  private void runProcess(String command) throws Exception {
    
    if(mode.equals("compile"))
        cmd="javac";
    else
         cmd="java";
    Process pro = Runtime.getRuntime().exec(command);
    printLines(cmd + " stdout:", pro.getInputStream());
    printLines(cmd + " stderr:", pro.getErrorStream());
    pro.waitFor();
   System.out.println(cmd+ " exitValue() " + pro.exitValue());
    
  //      outarea.setText(" OUTPUT:\nbuild successful\ncompilation complete ");
   // else if(mode.equals("compile")&&pro.exitValue()!=0)
    //    outarea.setText("  OUTPUT:\nerror!\n"+command+ " exitValue() " + pro.exitValue());
 //   System.out.println(command + " exitValue() " + pro.exitValue());
  }
   
  
  
  private void updateTextArea(final String text) {
      this.outarea.append(text);

}
 
private void redirectSystemStreams() {
  OutputStream out = new OutputStream() {
    @Override
    public void write(int b) throws IOException {
      updateTextArea(String.valueOf((char) b));
    }
 
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
      updateTextArea(new String(b, off, len));
    }
 
    @Override
    public void write(byte[] b) throws IOException {
      write(b, 0, b.length);
    }
  };
 
  System.setOut(new PrintStream(out, true));
  System.setErr(new PrintStream(out, true));
}

   

}
