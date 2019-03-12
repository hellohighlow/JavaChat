import java.util.*;

public class SayCommand extends NetworkListenerAdapter {

   private final String COMMAND = "SAY";

   public void process(String message, IClient client) {
      //message should be SAY 7 HighlowHello
      if(isCommand(message, COMMAND)){
         String[] msg = message.split(" ", 3);
         int namLen = Integer.parseInt(msg[1]);
         client.append(msg[2].substring(0,namLen)+ ": " + msg[2].substring(namLen) + "\r\n");
      }
   }

}
