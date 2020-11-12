package it.sincrono.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
@Document(collection = "books")
public class Book {

	@Id
	private String isbn;

	private String title;

	private String description;

	private String language;

	private String[] tags;

	private Float price;

	private Date publishDate;

	private List<Author> authors;

	public Book() {
		authors = new LinkedList<>();
		tags = new String[0];
	}

	public Book(String isbn, String title, String description, String language, String[] tags, Float price, Date publishDate, List<Author> authors) {
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.language = language;
		this.tags = tags;
		this.price = price;
		this.publishDate = publishDate;
		this.authors = authors;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getLanguage() {
		return language;
	}

	public String[] getTags() {
		return tags;
	}

	public Float getPrice() {
		return price;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public Book setIsbn(String isbn) {
		this.isbn = isbn;
		return this;
	}

	public Book setTitle(String title) {
		this.title = title;
		return this;
	}

	public Book setDescription(String description) {
		this.description = description;
		return this;
	}

	public Book setLanguage(String language) {
		this.language = language;
		return this;
	}

	public Book setTags(String... tags) {
		this.tags = tags;
		return this;
	}

	public Book setPrice(Float price) {
		this.price = price;
		return this;
	}

	public Book setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
		return this;
	}

	public Book setAuthors(List<Author> authors) {
		this.authors = authors;
		return this;
	}

	public Book setAuthors(Author... authors) {
		this.authors = new LinkedList<>(Arrays.asList(authors));
		return this;
	}

	@Override
	public String toString() {
		return "Book{" + "isbn='" + isbn + '\'' + ", title='" + title + '\'' + ", description='" + description + '\'' + ", language='" + language + '\'' + ", tags=" + Arrays
				.toString(tags) + ", price=" + price + ", publishDate=" + publishDate + ", authors=" + Arrays.toString(
				authors.toArray()) + '}';
	}

}
