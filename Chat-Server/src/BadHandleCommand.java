public class BadHandleCommand extends NetworkListenerAdapter{
   private final String COMMAND = "BADHANDLE";

   //Does Nothing
   public void process(String message, IClient client, IServer server) {
      if(isCommand(message, COMMAND)){
         client.send("BADHANDLE");
      }
   }
}
