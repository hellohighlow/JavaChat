public class SetHandleCommand extends NetworkListenerAdapter{
   private final String COMMAND = "SETHANDLE";

   //message should be SETHANDLE Highlow Bee
   public void process(String message, IClient client, IServer server) {
      if(isCommand(message, COMMAND)){
         server.broadcast(message);
      }
   }
}
