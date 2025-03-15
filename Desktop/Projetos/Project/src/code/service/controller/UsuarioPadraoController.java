package code.service.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import code.exception.PersistenciaException;
import code.model.enums.TipoUsuario;
import code.model.entity.User.UsuarioPadrao;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioPadraoController {

    public final static String FILE_PATH = "C:\\Temp\\usuarios.csv";

    public void save(List<UsuarioPadrao> users) throws PersistenciaException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            for (UsuarioPadrao user : users) {
                bw.write(user.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new PersistenciaException("Erro ao salvar usuários no arquivo: " + e.getMessage());
        }
    }


    public List<UsuarioPadrao> read(String caminho) throws PersistenciaException {
        List<UsuarioPadrao> users = new ArrayList<>();

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            throw new PersistenciaException("Arquivo não encontrado: " + FILE_PATH);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                UsuarioPadrao user = new UsuarioPadrao();
                user.setUsuario(data[0]);
                user.setSenha(data[1]);
                user.setNome(data[2]);
                user.setEmail(data[3]);
                user.setTipoUsuario(TipoUsuario.valueOf(data[4]));
    
                users.add(user);
            }
        } catch (IOException e) {
            throw new PersistenciaException("Erro ao ler o arquivo: " + e.getMessage());
        }

        return users;
    }
}
