public class NetworkListenerAdapter implements INetworkListener{
   //Client recieves
   public void process(String message, IClient client) {

   }
   //server recieves
   public void process(String message, IClient client, IServer server) {

   }
   //client sends
   public void send(String message, IClient client) {

   }
   //is command
   public boolean isCommand(String message, String command){
      String[] split = message.split(" ", 2);
      if((split[0].toUpperCase()).equals(command))
         return true;
      return false;
   }
}
