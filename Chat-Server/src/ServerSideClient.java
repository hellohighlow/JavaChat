import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ServerSideClient implements IClient, Runnable{

   private int UID;
   private ArrayList<INetworkListener> listeners;
   private String handle;
   private IServer server;
   private boolean running;
   private BufferedReader in;
   private PrintWriter out;

   public ServerSideClient(int ID, IServer server, Socket clientSocket, GUI gui){
      UID = ID;
      listeners = new ArrayList<INetworkListener>();
      handle = "anon"+UID;
      this.server = server;
      running = true;
      try {
         in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         out = new PrintWriter(clientSocket.getOutputStream());
      }catch(Exception e){System.out.println("ERR: "+e);}

      listeners.add(new AddCommand());
      listeners.add(new BadHandleCommand());
      listeners.add(new DisconnectCommand());
      listeners.add(new ListCommand());
      listeners.add(new QuitCommand());
      listeners.add(new RemoveCommand());
      listeners.add(new RenameCommand());
      listeners.add(new SayCommand());
      listeners.add(new SetHandleCommand());
   }
   public void addNetworkListener(INetworkListener listener) {listeners.add(listener);}
   public void process(String str) {
      for(INetworkListener networkListener: listeners)
         networkListener.process(str, this, server);
   }
   public void run() {
      try {
         while (running = true) {
            process(in.readLine());
         }
      }catch(Exception e){System.out.println("ERR: " + e);}
   }
   public void send(String data) {
      out.println(data);
      out.flush();
   }
   public void stop() {
      running = false;
   }
   public String getHandle(){
      return handle;
   }
   public void setHandle(String h){
      handle = h;
   }
   public int getId(){
      return UID;
   }
}
