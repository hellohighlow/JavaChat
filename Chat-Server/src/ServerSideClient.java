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
   public PrintWriter out;
   private Socket clientSocket;
   private GUI gui;

   public ServerSideClient(int ID, IServer server, Socket socket, GUI gui){
      UID = ID;
      this.gui = gui;
      clientSocket = socket;
      listeners = new ArrayList<INetworkListener>();
      handle = "anon"+UID;
      this.server = server;
      running = true;
      try {
         in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         out = new PrintWriter(clientSocket.getOutputStream());
         out.println("SETHANDLE " + handle);
      }catch(Exception e){System.out.println("SSC constr | ERR: "+e.getStackTrace());}

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
         while (running) {
            process(in.readLine());
         }
      }catch(Exception e){System.out.println("SSC run | ERR: " + e + " " + e.getStackTrace()[1].getLineNumber());}
   }
   public void send(String data) {
      out.println(data);
      out.flush();
   }
   public void stop() {
      running = false;
      process("DISCONNECT");
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
