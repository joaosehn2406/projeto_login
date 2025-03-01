package code.model.entity.User;

import code.model.enums.TipoUsuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import code.exception.PersistenciaException;
import java.text.SimpleDateFormat;
import java.util.Date;
import code.model.entity.Serializavel;

public class UsuarioPadrao implements Serializavel{

    public final static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    private String user;
    private String senha;
    private String nome;
    private String email;
    private TipoUsuario tipoUsuario;
    private Date dt_criacao;

    public Date getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(Date dt_criacao) {
        this.dt_criacao = new Date();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

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

    public void setSenha(String s) throws PersistenciaException {
        if (s.isEmpty()) {
            throw new PersistenciaException("Senha invalida.");
        }
        this.senha = s;
    }

    public boolean validarColunas(String nome, String email, String senha, String usuario, TipoUsuario tp){
        return !nome.isEmpty() && 
                !email.isEmpty() && 
                !senha.isEmpty() && 
                !usuario.isEmpty() && 
                tp != null;
    }

    @Override
    public String toCSV() {
        return getUsuario() + ","
                + getSenha() + ","
                + getNome() + ","
                + getEmail() + ","
                + getTipoUsuario() + "," 
                + (dt_criacao != null ? sdf.format(dt_criacao) : ""); 
    }
}
