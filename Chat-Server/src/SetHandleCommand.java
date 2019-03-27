import com.sun.security.ntlm.Client;

public class SetHandleCommand extends NetworkListenerAdapter{
   private final String COMMAND = "SETHANDLE";

   //message should be SETHANDLE Highlow
   //broadcast RENAME 6 anon17 Highlow
   public void process(String message, IClient client, IServer server) {
      if(isCommand(message, COMMAND)){
         String[] split = message.split(" ", 2);
         for(IClient client1 : server.getClients()){
            if(client1.getHandle().equals(split[1])){
               client.send("BADHANDLE");
               return;
            }
         }
         server.broadcast("RENAME " + client.getHandle() + " " + split[1]);
         ((ServerSideClient)client).out.println("SETHANDLE " + split[1]);
         client.setHandle(split[1]);
         server.broadcast("LIST");
         ((Server)server).append("Admin: Renamed" + client.getHandle() + " to " + split[1]);
      }
   }
}
