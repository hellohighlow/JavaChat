public class SetHandleCommand extends NetworkListenerAdapter{

   private final String COMMAND = "SETHANDLE";

   public void process(String message, IClient client) {
      //message should be SETHANDLE Highlow
      if(isCommand(message, COMMAND)){
         String[] s = message.split(" ",2);
         client.append("ADMIN: Your handle is now " + s[1]);
         client.send("LIST");
      }
   }
}
