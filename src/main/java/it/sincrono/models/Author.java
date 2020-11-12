package it.sincrono.models;

import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("unused")
@Document
public class Author {

	private String name;
	private String surname;

	public Author() {
	}

	public Author(String fullname) {
		String[] split = fullname.split(" ");
		name = split[0];

		StringBuilder sb = new StringBuilder();

		for(int i = 1; i < split.length; i++)
			sb.append(split[i]);

		surname = sb.toString();
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
