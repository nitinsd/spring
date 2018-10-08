package he.cscie57.spring5.collections.domain.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Category {
	Long id; 
	String name; 
	List<Book> booksList; 
	Set<Book> booksSet;
	Map<String,Book> booksMap;

	public Category () {
	}
	
	public Category (Long id, String name, List<Book> booksList, Set<Book> booksSet, Map<String,Book> booksMap) {
		this.id = id;
		this.name = name;
		this.booksList = booksList;
		this.booksMap = booksMap;		
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public List getBooksList() {
		return booksList;
	}

	public Set getBooksSet() {
		return booksSet;
	}

	public Map getBooksMap() {
		return booksMap;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBooksList(List booksList) {
		this.booksList = booksList;
	}

	public void setBooksSet(Set booksSet) {
		this.booksSet = booksSet;
	}

	public void setBooksMap(Map<String,Book> booksMap) {
		this.booksMap = booksMap;
	}
}
