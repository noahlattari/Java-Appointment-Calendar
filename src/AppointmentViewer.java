import javax.swing.JFrame;
//Noah Mifsud Lattari
//50076040
//CPS-209-052
//Tim Mclnerney
//April 10th 2017
/**
*/
public class AppointmentViewer
{  
	
   public static void main(String[] args)
   {  
      JFrame frame = new AppointmentFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Appointments");
      frame.setVisible(true);      
   }

}