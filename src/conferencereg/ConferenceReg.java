/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencereg;
import java.awt.*; 
import javax.swing.*;
import java.text.DecimalFormat;
import java.awt.event.*;
import javax.swing.JOptionPane;
/**
 *
 * @author zacha
 */
public class ConferenceReg  extends JFrame{
    // make radio buttons variables declated
    private JRadioButton generalReg;
    private JRadioButton studentReg ;
    private JCheckBox dinnerKeynote ;
    private JList workshop ;//to make it show on gui
    private JList workshopGet ; //to get info
    private JButton calculate; 
    private JLabel directions;
    
    
    //list of what the user would selecte from the workbook pane 

    double total = 0;
    double keynote = 0;
    double work = 0;
    double regs = 0;

    
    public ConferenceReg(){
        setTitle("Conference Registration System");


    setSize(500,500);
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        buildPanel();
    
    
    }
private void buildPanel(){
    JPanel mainPanel = new JPanel();
    directions = new JLabel ("Enter registration info. ");


    JRadioButton generalReg = new JRadioButton("General Registration");
     JRadioButton studentReg = new JRadioButton("Student Registration");
     JCheckBox dinnerKeynote = new JCheckBox("Dinner and Keynote fee");
              String [] workshopPos = {"Introduction to E-commerce", "The Future of the Web", "Advanced Java Programming", "Network Security"};
              //double [] workshopCostv= {295, 295, 395, 395};

     JList workshop = new JList (workshopPos);//to make it show on gui
    JList workshopGet = new JList(); //to get info

    generalReg.addActionListener(new Radio() );
    studentReg.addActionListener(new Radio());
    mainPanel.add(generalReg);
    mainPanel.add(studentReg);
    mainPanel.add(dinnerKeynote);
    JButton calculate = new JButton("Calculate");
    mainPanel.add(calculate);
    mainPanel.add(workshop);
    mainPanel.add(workshopGet);
    calculate.addActionListener(new CalcListener());
    
    
   
    
    //use parallel array to hold prices on strings LOOK ZACH LOOK DO NOT DO ANYTHING LOOK HERE
    add(mainPanel);
    
        
    }

private class Radio implements ActionListener{
        
    

        @Override
        public void actionPerformed(ActionEvent e) {
            regs = 0;
            if(e.getSource()==generalReg){
                regs += 895.00;
            }else{
                regs += 495.00;
            }
        }
    }

private class ListSelectionListener implements ListSelectionListener{
  
    public void values (ListSelectionEvent e){
        int [] select = workshopGetJlist.getSelectedIndices();
        
        work = 0;
        for (int i = 0; i< select.length; i++){
            if(select[i] == 0 || select[i] ==1){
                work += 295.00;
            }else if (select[i] == 2 || select [i] ==3){
                work +=395.00;
            }else{
                work += 0;
            }
        }
    }
}

private class CheckListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == dinnerKeynote){
                if (dinnerKeynote.isSelected()){
                    keynote += 30.00;
                }else{
                    keynote = 0;
                }
            }
        }
    
}
private class CalcListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            total = regs + keynote + work;
        JOptionPane.showMessageDialog("Total" + total);        }
    
}

    
    
   
    public static void main(String[] args) {
        new ConferenceReg();

    }
    
}
