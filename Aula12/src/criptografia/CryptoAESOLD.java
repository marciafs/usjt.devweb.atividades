package criptografia;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptoAESOLD {
	private static final String RES = "C:\\Users\\Alunos\\eclipse-workspace\\AULA11\\res\\";
	
	private byte[] textoCifrado;
	private byte[] textoDecifrado;
	

	public CryptoAESOLD() {
		textoCifrado = null;
		textoDecifrado = null;
	}

	
	public void geraCifra(byte[] texto)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, InvalidAlgorithmParameterException,
			IOException, ClassNotFoundException {
		File fSim = new File(RES + "chave.t");		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fSim));
		SecretKey iSim = (SecretKey) ois.readObject();
		byte[] chave = iSim.getEncoded();
		ois.close();
		Cipher aescf = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec ivspec = new IvParameterSpec(new byte[16]);
		aescf.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chave, "AES"), ivspec);
		textoCifrado = aescf.doFinal(texto);
	}

	public byte[] getTextoCifrado() throws Exception {
		return textoCifrado;
	}

	public void geraDecifra(byte[] texto, File fSim)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, InvalidAlgorithmParameterException,
			IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fSim));
		SecretKeySpec iSim = (SecretKeySpec) ois.readObject();
		ois.close();
		Cipher aescf = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec ivspec = new IvParameterSpec(new byte[16]);
		aescf.init(Cipher.DECRYPT_MODE, iSim, ivspec);
		textoDecifrado = aescf.doFinal(texto);
	}

	public byte[] getTextoDecifrado() throws Exception {
		return textoDecifrado;
	}
}