public class ListCommand extends NetworkListenerAdapter{
   private final String COMMAND = "LIST";

   //Sends LIST 7 Highlow3 Bee6 HI nerd
   public void process(String message, IClient client, IServer server) {
      if(isCommand(message, COMMAND)){
         String mess = "LIST ";
         IClient [] clients = server.getClients();
         for(int i = 0; i < clients.length; i ++) {
            String serverSideClient = ((ServerSideClient) clients[i]).getHandle();
            mess += serverSideClient.length() + " "  + serverSideClient;
         }
         server.broadcast(mess);
      }
   }
}
