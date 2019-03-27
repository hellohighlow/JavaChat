import java.io.IOException;
import java.util.Scanner;

public class main {
   public static void main(String[] args) throws IOException {
      System.out.println("Enter IP");
      Scanner scanner = new Scanner(System.in);
      String ip = scanner.nextLine();
      System.out.println("Enter Port");
      int port = Integer.parseInt(scanner.nextLine());
      Client client = new Client(ip,port);
      Thread clientThread = new Thread(client);
      clientThread.start();
   }
}
