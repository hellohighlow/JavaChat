import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

   private JTextArea userList;
   private JTextArea display;
   private JScrollPane scrollPane;
   private JScrollBar scrollBar;
   private IServer server;

   public GUI(IServer server){
      this.server = server;

      setLayout(new BorderLayout());

      //Main display for chat
      display = new JTextArea();
      display.setEditable(false);
      display.setFont(new Font("TimesRoman", Font.PLAIN, 18));

      //Scroll Pane for display
      scrollPane = new JScrollPane(display);
      scrollBar = scrollPane.getVerticalScrollBar();
      scrollBar.setValue(scrollBar.getMaximum());
      add(scrollPane, BorderLayout.CENTER);

      //Default window values
      this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      this.setSize(750 ,900);
      this.setVisible(true);
   }
   public void append(String str){
      display.append(str + "\r\n");
      revalidate();
   }
}
