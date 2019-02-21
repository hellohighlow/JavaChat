public class AddCommand extends NetworkListenerAdapter{

   private final String COMMAND = "ADD";

   public void process(String message, IClient client) {
      //message should be ADD Highlow
      if(isCommand(message, COMMAND)){
         String[] str = message.split(" ", 2);
         client.append("ADMIN: " + str[1] + " has entered!\r\n");
         client.send("LIST");
      }
   }
}
