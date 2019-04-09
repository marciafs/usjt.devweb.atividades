package br.usjt.model;

public class ClienteMain {
	public static void main(String[] args) {
		Cliente c = new Cliente(0, "nome", "fone", "email");
		c.criar();
	}
}
