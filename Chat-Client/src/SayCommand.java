import java.util.*;

public class SayCommand extends NetworkListenerAdapter {

   private final String COMMAND = "SAY";

   public void process(String message, IClient client) {
      //message should be SAY Highlow Hello
      if(isCommand(message, COMMAND)){
         System.out.println("Debug: Process Say");
         String[] msg = message.split(" ", 3);
         ((Client)client).append(msg[1] + ": " + msg[2]);
      }
   }

   public void send(String message, IClient client) {
      if(isCommand(message, COMMAND)) {
         System.out.println("Debug: Send Say");
         String[] split = message.split(" ", 2);
         ((Client) client).out.println(COMMAND + " " + client.getHandle() + " " + split[1]);
      }
   }
}
