package Notridame.com.br.Gs.application;

import Notridame.com.br.Gs.Service.LoginService;
import Notridame.com.br.Gs.Service.TriagemService;
import Notridame.com.br.Gs.Service.TriagemUtil;
import Notridame.com.br.Gs.menu.LoginController;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Notridame.com.br.Gs.Service.Historico.mostrarHistorico;
import static Notridame.com.br.Gs.Service.HistoricoMedico.mostrarHistoricoMedico;


public class GsApplication {

	public static final String BASE_URI = "http://localhost:8050";

	public static void main(String[] args) throws IOException {
		startServer();
	}

	public static void startServer() throws IOException {
		int port = 8050;
		HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

		TriagemUtil triagemUtil = new TriagemUtil();
		TriagemService triagemService = new TriagemService(triagemUtil);


		server.createContext("/cadastro", new CadastroHandler());
		server.createContext("/historico", new MostrarHistoricoHandler());
		server.createContext("/historicoMedico", new MostrarHistoricoMedicoHandler());
		server.createContext("/login", new RealizarLoginHandler());
		server.createContext("/triagem", new RealizarTriagemHandler(triagemService));


		server.setExecutor(null);
		server.start();

		System.out.println("Server started on port " + port);
	}

	static class CadastroHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			String response = "Cadastro request received successfully!";
			sendResponse(exchange, response, 200);
		}
	}

	static class MostrarHistoricoHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			List<String> historico = mostrarHistorico();
			if (historico != null) {
				String response = String.join("\n", historico);
				sendResponse(exchange, response, 200);
			} else {
				sendResponse(exchange, "Erro ao obter histórico.", 500);
			}
		}
	}

	static class MostrarHistoricoMedicoHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			List<String> historicoMedico = mostrarHistoricoMedico();
			if (historicoMedico != null) {
				String response = String.join("\n", historicoMedico);
				sendResponse(exchange, response, 200);
			} else {
				sendResponse(exchange, "Erro ao obter histórico médico.", 500);
			}
		}
	}

	static class RealizarLoginHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			String requestBody = getRequestBody(exchange);

			// Separe os parâmetros necessários do corpo da solicitação
			Map<String, String> params = parseParams(requestBody);
			String cpf = params.get("cpf");
			String senha = params.get("senha");

			// Chame o método de realizarLogin da LoginService
			String loginResult = LoginService.realizarLogin(cpf, senha);

			// Envie a resposta ao cliente
			sendResponse(exchange, loginResult, 200);
		}
		private Map<String, String> parseParams(String requestBody) {
			Map<String, String> params = new HashMap<>();
			String[] keyValuePairs = requestBody.split("&");
			for (String pair : keyValuePairs) {
				String[] entry = pair.split("=");
				params.put(entry[0], entry[1]);
			}
			return params;
		}
	}

	static class RealizarTriagemHandler implements HttpHandler {
		private final TriagemService triagemService;

		public RealizarTriagemHandler(TriagemService triagemService) {
			this.triagemService = triagemService;
		}

		@Override
		public void handle(HttpExchange exchange) throws IOException {
			String requestBody = getRequestBody(exchange);

			// Obtenha o CPF do usuário logado usando o LoginController
			String cpfUsuarioLogado = LoginController.getCpfUsuarioLogado(exchange);


			// Chame o método de realizarTriagem da TriagemService
			String triagemResult = TriagemService.realizarTriagem(null);


			// Substitua pela lógica de resposta real
			sendResponse(exchange, triagemResult, 200);
		}
	}


	private static String getRequestBody(HttpExchange exchange) throws IOException {
		InputStream is = exchange.getRequestBody();
		InputStreamReader isr = new InputStreamReader(is);
		try (BufferedReader br = new BufferedReader(isr)) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		}
	}

	private static void sendResponse(HttpExchange exchange, String response, int statusCode) throws IOException {
		exchange.sendResponseHeaders(statusCode, response.length());
		try (OutputStream os = exchange.getResponseBody()) {
			os.write(response.getBytes());
		}
	}
}




