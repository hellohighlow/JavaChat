public class DisconnectCommand extends NetworkListenerAdapter{

   private final String COMMAND = "DISCONNECT";

   public void process(String message, IClient client) {
      //message should be DISCONNECT
      if(isCommand(message, COMMAND)){
         System.out.println("Debug: Process Disconnect");
         ((Client)client).append("ADMIN: Good bye!\r\n");
         client.stop();
      }
   }
   //Should be DISCONNECT
   public void send(String message, IClient client) {
      if(isCommand(message, COMMAND)) {
         System.out.println("Debug: Send Disconnect");
         ((Client) client).out.println(COMMAND + " " + client.getHandle());
      }
   }
}
