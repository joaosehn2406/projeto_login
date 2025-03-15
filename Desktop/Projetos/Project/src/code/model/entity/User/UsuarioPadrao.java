package code.model.entity.User;


import code.exception.PersistenciaException;
import code.model.entity.User.Serializavel;
import code.model.enums.TipoUsuario;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioPadrao implements Serializavel {

    public final static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String user;
    private String senha;
    private String nome;
    private String email;
    private TipoUsuario tipoUsuario;
    private Date dt_criacao;

    @Override
    public Date getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(Date dt_criacao) {
        this.dt_criacao = dt_criacao; 
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String getUsuario() {
        return user;
    }

    public void setUsuario(String user) throws PersistenciaException {
        if (user.isEmpty()) {
            throw new PersistenciaException("User inválido.");
        }
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws PersistenciaException {
        if (senha.isEmpty()) {
            throw new PersistenciaException("Senha inválida.");
        }
        this.senha = senha;
    }

    public boolean validarColunas(String nome, String email, String senha, String usuario, TipoUsuario tp) {
        return !nome.isEmpty() &&
               !email.isEmpty() &&
               !senha.isEmpty() &&
               !usuario.isEmpty() &&
               tp != null;
    }  
}
