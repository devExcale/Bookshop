package it.sincrono.models;

import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("unused")
@Document
public class Author {

	private String name;
	private String surname;

	public Author() {
	}

	public Author(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return name + " " + surname;
	}

}
