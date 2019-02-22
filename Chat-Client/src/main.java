import java.io.IOException;

public class main {
   public static void main(String[] args) throws IOException {
      String ip = "localhost";
      int port = 5566;
      GUI gui = new GUI();
      Client client = new Client(ip,port,gui);
      Thread clientThread = new Thread(client);
      clientThread.start();
   }
}
