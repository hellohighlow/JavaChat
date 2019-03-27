import java.net.*;
import java.util.*;

public class Server implements IServer, Runnable{

   private ArrayList<IClient> serverSideClients;
   private boolean running;
   private GUI gui;
   private ServerSocket listener;
   private int ID;

   public IClient[] getClients() {
      IClient[] clients = new IClient[serverSideClients.size()];
      for(int i = 0; i < serverSideClients.size(); i++){
         clients[i] = serverSideClients.get(i);
      }
      return clients;
   }
   public void broadcast(String data) {
      for(int i = 0; i < serverSideClients.size(); i++)
         serverSideClients.get(i).send(data);
   }
   public void remove(IClient c) {
      ServerSideClient serverSideClient = (ServerSideClient)c;
      serverSideClients.remove(c);
      broadcast("REMOVE "+serverSideClient.getHandle());
   }
   public void run() {
      try{
         while(running){
            gui.append("Accepting Clients");
            Socket clientSocket = listener.accept();
            ServerSideClient NewClient = new ServerSideClient(nextID(), this, clientSocket, gui);
            serverSideClients.add(NewClient);
            broadcast("ADD " + NewClient.getHandle());
            Thread client = new Thread(NewClient);
            client.start();
            gui.append("Client " + NewClient.getHandle() + " connected");
         }
      }catch(Exception e ){System.out.println("Server run | ERR: " + e.getStackTrace()[1].getLineNumber());}
   }

   public void append(String str){gui.append(str);}
   public void stop() {running = false;}
   public Server(int port){
      try {
         gui = new GUI(this);
         ID = 1;
         running = true;
         serverSideClients = new ArrayList<IClient>();
         listener = new ServerSocket(port);
      }catch(Exception e){System.out.println("Server constr | ERR: " + e.getStackTrace());}

   }
   public int nextID(){
      ID = ID+1;
      return ID-1;
   }
}
