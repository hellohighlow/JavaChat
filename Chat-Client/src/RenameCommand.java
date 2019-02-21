public class RenameCommand extends NetworkListenerAdapter{

   private final String COMMAND = "RENAME";

   public void process(String message, IClient client) {
      //message should be RENAME 7 Highlow13 HelloHighlow
      if(isCommand(message, COMMAND)){
         String[] s = message.split(" ", 3);
         int start = Integer.parseInt(s[1]);
         client.append("ADMIN: " + s[2].substring(0, start) + " has changed their handle to ");
         String s1 = s[2].substring(start);
         s = s1.split(" ", 2);
         client.append(s + "!\r\n");

      }
   }
}
