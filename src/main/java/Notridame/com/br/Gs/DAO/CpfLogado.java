package Notridame.com.br.Gs.DAO;

import org.springframework.security.core.Authentication;

public class CpfLogado {
    public static String getCpfUsuarioLogado(Authentication authentication) {
        return authentication.getName();
    }
}
