
package conferenceregistrationsystem;

import java.awt.*;
import javax.swing.*;



public class WorkshopGroup extends JPanel {

  private JList workshops;

  private String[] workshopsPos = {"Introduction to E-Commerce",
    "The Future of the Web", "Advanced Java Programming", "Network Security"};

  double workshopsCost = 0;
/** 
 * contstructor for this panel group
 */
  public WorkshopGroup() {

    workshops = new JList(workshopsPos);

    setLayout(new FlowLayout());

   // add a border around the panel
   setBorder(BorderFactory.createTitledBorder("Workshop Options: "));
   
    JPanel paneC = new JPanel();
    paneC.add(workshops);
    add(paneC);
  }


   /** 
    * calculations 
    * @return 
    */
  public double getWorkshopCost() {
    double costofWorkShops = 0;

    int[] select = workshops.getSelectedIndices();
    for (int x = 0; x < select.length; x++) {
      if (select[x] == 0 || select[x] == 1) {
        costofWorkShops += 295.00;
      } else if (select[x] == 2 || select[x] == 3) {
        costofWorkShops += 395.00;
      } else {
        costofWorkShops += 0;
      }
    }
    return costofWorkShops;
  }
}
