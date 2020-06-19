package practice2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//book.dat �����Ͽ� Test �� dat ���� �����
		FileOutputStream fos = new FileOutputStream("book.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		ArrayList<Book> arr = new ArrayList<>();
		arr.add(new Book("ababa", "apple", 1000, 10));
		arr.add(new Magazine("bcbcb", "cat", 2000, 5, 9));
		arr.add(new Book("cdcdc", "dog", 500, 15));
		arr.add(new Magazine("deded", "rabbit", 20000, 2, 1));
		arr.add(new Book("efefe", "carrot", 1000, 100));
		oos.writeObject(arr);
		System.out.println("��ü ���� �Ϸ�");
		
		//BookTest ���� 
		BookMgrImpl man = new BookMgrImpl();
		String isbn;
		String title;
		int price;
		int quantity;
		int month;
		int count;
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. ���� �߰�\n2. ��ü ���� ���� ��� \n3. ���� �Ǹ�\n4. ���� ���� \n5.���� ����\n6. ����");
			int N = sc.nextInt();
			switch(N) {
			case 1:
				System.out.println("1. Book\n2.Magazine : ");
				int idx= sc.nextInt();
				if(idx==1) {
					System.out.println("isbn, title, price, quantity : ");
					isbn = sc.next();
					title = sc.next();
					price = sc.nextInt();
					quantity = sc.nextInt();
					man.add(new Book(isbn, title, price, quantity));
				}
				else if(idx==2) {
					System.out.println("isbn, title, price, quantity, month : ");
					isbn = sc.next();
					title = sc.next();
					price = sc.nextInt();
					quantity = sc.nextInt();
					month= sc.nextInt();
					man.add(new Magazine(isbn, title, price, quantity, month));
				}
				else {
					System.out.println("Wrong Answer..");
				}
				break;
			case 2:
				for(int i=0; i<man.search().size(); i++) {
					System.out.println(man.search().get(i).toString());
				}
				break;
			case 3:
				System.out.println("isbn, count :");
				isbn = sc.next();
				count = sc.nextInt();
				try {
					man.sell(isbn, count);
				}catch(QuantityException e) {
					e.printStackTrace();
				}catch(ISBNNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 4: 
				System.out.println("isbn, count :");
				isbn = sc.next();
				count = sc.nextInt();
				try {
					man.buy(isbn, count);
				}catch(ISBNNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				man.send();
				break;
			case 6:
				man.exit();
				return;
			}
		}
		
	}

}
