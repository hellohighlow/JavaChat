public class SayCommand extends NetworkListenerAdapter{
   private final String COMMAND = "SAY";

   //SAY Highlow Hello
   public void process(String message, IClient client, IServer server) {
      if(isCommand(message, COMMAND)){
         server.broadcast(message);
         String[] split = message.split(" ", 3);
         ((Server)server).append(split[1] + ": " + split[2]);
      }
   }
}
