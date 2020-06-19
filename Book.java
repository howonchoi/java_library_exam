package practice2;

import java.io.Serializable;

public class Book implements Serializable{
	String isbn;
	String title;
	int price;
	int quantity;
	Book(String isbn, String title, int price, int quantity){
		setIsbn(isbn);
		setTitle(title);
		setPrice(price);
		setQuantity(quantity);
		
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + ", quantity=" + quantity + "]";
	}
	public String getIsbn() {
		return this.isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
