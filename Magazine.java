package practice2;

public class Magazine extends Book {
	int month;
	Magazine(String isbn, String title, int price, int quantity, int month) {
		super(isbn, title, price, quantity);
		setMonth(month);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Magazine [month=" + month + ", isbn=" + isbn + ", title=" + title + ", price=" + price + ", quantity="
				+ quantity + "]";
	}

	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}

}
