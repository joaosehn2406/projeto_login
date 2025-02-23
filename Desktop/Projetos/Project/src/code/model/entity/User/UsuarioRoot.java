package code.model.entity.User;

import code.exception.PersistenciaException;
import code.model.auth.PasswordCripto;
import code.model.repository.UsuarioPadraoController;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRoot {

    public static void criarUsuarioRoot() {
        UsuarioPadrao usuario = new UsuarioPadrao();
        UsuarioPadraoController usuarioController = new UsuarioPadraoController();
        
        try {
            usuario.setUsuario("admin");
            usuario.setSenha(PasswordCripto.hashSHA256("admin123"));
            usuario.setNome("admin");
            usuario.setEmail("admin@admin.com");
            usuario.setTipoUsuario(TipoUsuario.ADMIN);
            usuario.setDt_criacao(UsuarioPadrao.sdf.parse("22/02/2025"));


            List<UsuarioPadrao> usuarios = new ArrayList<>();
            usuarios.add(usuario);


            usuarioController.save(usuarios);

        
        } catch (PersistenciaException | ParseException ex) {
            Logger.getLogger(UsuarioPadrao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
