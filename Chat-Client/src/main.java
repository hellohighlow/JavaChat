import java.io.IOException;

public class main {
   public static void main(String[] args) throws IOException {
      String ip = "localhost";
      int port = 5566;
      Client client = new Client(ip,port);
   }
}
