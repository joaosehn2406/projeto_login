package code.model.entity.User;


import code.model.enums.TipoUsuario;
import java.util.Date;

public interface Serializavel {
    Date getDt_criacao();
    String getNome();
    String getEmail();
    TipoUsuario getTipoUsuario();
    String getUsuario();
    String getSenha();
    

    default String toCSV() {
        return getUsuario() + "," +
               getSenha() + "," +
               getNome() + "," +
               getEmail() + "," +
               getTipoUsuario() + "," +
               (getDt_criacao() != null ? UsuarioPadrao.sdf.format(getDt_criacao()) : ""); 
    }
}
