package project.code.model.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import project.code.exception.PersistenciaException;

public class Usuario {

    private String user;
    private String hashedPassword;

    public String getUsuario() {
        return user;
    }

    public void setUsuario(String user) throws PersistenciaException {
        if (user.isEmpty()) {
            throw new PersistenciaException("User invalido.");
        }
        this.user = user;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public static String hashSHA256(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash SHA-256", e);
        }
    }

    public static boolean infoValidation(String password, String user, String path) {
        String pass = hashSHA256(password); 


        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dados = line.split(",");
                String usuarioArmazenado = dados[0];
                String hashArmazenado = dados[1];

                System.out.println("Usuário armazenado: " + usuarioArmazenado);
                System.out.println("Hash armazenado: " + hashArmazenado);

                if (usuarioArmazenado.equals(user) && hashArmazenado.equals(pass)) {
                    System.out.println("Usuário e senha corretos!");
                    return true;
                }
            }
            System.out.println("Usuário ou senha incorretos!");
        } catch (IOException e) {
            System.err.println("Erro ao acessar o arquivo de usuários: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public String persistir() {
        return getUsuario() + "," + getHashedPassword();
    }
}
