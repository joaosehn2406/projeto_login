    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.service.auth;

import code.model.enums.TipoUsuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author jpssa
 */
public class AuthService {

    public static boolean validarLogin(String password, String user, String path) {
        String pass = PasswordCriptoService.hashSHA256(password);

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dados = line.split(",");
                String usuarioArmazenado = dados[0].trim();
                String hashArmazenado = dados[1].trim();

                if (usuarioArmazenado.equals(user.trim()) && hashArmazenado.equals(pass.trim())) {
                    return true;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static boolean validarSenha(String senha, String path) {
    
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String dados[] = linha.split(",");
                
                if (dados[1].trim().equals(senha.trim())) {
                    return true;
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    


}
