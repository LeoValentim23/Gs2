package Notridame.com.br.Gs.security;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private static final Map<String, Map<String, Object>> sessions = new HashMap<>();

    public static void createSession(HttpExchange exchange, String sessionId) {
        sessions.put(sessionId, new HashMap<>());
        exchange.getResponseHeaders().add("Set-Cookie", "sessionId=" + sessionId);
    }

    public static Map<String, Object> getSession(HttpExchange exchange) {
        Headers headers = exchange.getRequestHeaders();
        if (headers.containsKey("Cookie")) {
            String sessionId = headers.getFirst("Cookie").replace("sessionId=", "");
            return sessions.get(sessionId);
        }
        return null;
    }
}
