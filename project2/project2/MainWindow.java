import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/** * Purpose:Project 2 – Parking Slot System: 
 * The main window.
* @author      SHAN LU <103528518> 
* @version     JDK 1.8  
* @date        Created on 19 October 2021                 
*/
public class MainWindow implements ActionListener
{
    ArrayList<ParkingSlot> slots =new ArrayList<ParkingSlot>();//initial the array list of Parkingslot objects
    
    String psID; //initial new variables
    boolean isStaff = false;
    Car car = null;
    JFrame frame = new JFrame("Parking Slot Application Main Window");//create new frame
    JPanel panel1 = new JPanel();//create new panel
    JPanel panel2 = new JPanel();//create new panel
    JPanel panel3 = new JPanel();
    JLabel labeltest = new JLabel("Nothing");
    
    JButton addSlot = new JButton("Add A Parking Slot");//create new button
    JButton deleteSlot = new JButton("Delete A Parking Slot");//create new button
    JButton listSlot = new JButton("List A Parking Slot");//create new button
    JButton parkCar = new JButton("Park A Car");//create new button
    JButton findCar = new JButton("Find A Car");//create new button
    JButton removeCar = new JButton("Remove A Car");//create new button
    JButton exit = new JButton("Exit");//create new button
    
    JLabel label1 = new JLabel("Occupied Slots:");//create new lable
    JLabel label1color = new JLabel("Red");//create new lable to put color
    JLabel label2 = new JLabel("Empty Slots:");//create new lable
    JLabel label2color = new JLabel("Green");//create new lable to put color
    
    JTextArea display=new JTextArea();
    
    
    
    
    String registrationNumber;
    
    DefaultListModel<String> model1 = new DefaultListModel<>();
    JList<String> list1 = new JList<>(model1);
    
    DefaultListModel<String> model2 = new DefaultListModel<>();
    JList<String> list2 = new JList<>(model2);
    
    /** *
     * Design the main window
    *
    */
    public MainWindow(){
        /********************************below are panels and buttons********************************/
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set the closeoperation
        frame.setSize(670,620);//set the size
        frame.setLayout(null);//set the layout to null
        
        panel1.setBackground(Color.white);//set background color
        panel1.setBounds(10,10,640,290);//set the positon and size
        panel1.setLayout(null);//no layout
        frame.add(panel1);//put the panel into the frame
                
        JLabel heading = new JLabel("Parking Slot Application");
        heading.setBounds(145,0,380,40);//set the positon and size
        heading.setForeground(new Color(24,93,162));//set the text color
        heading.setFont(new Font("",Font.PLAIN,32));//set font
        panel1.add(heading);//put the heading label to the panel 1
        
        ImageIcon img = new ImageIcon("CarParking.jpg");
        JLabel background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,60,640,230);//set the positon and size
        panel1.add(background);
        
        
        
        label1.setBounds(100,40,120,20);//set the positon and size
        label1.setForeground(new Color(0,0,0));//set color
        label1.setFont(new Font("",Font.PLAIN,16));//set font
        panel1.add(label1);//put panel into frame
        label1.setVisible(false);//make the label invisible
        
        
        label1color.setBounds(220,40,35,20);//set the positon and size
        label1color.setBackground(Color.red);//set color
        label1color.setOpaque(true);//set the no-text lable visible
        label1color.setFont(new Font("",Font.PLAIN,16));//set font
        panel1.add(label1color);//add the label to the panel 1
        label1color.setVisible(false);//make the label invisible
        
        label2.setBounds(340,40,100,20);//set the positon and size
        label2.setForeground(new Color(0,0,0));//set color
        label2.setFont(new Font("",Font.PLAIN,16));
        panel1.add(label2);//add the label to the panel 1
        label2.setVisible(false);//make the label invisible
        
        label2color.setBounds(440,40,50,20);//set the positon and size
        label2color.setBackground(Color.green);//set color
        label2color.setOpaque(true);//set the no-text lable visible
        label2color.setFont(new Font("",Font.PLAIN,16));//set font
        panel1.add(label2color);//add the label to the panel 1
        label2color.setVisible(false);//make the label invisible
        
