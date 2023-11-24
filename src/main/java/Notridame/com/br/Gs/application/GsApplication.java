package Notridame.com.br.Gs.application;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

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
		server.createContext("/hello", new MyHandler());
		server.setExecutor(null);
		server.start();

		System.out.println("Server started on port " + port);
	}

	static class MyHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			String response = "Hello, this is the response!";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}
}



