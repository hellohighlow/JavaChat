import java.util.*;
import java.io.*;
import java.net.*;

public class Client implements IClient, Runnable {
   private ArrayList<INetworkListener> listeners; //List of INetworkListeners
   private Socket socket; //Socket to connect to
   private BufferedReader in; //Server to client input stream
   public PrintWriter out; //Client to server input stream
   private boolean running;
   private GUI gui;
   private String handle;

   public Client(String IP, int port) throws IOException{
      gui = new GUI(this);
      listeners = new ArrayList<INetworkListener>();
      socket = new Socket(IP, port);
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
      running = true;

      listeners.add(new AddCommand());
      listeners.add(new BadHandleCommand());
      listeners.add(new DisconnectCommand());
      listeners.add(new ListCommand());
      listeners.add(new RemoveCommand());
      listeners.add(new RenameCommand());
      listeners.add(new SayCommand());
      listeners.add(new SetHandleCommand());
   }
   public void run(){
      try {
         while (running) {
            process(in.readLine());
         }
      }catch(Exception e){System.out.println("Caught error: " + e + " " + e.getStackTrace()[1].getLineNumber());}
   }
   public void send(String message){
      for(INetworkListener i : listeners)
         i.send(message, this);
   }
   public void process(String str){
      for(INetworkListener i : listeners)
         i.process(str, this);
   }
   public void addNetworkListener(INetworkListener listener){
      listeners.add(listener);
   }
   public void stop(){
      running = false;
      try {
         in.close();
         out.close();
         socket.close();
      }catch(Exception e){}
   }
   public void append(String str){
      String[] strings = str.split(" ");
      if(strings[0].equals("LIST")) {
         gui.clearUsers();
         for(int i = 1; i < strings.length; i++)
            gui.addUser(strings[i]);
      }
      else
         gui.print(str);
   }
   public String getHandle(){
      return handle;
   }
   public void setHandle(String handle){this.handle = handle;}
}
