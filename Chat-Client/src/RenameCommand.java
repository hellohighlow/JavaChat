public class RenameCommand extends NetworkListenerAdapter{

   private final String COMMAND = "RENAME";

   public void process(String message, IClient client) {
      //message should be RENAME Highlow HelloHighlow
      if(isCommand(message, COMMAND)){
         System.out.println("DEBUG: Process Rename");
         String[] split = message.split(" ", 3);
         ((Client)client).append("Admin: " + split[1] + " is renamed to " + split[2]);
         client.send("LIST");
      }
   }
}
