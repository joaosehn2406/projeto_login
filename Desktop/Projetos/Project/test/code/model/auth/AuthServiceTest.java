package code.model.auth;


import java.io.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class AuthServiceTest {

    private static final String TEST_FILE = "test_users.csv";


    public void setUp() throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TEST_FILE))) {
            bw.write("admin," + PasswordCripto.hashSHA256("123456"));
            bw.newLine();
            bw.write("user1," + PasswordCripto.hashSHA256("password"));
            bw.newLine();
            bw.write("guest," + PasswordCripto.hashSHA256("guestpass"));
            bw.newLine();
        }
    }


    public void tearDown() {
        new File(TEST_FILE).delete();
    }

    @Test
    public void testValidarLogin_UsuarioCorreto_SenhaCorreta() {
        assertTrue(AuthService.validarLogin("123456", "admin", TEST_FILE));
    }

    @Test
    public void testValidarLogin_UsuarioCorreto_SenhaIncorreta() {
        assertFalse(AuthService.validarLogin("senhaIncorreta", "admin", TEST_FILE));
    }

    @Test
    public void testValidarLogin_UsuarioInexistente() {
        assertFalse(AuthService.validarLogin("anypass", "notexists", TEST_FILE));
    }

    @Test
    public void testUsuarioExistente_UsuarioPresente() {
        assertTrue(AuthService.usuarioExistente("user1", TEST_FILE));
    }

    @Test
    public void testUsuarioExistente_UsuarioNaoPresente() {
        assertFalse(AuthService.usuarioExistente("notexists", TEST_FILE));
    }

    @Test
    public void testValidarSenha_SenhaCorreta() {
        assertTrue(AuthService.validarSenha(PasswordCripto.hashSHA256("guestpass"), TEST_FILE));
    }

    @Test
    public void testValidarSenha_SenhaIncorreta() {
        assertFalse(AuthService.validarSenha(PasswordCripto.hashSHA256("senha1231231"), TEST_FILE));
    }
}
