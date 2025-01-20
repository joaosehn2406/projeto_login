package project.code.model.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import project.code.exception.PersistenciaException;
import project.code.model.entity.Usuario;

public class UsuarioRepository {
    private String filePath;

    
    public UsuarioRepository(String filePath) {
        this.filePath = filePath;
    }


    public void save(List<Usuario> users) throws PersistenciaException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Usuario user : users) {
                bw.write(user.persistir());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new PersistenciaException("Erro ao salvar usuários no arquivo: " + e.getMessage());
        }
    }


    public List<Usuario> read() throws PersistenciaException {
        List<Usuario> users = new ArrayList<>();

        File file = new File(filePath);
        if (!file.exists()) {
            throw new PersistenciaException("Arquivo não encontrado: " + filePath);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length < 2) {
                    throw new PersistenciaException("Formato inválido no arquivo: " + line);
                }

                Usuario user = new Usuario();
                user.setUsuario(data[0]);
                user.setHashedPassword(data[1]);

                users.add(user);
            }
        } catch (IOException e) {
            throw new PersistenciaException("Erro ao ler o arquivo: " + e.getMessage());
        }

        return users;
    }
}
