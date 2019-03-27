public class main{
   public static void main(String[] args){
      Server server = new Server(5566);
      Thread serverThread = new Thread(server);
      serverThread.start();
   }
}