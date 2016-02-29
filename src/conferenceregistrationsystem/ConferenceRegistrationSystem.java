
package conferenceregistrationsystem;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


  public class ConferenceRegistrationSystem extends JFrame {
      //variables 
  private JPanel buttonPanel;
  private JButton exitButton;
  private JButton calcButton;
  private RegsGroup regGroup;
  private welcome banner;
  private WorkshopGroup wkspGroup;
  double total = 0;

  /**
   * constructor for main part of this gui
   */
  public ConferenceRegistrationSystem() {

    setTitle("Conference Registration System");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLayout(new BorderLayout());

    buildPanel();

    pack();
    setVisible(true);
  }

/**
 * making panel to hold groups of options to reg
 */
  private void buildPanel() {
// vars
    banner = new welcome();
    regGroup = new RegsGroup();
    wkspGroup = new WorkshopGroup();

    buildButtons();
//locations for compas
    add(banner, BorderLayout.NORTH);
    add(regGroup, BorderLayout.WEST);
    add(wkspGroup, BorderLayout.EAST);
    add(buttonPanel, BorderLayout.SOUTH);

  }



  /**
   * this calculates the whole total
   */
  private class CalcButtonListener implements ActionListener {

  
    @Override
    public void actionPerformed(ActionEvent e) {
      total = regGroup.getRegCost() + wkspGroup.getWorkshopCost();
      JOptionPane.showMessageDialog(null,"Total Cost: " + total);

    }
  }

/**
 * when user exits program
 */
  private class ExitButtonListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
      System.exit(0);
    }
  }
  /**
   * making the buttons with their names
   */
    private void buildButtons() {
    buttonPanel = new JPanel();

    calcButton = new JButton("Calculate ");
    exitButton = new JButton("End");

    calcButton.addActionListener(new CalcButtonListener());
    exitButton.addActionListener(new ExitButtonListener());

    buttonPanel.add(calcButton);
    buttonPanel.add(exitButton);
  }

 // main program method class
  public static void main(String[] args) {
    new ConferenceRegistrationSystem();
  }

}