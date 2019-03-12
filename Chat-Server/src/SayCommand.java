public class SayCommand extends NetworkListenerAdapter{
   private final String COMMAND = "SAY";

   //SAY 7 HighlowHello
   public void process(String message, IClient client, IServer server) {
      if(isCommand(message, COMMAND)){
         server.broadcast(message);
      }
   }
}
