package test;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import criptografia.CryptoAES;
import model.Usuario;
import service.UsuarioService;

public class TesteUsuario {
	@Test
	public void aesPasswordTest() throws Exception {
		CryptoAES cryptoAES = new CryptoAES();
		for (int i = 0; i < 5; i++) {
			
		
		cryptoAES.geraCifra("1234".getBytes(), new File("C:\\Users\\Alunos\\eclipse-workspace\\AULA11\\res\\chave.simetrica"));
		System.out.println(cryptoAES.getTextoCifrado());
		}
		
		
//		Usuario u = new Usuario();
//		u.setPassword("1234");
//		for (int i = 0; i < 5; i++) { 
//			System.out.println(u.getPassword() + " -> " +u.getPasswordCripto());
//		}
//		Assert.assertEquals("[B@523884b2", u.getPasswordCripto());
//		Assert.assertEquals("[B@523884b2", u.getPasswordCripto());
//		Assert.assertEquals("[B@523884b2", u.getPasswordCripto());
//		Assert.assertEquals("[B@523884b2", u.getPasswordCripto());
	}
	
	
	public void usuarioServicePassTest() {
		Usuario u = new Usuario();
		u.setUsername("gustavo@g.c");
		u.setPassword("1234");
		UsuarioService service = new UsuarioService();
		Assert.assertTrue(service.validar(u));

	}
	
}
