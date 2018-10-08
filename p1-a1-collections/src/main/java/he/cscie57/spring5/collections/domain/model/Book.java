package he.cscie57.spring5.collections.domain.model;

public class Book {
	Long id; 
	String isbn; 
	String title; 
	Float price;
	
	public Book () {
		
	}
	
	public Book (Long id, String isbn, String title, Float price) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}
	
	// getters for all the properties
	public Long getId() {
		return this.id;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public Float getPrice() {
		return this.price;
	}
	
	// setters for all the properties
	public void setId(Long id) {
		this.id =id;
	}

	public void setIsbn(String isbn) {
		this.isbn =isbn;
	}
	public void setTitle(String title) {
		this.title =title;
	}
	public void setPrice(Float price) {
		this.price =price;
	}
	
	// toString to easily print details of a book
	public String toString() {
        String str = "Book id: " + id + ", ISBN: " + isbn + ", Title: " + title + ", Price: " + price;
        return str;
	}
}
