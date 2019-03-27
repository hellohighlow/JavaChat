public class AddCommand extends NetworkListenerAdapter{
   private final String COMMAND = "ADD";

   //Sends ADD Highlow
   public void process(String message, IClient client, IServer server) {
      if(isCommand(message,COMMAND)){
         server.broadcast(message);
         String[] split = message.split(" ", 2);
         ((Server)server).append("Admin: " + split[1] + " has joined.");
      }
   }
}
