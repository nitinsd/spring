package he.cscie57.spring5.autowireBySetter.domain.model;

public class Book {
	Long id; 
	String isbn; 
	String title; 
	Float price;
	
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
	
	public String toString() {
        String str = "Book id: " + id + ", ISBN: " + isbn + ", Title: " + title + ", Price: " + price;
        return str;
	}
}
