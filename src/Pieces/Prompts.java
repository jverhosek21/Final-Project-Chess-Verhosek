package Pieces;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Prompts {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public Prompts()
   {
      prepareGUI();
   }
   /*public static void main(String[] args){
      Prompts  swingControlDemo = new Prompts();      
      swingControlDemo.showDialogDemo();
   }*/
   public void prepareGUI(){
      mainFrame = new JFrame("Chess");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(1, 1));
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    
      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   public void showDialogDemo(boolean bWhite)
   {        
	  if(bWhite)
	  {
		  headerLabel.setText("Player 2 King is in Check");
	  }
	  
	  else
	  {
		  headerLabel.setText("Player 1 King is in Check");
	  }
      
      JButton okButton = new JButton("OK");        

      okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) 
          {
        	  mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
          }          
       });
      /*javaButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            int output = JOptionPane.showConfirmDialog(mainFrame
               , "Click any button"
               ,"TutorialsPoint.com"
               ,JOptionPane.YES_NO_OPTION);

            if(output == JOptionPane.YES_OPTION){
               statusLabel.setText("Yes selected.");
            } else if(output == JOptionPane.NO_OPTION){
               statusLabel.setText("No selected.");
            }
         }
      });
      cancelButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {                
            int output = JOptionPane.showConfirmDialog(mainFrame
               , "Click any button"
               ,"TutorialsPoint.com"
               ,JOptionPane.YES_NO_CANCEL_OPTION,
               JOptionPane.INFORMATION_MESSAGE);

            if(output == JOptionPane.YES_OPTION){
               statusLabel.setText("Yes selected.");
            } else if(output == JOptionPane.NO_OPTION){
               statusLabel.setText("No selected.");
            } else if(output == JOptionPane.CANCEL_OPTION){
               statusLabel.setText("Cancel selected.");
            }
         }
      });*/
      controlPanel.add(okButton);
      //controlPanel.add(javaButton);
      //controlPanel.add(cancelButton);       
      mainFrame.setVisible(true);  
   }
}