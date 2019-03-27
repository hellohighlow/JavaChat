import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{ //a simple gui for the client

   private JTextArea userList;
   private JTextArea display;
   private JScrollPane scrollPane;
   private JScrollBar scrollBar;
   private JTextArea inputField;
   private JButton button;
   private IClient client;

   public GUI(IClient client){

      this.client = client;

      setLayout(new BorderLayout());
      Container bottom = new Container();
      bottom.setLayout(new BorderLayout(5,0));
      this.add(bottom, BorderLayout.SOUTH);

      //List of Users
      userList = new JTextArea();
      userList.setEditable(false);
      userList.setText("Active Users:");
      userList.setFont(new Font("TimesRoman", Font.PLAIN, 18));
      add(userList, BorderLayout.WEST);

      //Main display for chat
      display = new JTextArea();
      display.setEditable(false);
      display.setFont(new Font("TimesRoman", Font.PLAIN, 18));

      //Scroll Pane for display
      scrollPane = new JScrollPane(display);
      scrollBar = scrollPane.getVerticalScrollBar();
      scrollBar.setValue(scrollBar.getMaximum());
      add(scrollPane, BorderLayout.CENTER);

      //Input field for client
      inputField = new JTextArea();
      inputField.setEditable(true);
      inputField.setFont(new Font("TimesRoman", Font.PLAIN, 20));
      bottom.add(inputField, BorderLayout.CENTER);

      bottom.add(new JTextArea("                          "), BorderLayout.WEST);

      //A button to take input
      button = new JButton("Send");
      button.addActionListener(new buttonHandler(this));
      button.setFont(new Font("TimesRoman", Font.PLAIN, 18));
      bottom.add(button, BorderLayout.EAST);

      //Default window values
      this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      this.setSize(750 ,900);
      this.setVisible(true);
   }
   //Updates User List
   public void addUser(String str){
      userList.append(str + "\r\n");
      revalidate();
   }
   //Updates display
   public void print(String message){
      display.append(message + "\r\n");
      revalidate();
   }
   //Pass text to main
   public void isPushed(){
      String send = inputField.getText();
      inputField.setText(null);
      client.send(send);
   }
   public void clearUsers(){
      userList.setText("Active Users:\n\n");
   }
}

class buttonHandler implements ActionListener{
   GUI gui;
   public buttonHandler(GUI gui){this.gui = gui;}
   public void actionPerformed(ActionEvent e) {
      gui.isPushed();
   }
}