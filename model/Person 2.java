package application.model;

import java.io.Serializable;

public abstract class Person implements Serializable {
	protected String name;
	protected String id;
	protected int yearOfBirth;

	protected abstract String getId();
	public Person(String name, String id, int yearOfBirth) throws Exception {
		setId(id);
		setName(name);
		setYearOfbirth(yearOfBirth);
	}

	public boolean setYearOfbirth(int year) throws Exception {
		if (year >= 1900 && year < 2100) {
			this.yearOfBirth = year;
		} else
			throw new Exception("year must be between 1900-2100");
		return true;
	}

	public boolean setName(String name) throws Exception {

		this.name = name;
		return true;
	}

	public boolean setId(String id) throws Exception {
		if (id.length() == 9) {
			for (int i = 0; i < id.length(); i++) {
				if (!(id.charAt(i) >= '0' && id.charAt(i) <= '9'))
					throw new Exception(" id must be numbers only ");

			}
			this.id = id;
		} else
			throw new Exception("must be 9 numbers for id");
		return true;

	}
}
