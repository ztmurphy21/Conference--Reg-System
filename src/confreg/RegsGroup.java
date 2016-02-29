
package conferenceregistrationsystem;

import java.awt.*;
import javax.swing.*;



public class RegsGroup extends JPanel{
// vars
  public final double KEYNOTE = 30.00;
  private JRadioButton generalReg;
  private JRadioButton studentReg;
  public final double GENERAL = 895.00;
  private ButtonGroup b;
  private JCheckBox dinnerKeynote;
  public final double STUDENT = 495.00;




 /**
  * constructor for reg group panel
  */
  public RegsGroup(){
    setLayout(new GridLayout(2, 1));

    generalReg = new JRadioButton("General Registration:");
    studentReg = new JRadioButton("Student Registration(High School or College):");
    dinnerKeynote = new JCheckBox("To Go To Keynote Dinner");
    
    b = new ButtonGroup();
    b.add(generalReg);
    b.add(studentReg);

    setBorder(BorderFactory.createTitledBorder("Registration Options:"));

    JPanel paneA = new JPanel();
    paneA.add(generalReg);
    paneA.add(studentReg);
    
    JPanel paneB = new JPanel();
    paneB.add(dinnerKeynote);
    
    add(paneB);
    add(paneA);
  }


/**
 * some calculations
 * @return 
 */
  public double getRegCost() {
    double registration = 0;
    double keynoteDinner = 0;
    
    double regTotal ;
    if (generalReg.isSelected()) {
      registration = GENERAL;
    } else {
      registration = STUDENT;
    }

    if (dinnerKeynote.isSelected()) {
      keynoteDinner = KEYNOTE;
    }

    regTotal = registration + keynoteDinner;
    return regTotal;
  }
}

