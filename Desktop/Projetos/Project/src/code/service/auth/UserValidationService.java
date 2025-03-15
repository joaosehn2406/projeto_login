/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.service.auth;

import code.model.enums.TipoUsuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jpssa
 */
public class UserValidationService {

    public static boolean validarTipoUsuario(String nomeUsuario, String path) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String dados[] = linha.split(",");

                String user = dados[0].trim();
                TipoUsuario tipoUsuarioArmazenado = TipoUsuario.valueOf(dados[4].trim());

                if (user.equals(nomeUsuario) && tipoUsuarioArmazenado.equals(TipoUsuario.ADMIN)) {

                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean usuarioExistente(String user, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String dados[] = linha.split(",");
                String usuarioArquivo = dados[0].trim();

                System.out.println("Lido do arquivo: " + usuarioArquivo);

                if (usuarioArquivo.equals(user.trim())) {
                    return true;
                }
                linha = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    

}
