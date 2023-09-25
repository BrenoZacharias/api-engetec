package br.com.fateczl.engetec.senha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
// recebe a senha, adiciona o salt na senha e faz o hash 
public class HashSenha {
	
	private static final int SALT_LENGTH = 16;
	
	//uma camada de segurança para a senha enviada pelo usuário
	public static Senha tratamentoSenha(String senha) {
		byte[] salt = new byte[16];
		salt = generateSalt();
		String hashedSenha = hashPassword(senha, salt);
		Senha objSenha = new Senha(hashedSenha, salt);
		return objSenha;
	}
	
	// Gere um salt aleatório
    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return salt;
    }
    
    // Crie um hash SHA-256 para a senha com o salt fornecido
	private static String hashPassword(String password, byte[] salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(salt);
            byte[] hashedBytes = digest.digest(password.getBytes());

            StringBuilder builder = new StringBuilder();
            for (byte b : hashedBytes) {
                builder.append(String.format("%02x", b));
            }

            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Verifique se uma senha corresponde ao hash fornecido e ao salt
    public static boolean verifyPassword(String password, String hashedPassword, byte[] salt) {
        String hashedAttempt = hashPassword(password, salt);
        return hashedAttempt.equals(hashedPassword);
    }
}
