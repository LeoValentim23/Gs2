package Notridame.com.br.Gs.application;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class GsApplication {

	public static final String BASE_URI = "http://localhost:8050";

	public static void main(String[] args) throws IOException {
		startServer();
	}

	public static void startServer() throws IOException {
		int port = 8050;
		HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);


		server.createContext("/cadastro", new CadastroHandler());

		server.setExecutor(null);
		server.start();

		System.out.println("Server started on port " + port);
	}


	static class CadastroHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException {

			String response = "Cadastro request received successfully!";
			exchange.sendResponseHeaders(200, response.length());
			try (OutputStream os = exchange.getResponseBody()) {
				os.write(response.getBytes());
			}
		}
	}
}