        panel2.setBackground(Color.white);
        panel2.setBounds(10,470,640,110);//set the positon and size
        panel2.setLayout(null);
        frame.add(panel2);//put panel into frame
        
        
        exit.setBounds(525,10,80,30);//set the positon and size
        exit.setFocusable(false);
        exit.addActionListener(this);//set action listener
        panel1.add(exit);//put the button into panel1
        
        addSlot.setBounds(10,10,200,40);//set the positon and size
        addSlot.setFocusable(false);
        addSlot.addActionListener(this);//set action listener
        
        deleteSlot.setBounds(220,10,200,40);//set the positon and size
        deleteSlot.setFocusable(false);
        deleteSlot.addActionListener(this);//set action listener
        
        listSlot.setBounds(430,10,200,40);//set the positon and size
        listSlot.setFocusable(false);
        listSlot.addActionListener(this);//set action listener
        
        parkCar.setBounds(10,60,200,40);//set the positon and size
        parkCar.setFocusable(false);
        parkCar.addActionListener(this);//set action listener
        
        removeCar.setBounds(220,60,200,40);//set the positon and size
        removeCar.setFocusable(false);
        removeCar.addActionListener(this);//set action listener
        
        findCar.setBounds(430,60,200,40);//set the positon and size
        findCar.setFocusable(false);
        findCar.addActionListener(this);//set action listener
        
        /*Put rest buttons into panel 2
        */
        panel2.add(addSlot);
        panel2.add(deleteSlot);
        panel2.add(listSlot);
        panel2.add(parkCar);
        panel2.add(removeCar);
        panel2.add(findCar);
        /**********************above are panels and buttons********************************/
        
        /***********************below is display panel********************************/
        //display.setColumns(30);
        //display.setBounds(10,310,640,150);
        //panel3.add(display);
        
        panel3.setBackground(Color.white);
        panel3.setBounds(10,310,640,150);//set the positon and size
        panel3.setLayout(null);//no layout
        frame.add(panel3);
        //labeltest.setBounds(0,0,640,75);
        //labeltest.setForeground(new Color(24,93,162));//set the text color
        
        //labeltest.setFont(new Font("",Font.PLAIN,16));
        //panel3.add(labeltest);
        list1.setBounds(0,0,320,150);
        
        list2.setBounds(320,0,320,150);
        
        panel3.add(list1);
        panel3.add(list2);
        
        /***********************above is display panel********************************/
        
