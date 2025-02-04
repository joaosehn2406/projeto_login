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
    private String senha;

    public String getUsuario() {
        return user;
    }

    public void setUsuario(String user) throws PersistenciaException {
        if (user.isEmpty()) {
            throw new PersistenciaException("User invalido.");
        }
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String s) {
        this.senha = s;
    }

    public String persistir() {
        return getUsuario() + "," + getSenha();
    }
}
