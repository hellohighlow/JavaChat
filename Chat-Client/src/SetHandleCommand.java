public class SetHandleCommand extends NetworkListenerAdapter{

   private final String COMMAND = "SETHANDLE";

   public void process(String message, IClient client){
      if(isCommand(message, COMMAND)){
         String[] split = message.split(" ", 2);
         client.setHandle(split[1]);
      }
   }

   public void send(String message, IClient client) {
      //message should be SETHANDLE Highlow
      if(isCommand(message, COMMAND)){
         System.out.println("Debug: Send Set Handle");
         String[] s = message.split(" ",2);
         ((Client)client).out.println(message);
      }
   }
}
