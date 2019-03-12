public class DisconnectCommand extends NetworkListenerAdapter{
   private final String COMMAND = "DISCONNECT";

   //Send REMOVE Highlow
   //message Should be DISCONNECT Highlow
   public void process(String message, IClient client, IServer server) {
      if(isCommand(message, COMMAND)){
         String [] split = message.split(" ", 2);
         server.broadcast("REMOVE "+split[1]);
      }
   }
}
