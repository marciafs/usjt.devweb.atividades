package model;

import java.io.File;
import java.io.Serializable;

import criptografia.AES;
import criptografia.CryptoAES;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String RES = "C:\\Users\\Alunos\\eclipse-workspace\\AULA11\\res\\";

	private String username;
	private String password;	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCripto() {
		try {
			//AES caes = new AES();
			//AES.encrypt(password,"1234");
			return AES.encrypt(password,"minhaSenhaSecreta");
		} catch (Exception e) {
			System.out.print(e.getStackTrace());
			return "Erro";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password
				+ "]";
	}
}
