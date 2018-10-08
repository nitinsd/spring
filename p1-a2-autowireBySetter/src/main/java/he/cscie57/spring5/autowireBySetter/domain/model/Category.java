package he.cscie57.spring5.autowireBySetter.domain.model;

import org.springframework.beans.factory.annotation.Autowired;

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

	// autowiring is done by type
	@Autowired
	public void setBook(Book book) {
		this.book = book;
	}
}
