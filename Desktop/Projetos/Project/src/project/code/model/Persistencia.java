package project.code.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import project.code.exception.SetsException;
import project.code.model.Usuario;

public class Persistencia {
    private final String filePath = "C:\\Temp\\user.csv";

    public void saveUusario(List<Usuario> users) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Usuario u : users) {
                bw.write(u.persistir());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> readUusario() throws SetsException {
        List<Usuario> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String user = data[0];
                String hashedPassword = data[1];

                Usuario us = new Usuario();
                us.setUsuario(user);
                us.setHashedPassword(hashedPassword);

                users.add(us);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