        frame.setVisible(true);//set the whole frame visible
    }
    
    
    /** *
     * Event listeners method for buttons of:
     * exist, addSlot, listSlot, parkCar, removeCar, findCar
    *
    */
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==exit){
            int answer = JOptionPane.showConfirmDialog(null,"Do you wish to exist the application?","",JOptionPane.YES_NO_OPTION);
            if (answer == 0){frame.dispose();}//if ueser click yes, exist the application
            
        }
        else if(e.getSource()==addSlot){

            do{ psID = JOptionPane.showInputDialog("Please enter a slot ID (the format must match A01)");
            }while(!psID.matches("[A-Z][0-9]{2}"));
            
            if (psID != null){
                int type = JOptionPane.showConfirmDialog(null,"Is this slot a staff member slot?","",JOptionPane.YES_NO_OPTION);
                if(type == 0){isStaff = true;}else{isStaff = false;}
                
                ParkingSlot newslot = new ParkingSlot(psID, isStaff,car);
                slots.add(newslot);//add the new slot to the array
                labeltest.setText(psID);
            }
            
        }
        else if(e.getSource()==deleteSlot){
            psID = JOptionPane.showInputDialog("Please enter a slot ID you would like to delete");
            for(int i = 0; i < slots.size(); i++){
                ParkingSlot slot = slots.get(i);//define every elements in the array
                String id = slot.getId();//get the slot ID from ParkingSlot class
                if(id.equals(psID)) {
                    if(slot.isOccupied() == true) {//if the slot is occupied the slot cannot be delete
                        JOptionPane.showMessageDialog(null,"Slot cannot be deleted because is occupied");
                    }
                    else {
                        slots.remove(i);//remove the slot from array
                        JOptionPane.showMessageDialog(null,"You have successfully deleted the slot");
                    }
                }
            }
        }
        else if(e.getSource()==listSlot){
            /*************make the invisible labels defined in MainWindow() function visible*******/
            label1.setVisible(true);
            label1color.setVisible(true);
            label2.setVisible(true);
            label2color.setVisible(true);
            //System.out.println(slots.size());
            model1.removeAllElements();
            model2.removeAllElements();
            /****************************put every singel slot for ArrayList to ListModel*********************/
            for(int i = 0; i < slots.size(); i++){
                
                ParkingSlot slot = slots.get(i);
                String diplaySingelSlot = slot.toString();
                if(slot.getCar()==null){
                    
                    
                    model1.addElement(diplaySingelSlot);
                    list1.setForeground(Color.green);
                } else{
                    model2.addElement(diplaySingelSlot);
                    list2.setForeground(Color.red);
                }
            }
            //labeltest.setText(str);
        }
        else if(e.getSource()==parkCar){
            do{ registrationNumber = JOptionPane.showInputDialog("Please enter a register number (the format must match T1234)");
            }while(!registrationNumber.matches("[A-Z][0-9]{4}"));
            
            if(registrationNumber != null){
                String owner = JOptionPane.showInputDialog("Please enter the name of the owner.");
                if(owner != null){
                    int t = JOptionPane.showConfirmDialog(null,"Is the car owner a staff member?","",JOptionPane.YES_NO_OPTION);
                    Car car = new Car(registrationNumber,owner);
                    
                    if (t == 0){
                        psID = JOptionPane.showInputDialog("Please enter the slot you want to park in:");
                        for(int i = 0; i < slots.size(); i++){//the car will be park into the slot given
                            ParkingSlot ps = slots.get(i);               
                            if(ps.getId().equals(psID)){
                                if(!ps.isOccupied()){
                                    if(ps.isStaffMember()){
                                        ps.parkCar(car);
                                        JOptionPane.showMessageDialog(null,"You have successfully parked the car");
                                        
                                        break;
                                    }else{JOptionPane.showMessageDialog(null,"Staff member cannot park in the visitor slot.");}
                                }else{JOptionPane.showMessageDialog(null,"The slot is occupied."); break;}
                            }
                            
                        }
                    }else{
                        psID = JOptionPane.showInputDialog("Please enter the slot you want to park in:");
                        for(int i = 0; i < slots.size(); i++){//the car will be park into the slot given
                            ParkingSlot ps = slots.get(i);
                            if(ps.getId().equals(psID)){
                                if(!ps.isOccupied()){
                                    if(!ps.isStaffMember()){
                                        ps.parkCar(car);
                                        JOptionPane.showMessageDialog(null,"You have successfully parked the car");
                                        
                                        break;
                                    }else{JOptionPane.showMessageDialog(null,"visitor cannot park in the staff member slot.");}
                                }else{JOptionPane.showMessageDialog(null,"The slot is occupied."); break;}
                            }
                        }
                    }
                    
                    
                }
            }
            
        }
        else if(e.getSource()==removeCar){
            do {
                registrationNumber = JOptionPane.showInputDialog("Please enter the register number:");
            }while(!registrationNumber.matches("[A-Z][0-9]{4}"));
            
            for(int i =0; i < slots.size(); i++){
                ParkingSlot ps = slots.get(i);//define element in slot array
                
                Car car = ps.getCar();
                if(car!=null){
                    if (car.getRegistrationNumber().equals(registrationNumber))
                    {
                        ps.removeCar();//call remove method from ParkingSlot class
                        JOptionPane.showMessageDialog(null,"You have successfully removed the car.");
                        break;
                    }
                }
                
            }
        }
        else if(e.getSource()==findCar){
            do {
                registrationNumber = JOptionPane.showInputDialog("Please enter the register number:");
            }while(!registrationNumber.matches("[A-Z][0-9]{4}"));
            
            Car findCar = null;
            
            for(int i =0; i < slots.size(); i++){
                ParkingSlot ps = slots.get(i);//define element in slot array
                
                Car car = ps.getCar();
                if(car!=null){
                    if (car.getRegistrationNumber().equals(registrationNumber))
                    {
                        JOptionPane.showMessageDialog(null,"The car is found and details are:  " + ps.toString());
                        
                        break;
                    }
                }
                findCar = car;
            }
            
            
        }
    }
    
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
    }
    
    
}
