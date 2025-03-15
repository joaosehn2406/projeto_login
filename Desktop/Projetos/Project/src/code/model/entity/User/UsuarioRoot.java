package code.model.entity.User;

import code.model.enums.TipoUsuario;
import code.exception.PersistenciaException;
import code.service.auth.PasswordCriptoService;
import code.service.controller.UsuarioPadraoController;
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
            usuario.setSenha(PasswordCriptoService.hashSHA256("admin123"));
            usuario.setNome("admin");
            usuario.setEmail("admin@admin.com");
            usuario.setTipoUsuario(TipoUsuario.ADMIN);


            List<UsuarioPadrao> usuarios = new ArrayList<>();
            usuarios.add(usuario);


            usuarioController.save(usuarios);

        
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioPadrao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
