public class BadHandleCommand extends NetworkListenerAdapter{

   private final String COMMAND = "BADHANDLE";

   public void process(String message, IClient client) {
      //message should be BADHANDLE
      if(isCommand(message, COMMAND)){
         client.append("Bad Handle: Something went wrong!\r\n");
      }
   }
}
