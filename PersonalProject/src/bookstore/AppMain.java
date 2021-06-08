package bookstore;

import bookstore.search.SearchBooks;

public class AppMain {

	public static void main(String[] args) {
		Books.connect();
		for (Books b : new SearchBooks().getAllBooks()) {
			System.out.println(b);
		}
	}

}
