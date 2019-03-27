public class RemoveCommand extends NetworkListenerAdapter{

   private final String COMMAND = "REMOVE";

   public void process(String message, IClient client) {
      //message should be REMOVE Highlow
      if(isCommand(message, COMMAND)){
         System.out.println("Debug: Process Remove");
         String[] strings = message.split(" ", 2);
         ((Client)client).append("ADMIN: " + strings[1] + " has left!\r\n");
         client.send("LIST");
      }
   }
}
