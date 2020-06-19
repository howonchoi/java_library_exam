package practice2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class BookServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket s = null;
		BufferedReader br = null;
		Socket sock = null;
		ArrayList<Book> acceptbs;
		ObjectInputStream ois;
		try {
			while(true) {
				s = new ServerSocket(7000);
				System.out.println("클라이언트 접속 대기중...");
				sock = s.accept();	
				ois = new ObjectInputStream(sock.getInputStream());				
				acceptbs = (ArrayList<Book>) ois.readObject();
				for(int i=0; i<acceptbs.size(); i++) {
					System.out.println(acceptbs.get(i).toString());
				}
				ois.close();
				sock.close();
				s.close();
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
