public class RemoveCommand extends NetworkListenerAdapter{
   private final String COMMAND = "REMOVE";

   public void process(String message, IClient client, IServer server) {
      if(isCommand(message, COMMAND)){
         server.broadcast(message);
      }
   }
}
