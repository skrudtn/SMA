package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MainServer {
	private ArrayList<Socket> members;
	private Socket leaderSocket;
	private Socket socket;
	
	public MainServer() {
		 members = new ArrayList<Socket>();
	}
	
	public void StartServer(){
		try {
			ServerSocket serverSocket =  new ServerSocket(7777);
			
			while (true) {
                this.socket = serverSocket.accept();
                System.out.println("[" + socket.getInetAddress() + ":"
                        + socket.getPort() + "]" + "에서 접속하였습니다.");
                new ReceiveThreadInMainServer(this.socket).start();
                
			}
		} catch (IOException e) {
			System.out.println("error in Mainserver - startServer");
			e.printStackTrace();
		}
		
	}
	
	public void sendToLeader(Socket getSocket,String feedback) {
		try {
			DataOutputStream out = new DataOutputStream(getSocket.getOutputStream());
			out.writeUTF(feedback);
		} catch (IOException e) {
			System.out.println("error in send To leader");
			e.printStackTrace();
		}

	}
	
	public void sendToMembers(Socket getSocket, Object project) {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(getSocket.getOutputStream());
			objOut.writeObject(project);
		} catch (IOException e) {
			System.out.println("error in send To leader");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MainServer().StartServer();
	}
	
	class ReceiveThreadInMainServer extends Thread{
	
		private Socket rtSocket;
		private String name = "";
		
		public ReceiveThreadInMainServer(Socket socket) {
			this.rtSocket = socket;
		}
		
		private boolean loginCheck(){
			int identity = 0;
			try {
				DataInputStream in = new DataInputStream(this.rtSocket.getInputStream());
				DataOutputStream out = new DataOutputStream(this.rtSocket.getOutputStream());
				identity = in.readInt(); 
				
				switch(identity){
				case 0:
					if(leaderSocket != null){
						System.out.println("leader is already exist");
						out.writeInt(0);
						return false;
					}
					leaderSocket = this.rtSocket;
					this.name = "leader";
					out.writeInt(1);
					return true;
				case 1:
					members.add(rtSocket);
					this.name = "member";
					out.writeInt(1);
					return true;
				default:
					System.out.println("잘못된 입력입니다.");
					out.writeInt(0);
					return false;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
			
		}
		
		@Override
		public void run() {
			if(loginCheck()){
					
					try {
						while(true){
							if(this.name.equals("leader")){
									ObjectInputStream objIn = new ObjectInputStream(rtSocket.getInputStream());
									Object project = objIn.readObject();
									System.out.println("프로젝트를 멤버들한테 보냅니다.");
									System.out.println("member size : " + members.size());
									for(Socket s : members) sendToMembers(s, project);
							}
							if(this.name.equals("member")){
								DataInputStream memIn = new DataInputStream(this.rtSocket.getInputStream());
								String feedback = memIn.readUTF();
								System.out.println("피드백을 리더에게 보냅니다.");
								sendToLeader(leaderSocket, feedback);
							}
						}
					} catch (IOException e) {
							e.printStackTrace();
					} catch (ClassNotFoundException e) {
						
						e.printStackTrace();
					}finally{
						if(this.name.equals("leader")) leaderSocket = null;
						else {
							members.remove(this.rtSocket);
							System.out.println("member size : " + members.size());
						}
					}
				
			}
		}
	}
}
