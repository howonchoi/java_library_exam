package practice2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class BookMgrImpl implements IBookMgr {
	public static ArrayList<Book> bs;
	public static int idx = 0;
	
	BookMgrImpl() throws Exception{
		open();
	}
	
	
	private void open() throws Exception{
		// TODO Auto-generated method stub
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.dat"));
		bs = (ArrayList<Book>) ois.readObject();
		idx = bs.size();
		ois.close();		
	}


	@Override
	public void add(Book b) {
		// TODO Auto-generated method stub
		bs.add(b);
		idx++;
	}

	@Override
	public ArrayList<Book> search() {
		ArrayList<Book> tmp = new ArrayList<Book>();
		tmp.addAll(bs);		
		return tmp;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		// TODO Auto-generated method stub
		int num =0;
		for(int i=0; i<idx; i++) {
			if(bs.get(i).getIsbn().equals(isbn)) {		
				num++;
				int pre = bs.get(i).getQuantity();
				if(pre-quantity > 0) {
					bs.get(i).setQuantity(pre - quantity);
					return;
				}
				else {
					throw new QuantityException();
				}
			}
		}
		if(num==0) {
			throw new ISBNNotFoundException();
		}
		
	}

	@Override
	public void buy(String isbn, int quantity) throws  ISBNNotFoundException {
		// TODO Auto-generated method stub
		int num =0;
		for(int i=0; i<idx; i++) {
			if(bs.get(i).getIsbn().equals(isbn)) {
				num++;
				int pre = bs.get(i).getQuantity();
				bs.get(i).setQuantity(pre + quantity);
				return;
			}
		}		
		if(num==0) {
			throw new ISBNNotFoundException();
		}
	}

	@Override
	public int getTotalAmount() {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i=0; i<idx; i++) {
			sum += bs.get(i).getQuantity()*bs.get(i).getPrice();
		}
		return sum;
	}

	public void exit() throws Exception {
		close();
	}


	private void close() throws Exception {
		// TODO Auto-generated method stub
		FileOutputStream fos = new FileOutputStream("book2.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(bs);
		fos.close();
		oos.close();
	}


	@Override
	public void send() {
		// TODO Auto-generated method stub
		BookClient cli = new BookClient();
		cli.start();
	}
	static class BookClient extends Thread{
		public void run() {
			Socket s;

			ObjectOutputStream oos;
			try {
				s= new Socket("127.0.0.1", 7000);			
				oos = new ObjectOutputStream(s.getOutputStream());
				//°´Ã¼ º¸³»±â
				oos.writeObject(bs);
				
				oos.close();
				s.close();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}


