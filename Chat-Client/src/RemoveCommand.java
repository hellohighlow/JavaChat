public class RemoveCommand extends NetworkListenerAdapter{

   private final String COMMAND = "REMOVE";

   public void process(String message, IClient client) {
      //message should be REMOVE Highlow
      if(isCommand(message, COMMAND)){
         String[] strings = message.split(" ", 2);
         client.append("ADMIN: " + strings[1] + " has left!\r\n");
         client.send("LIST");
      }
   }
}
