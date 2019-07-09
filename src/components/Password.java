package components;

import java.util.Random;

public class Password {
	// Fields
	private String password;

	// Constructors
	public Password() {
		setPassword(0);
	}

	public Password(int length) {
		setPassword(length);
	}

	// Setter
	public void setPassword(int len) {
		Random r = new Random();
		password = "";
		for (int i = 0; i < len; i++) {
			char c = (char) (r.nextInt(94) + 33);
			password += c;
		}
	}

	// Display actual password
	public String getPassword() {
		return password;
	}

	// toString; public facing password (uses • characters)
	public String toString() {
		String publicPassword = "";
		for (int i = 0; i < password.length(); i++) {
			publicPassword += "•";
		}
		return publicPassword;
	}

}
