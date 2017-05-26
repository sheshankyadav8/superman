
//importing Scanner

import javax.swing.JFrame;

import java.util.Scanner;
import java.awt.*;   
import java.awt.event.*;   

import javax.swing.*;   

import java.awt.Dimension;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;       

 public class StackMain_V1 extends JFrame implements ActionListener   

 {   
//Variable Declaration
     private JFrame  frame=new JFrame("\" Stack \"");   

     private JButton add=new JButton("Push");   

     private JButton delete=new JButton("Pop");   

     private JButton tablebutton=new JButton("Show table");   

     private JButton exit=new JButton("Exit");   

     private JTextArea display;   

     private LinkedListStackOperations lst = new LinkedListStackOperations();

     private String s,s1 ;
     Student sDetails = new Student();//Student object Initialization
     

     DefaultTableModel model = new DefaultTableModel(); 

     JTable table = new JTable(model); 

     

     

      public StackMain_V1()   //Constructor

     {   

 //Setting frame properties

         frame.getContentPane().setLayout(null);   

         frame.setResizable(false);   

         frame.getContentPane().setBackground(Color.black);   

         frame.setSize(800,400); 

 //Setting action Listener for buttons

         add.addActionListener(this);

         delete.addActionListener(this);

         tablebutton.addActionListener(this);

         exit.addActionListener(this);

         

 //Title properties 

         JLabel title=new JLabel("Welcome In Student Stack Center");   

         title.setSize(600,50);   

         title.setFont(new Font("Lucida",Font.BOLD,24));   

         title.setForeground(Color.red);   

         title.setLocation(80,6); 

         title.setHorizontalAlignment(JLabel.CENTER);

          

 //panels properties 

          JPanel north = new JPanel();

          north.setLayout(new GridLayout(1, 3)); 



 //Buttons location on panel 

        north.setSize(100,270); 

        north.setLocation(100,300); 

        north.setSize(600,50);

        north.add(add);   

        north.add(delete);   

        north.add(tablebutton); 

        north.add(exit); 



 //Text field

         display=new JTextArea();

         display.setSize(90,230);   

         display.setLocation(350,60);   

         display.setFont(new Font("Tahoma",Font.BOLD,16));   

         display.setForeground(Color.blue); 

         display.setEditable(false);

      
//Adding everything to frame
         

         frame.getContentPane().add(title);   

         frame.getContentPane().add(north);   

         frame.getContentPane().add(display);

         frame.setVisible(true); 

         

      }

 //============= SET VALUE DISPLAY IN TEXT FIELD ==============  

       public void display()   

     {   

         display.setText(s);  

        
     }   

 //Action   Listeners for all buttons  

       public void actionPerformed(ActionEvent e)   

     {   

         Object o=e.getSource();   

         if(o==exit)   

             System.exit(0);   

         if(o==add)   

         {   

       

             String stdName= JOptionPane.showInputDialog(null,"Enter a student Name: ",JOptionPane.INFORMATION_MESSAGE); 

             String stdPhone= JOptionPane.showInputDialog(null,"Enter a student phone number: ",JOptionPane.INFORMATION_MESSAGE);
                
             

             //check if the phone number is = 10

             while(stdPhone.length() != 10)

             {

                stdPhone= JOptionPane.showInputDialog(null,"Invalid.. Enter a phone number: ",JOptionPane.INFORMATION_MESSAGE);

             }

             String stdEmail= JOptionPane.showInputDialog(null,"Enter a student Email: ", stdName+"@strose.edu");

             String stdAddress= JOptionPane.showInputDialog(null,"Enter a student Address: ",JOptionPane.INFORMATION_MESSAGE);

             String stdOther= JOptionPane.showInputDialog(null,"Other student Information: ",JOptionPane.INFORMATION_MESSAGE);

             sDetails.setName(stdName);// set attributes for object
                sDetails.setPhone(stdPhone);
                sDetails.setEmail(stdEmail);
                sDetails.setAddress(stdAddress);
                sDetails.setOther(stdOther);

                 

               if(stdName.equals(null) || stdPhone.equals(null) || stdEmail.equals(null) ||

                  stdAddress.equals(null) || stdOther.equals(null))  

                {  

                  lst.pop(); 

                  display.setText("");

                  s=lst.toString(lst.top);

                }

                  else

                  {

                
                 lst.push(sDetails);
                 
                 s=lst.toString(lst.top);

                 display();

                  }

    

         }   

         if(o==delete)   

         {   

             if(!lst.isEmpty())   

             {   

                 String string=JOptionPane.showInputDialog(null,"\t\t\tYes or No \nAre you sure you want to delete"   

                 +" ","",JOptionPane.INFORMATION_MESSAGE);   

                 if(string.equalsIgnoreCase("Yes"))   

                 {   
                       lst.pop(); 

                    JOptionPane.showMessageDialog(null,"Item Deleted",   

                     "",JOptionPane.INFORMATION_MESSAGE);   


                       display.setText("");

                       s=lst.toString(lst.top);

                       display();   

                 }   

                 else   

                     JOptionPane.showMessageDialog(null,"Item not deleted",   

                     "",JOptionPane.INFORMATION_MESSAGE);   

             }   

             else   

             {JOptionPane.showMessageDialog(null,"Stack is Empty",   

                 "",JOptionPane.ERROR_MESSAGE); 

             display.setText("");}

         } 

          if(o==tablebutton)

          {
           displayTable(lst.top);
           

          }

         

        

     } 
 

    

    

 public static void main(String[]args)   
    {   
   StackMain_V1  stack= new StackMain_V1();
 
    }
 
 public static void displayTable(Node first){
    JFrame  f=new JFrame();  


      String data[][] = new String[20][20]; //Initial size

       String column[]={"ID","STUDENT NAME","PHONE","EMAIL","ADDRESS","OTHER INFORMATION"};

           //create table with spacefied columns

      JTable jt=new JTable(data,column); 

      jt.setBounds(50,60,220,320); 

  try{    
      int row = 0;
      int id = 0; // Student ID Dynamically increase
       Node temp=first;
      while(temp!=null){
       int col=0;
            System.out.print(temp.getStudent().toString());  
           

       
        data[row][col]= "STD_"+1+id;
        
         data[row][col+1] = temp.getStudent().getName();   //insert student name

         data[row][col+2] = temp.getStudent().getPhone(); //insert student phone

         data[row][col+3] = temp.getStudent().getEmail();  //insert student email

         data[row][col+4] = temp.getStudent().getAddress() ;  //insert student Address

         data[row][col+5] = temp.getStudent().getOther() ;  //insert student Other info
      
    
      row++;

     id++;
        temp = temp.getLink();  

      

     }//end while

        }catch (NullPointerException n) {  // this is to throw null pointer exception during execution time

               

      }  
        finally{
         

      //add all student info on table

      jt=new JTable(data,column);

      JScrollPane scrollBar =new JScrollPane(jt);  

      f.add(scrollBar);  

        

      f.setSize(700,300); 

      f.setVisible(true);    

  }    

    
       
 }
 }
     
    
 