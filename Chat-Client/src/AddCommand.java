public class AddCommand extends NetworkListenerAdapter{

   private final String COMMAND = "ADD";

   public void process(String message, IClient client) {
      //message should be ADD Highlow
      if(isCommand(message, COMMAND)){
         System.out.println("Debug: Process Add");
         String[] str = message.split(" ", 2);
         ((Client)client).append("ADMIN: " + str[1] + " has entered!\r\n");
         client.send("LIST");
      }
   }

   /*public void send(String message, IClient client) {
      if(isCommand(message, COMMAND)) {
         System.out.println("Debug: Send Add");
         ((Client) client).out.println(COMMAND + " " + ((Client) client).getHandle());
      }
   }**/
}
