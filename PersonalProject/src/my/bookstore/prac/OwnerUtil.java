package my.bookstore.prac;

import bookstore.Books;

public class OwnerUtil implements OwnerUtilDesign{
	
	String sql;
	
	@Override
	public void bookAdd(Books book) {
		sql = "insert into booklist values (?,?,?,?,?)";
		
	}

	@Override
	public void bookUpdate(Books book) {
		
	}

	@Override
	public void bookDelete(String ISBN) {
		
	}

}
