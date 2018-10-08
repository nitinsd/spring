package he.cscie57.spring5.autowireByName.domain.model;

public class Category {
	Long id; 
	String name; 
	Book book; 

	public Book getBook() {
		return book;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
