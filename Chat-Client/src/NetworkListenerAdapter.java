public class NetworkListenerAdapter implements INetworkListener{

   public boolean isCommand(String msg, String cmd){
      String mess[] = msg.split(" ", 2);
      if(mess[0].toUpperCase().equals(cmd))
         return true;
      return false;
   }
   public void process(String message, IClient client) {}
   public void process(String message, IClient client, IServer server) {}
   public void send(String message, IClient client) {}
}
