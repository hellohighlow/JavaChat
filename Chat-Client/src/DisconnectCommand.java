public class DisconnectCommand extends NetworkListenerAdapter{

   private final String COMMAND = "DISCONNECT";

   public void process(String message, IClient client) {
      //message should be DISCONNECT
      if(isCommand(message, COMMAND)){
         client.append("Good bye!\r\n");
         client.stop();
      }
   }
}
