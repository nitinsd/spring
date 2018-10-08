package he.cscie57.spring5.autowireByConstructor.domain.model;

public class Category {
	Long id; 
	String name; 
	Book book;
	
	// constructor used here for autowiring
	public Category(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
