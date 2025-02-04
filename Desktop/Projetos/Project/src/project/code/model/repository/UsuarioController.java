package project.code.model.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import project.code.exception.PersistenciaException;
import project.code.model.entity.Usuario;

public class UsuarioController {


    public final static String FILE_PATH = "C:\\Temp\\usuarios.csv";

    public void save(List<Usuario> users) throws PersistenciaException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Usuario user : users) {
                bw.write(user.persistir());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new PersistenciaException("Erro ao salvar usuários no arquivo: " + e.getMessage());
        }
    }


    public List<Usuario> read(String caminho) throws PersistenciaException {
        List<Usuario> users = new ArrayList<>();

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            throw new PersistenciaException("Arquivo não encontrado: " + FILE_PATH);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                Usuario user = new Usuario();
                user.setUsuario(data[0]);
                user.setSenha(data[1]);

                users.add(user);
            }
        } catch (IOException e) {
            throw new PersistenciaException("Erro ao ler o arquivo: " + e.getMessage());
        }

        return users;
    }
}
