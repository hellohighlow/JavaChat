public class RemoveCommand extends NetworkListenerAdapter{
   private final String COMMAND = "REMOVE";

   public void process(String message, IClient client, IServer server) {
      if(isCommand(message, COMMAND)){
         String[] split = message.split(" ", 2);
         ((Server)server).append("Admin: " + split[1] + "has left.");
         server.broadcast(message);
      }
   }
}
