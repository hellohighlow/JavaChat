import java.util.ArrayList;

public class ListCommand extends NetworkListenerAdapter {

   private final String COMMAND = "LIST";
   private ArrayList<String> users;

   public void process(String message, IClient client) {
      //message should be LIST Highlow Bee Hazel
      if(isCommand(message, COMMAND)){
         System.out.println("DEBUG: Process List");
         ((Client)client).append(message);
      }
   }
   public void send(String message, IClient client) {
      if(isCommand(message,COMMAND)){
         System.out.println("Debug: Send List");
         ((Client)client).out.println(message);
      }
   }
}
