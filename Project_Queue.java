import java.awt.*;   
import java.awt.event.*;   
import javax.swing.*;   
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.LinkedList;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;   

public class Project_Queue extends JFrame implements ActionListener   
{   
    private JFrame  frame=new JFrame("\" Queue \"");   
    private JButton add=new JButton("Add");   
    private JButton delete=new JButton("Delete");   
    private JButton tablebutton=new JButton("Show table");   
    private JButton exit=new JButton("Exit");   
    private JTextField display;   
    private p_MyQueue_v1 lst = new p_ListQueue_v1();
    private String s,s1 ;
    
    DefaultTableModel model = new DefaultTableModel(); 
    JTable table = new JTable(model); 
    LinkedList<String> linkedlist = new LinkedList<String>();
    
     public Project_Queue()   
    {   
//frame...
        frame.getContentPane().setLayout(null);   
        frame.setResizable(false);   
        frame.getContentPane().setBackground(Color.black);   
        frame.setSize(800,400); 
//button
        add.addActionListener(this);
        delete.addActionListener(this);
        tablebutton.addActionListener(this);
        exit.addActionListener(this);
        
//Title
        JLabel title=new JLabel("Welcome In Student Queue Center");   
        title.setSize(600,50);   
        title.setFont(new Font("Lucida",Font.BOLD,24));   
        title.setForeground(Color.red);   
        title.setLocation(80,5); 
        title.setHorizontalAlignment(JLabel.CENTER);
         
//panels   
         JPanel north = new JPanel();
         north.setLayout(new GridLayout(1, 3)); 

//Butons location   
       north.setSize(350,60); 
       north.setLocation(80,250); 
       north.setSize(600,50);
       north.add(add);   
       north.add(delete);   
       north.add(tablebutton); 
       north.add(exit); 

//Text field
        display=new JTextField();
        display.setSize(600,50);   
        display.setLocation(70,70);   
        display.setFont(new Font("Tahoma",Font.BOLD,16));   
        display.setForeground(Color.red); 
        display.setEditable(false);
     
        
        frame.getContentPane().add(title);   
        frame.getContentPane().add(north);   
        frame.getContentPane().add(display);
        frame.setVisible(true); 
        
     }
//============= SET VALUE DISPLAY IN TEXT FIELD ==============  
      public void display()   
    {   
        display.setText(s);  
        //display1.setText(s1);
     

    }   
//Action     
      public void actionPerformed(ActionEvent e)   
    {   
        Object o=e.getSource();   
        if(o==exit)   
            System.exit(0);   
        if(o==add)   
        {   
      
            String stdName= JOptionPane.showInputDialog(null,"Enter a student Name: ",JOptionPane.INFORMATION_MESSAGE); 
            String stdPhone= JOptionPane.showInputDialog(null,"Enter a student phone number: ",JOptionPane.INFORMATION_MESSAGE);
            
            //check f the phone number is = 10
            while(stdPhone.length() != 10)
            {
               stdPhone= JOptionPane.showInputDialog(null,"Invalid.. Enter a phone number: ",JOptionPane.INFORMATION_MESSAGE);
            }
            String stdEmail= JOptionPane.showInputDialog(null,"Enter a student Email: ", stdName+"@strose.edu");
            String stdAddress= JOptionPane.showInputDialog(null,"Enter a student Address: ",JOptionPane.INFORMATION_MESSAGE);
            String stdOther= JOptionPane.showInputDialog(null,"Other student Information: ",JOptionPane.INFORMATION_MESSAGE);
            
                
              if(stdName.equals(null) || stdPhone.equals(null) || stdEmail.equals(null) ||
                 stdAddress.equals(null) || stdOther.equals(null))  
               {  
                 lst.deleteName(); 
                 display.setText("");
                 s=lst.toString();
               }
                 else
                 {
                   lst.insertName(stdName); 
                   lst.insertPhone(stdPhone);
                   lst.insertEmail(stdEmail);
                   lst.insertAddress(stdAddress);
                   lst.insertOther(stdOther);
                   s=lst.toString();
                   display();
                 }
   
        }   
        if(o==delete)   
        {   
            if(!lst.isEmpty())   
            {   
                String string=JOptionPane.showInputDialog(null,"\t\t\tYes or No \nAre you sure you want to delete"   
                +" ","",JOptionPane.INFORMATION_MESSAGE);   
                if(string.equals("YES")||string.equals("Yes")||string.equals("yes"))   
                {   
                    JOptionPane.showMessageDialog(null,"Item Deleted",   
                    "",JOptionPane.INFORMATION_MESSAGE);   
                      lst.deleteName(); 
                      display.setText("");
                      s=lst.toString();
                      display();   
                }   
                else   
                    JOptionPane.showMessageDialog(null,"Item not deleted",   
                    "",JOptionPane.INFORMATION_MESSAGE);   
            }   
            else   
            {JOptionPane.showMessageDialog(null,"Queue is Empty",   
                "",JOptionPane.ERROR_MESSAGE); 
            display.setText("");}
        } 
         if(o==tablebutton)
         {
           //lst.MyTable();
           lst.displayTable();
         }
        
       
    }   
    public static void main(String[]args)   
    {   
       Project_Queue queue=new Project_Queue();   
    }   
//ends the class
     
}