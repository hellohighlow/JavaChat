public class RenameCommand extends NetworkListenerAdapter{
   private final String COMMAND = "RENAME";

   public void process(String message, IClient client, IServer server) {
      //message should be RENAME Highlow Bee
      if(isCommand(message, COMMAND)){
         server.broadcast(message);
      }

   }
}
