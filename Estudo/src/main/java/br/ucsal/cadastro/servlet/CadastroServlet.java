package br.ucsal.cadastro.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.cadastro.CadastroBs;
import br.ucsal.cadastro.exception.CadastroException;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		try {
			CadastroBs.getInstancia().Cadastrar(nome, usuario, senha);
			response.sendRedirect("./Lista.jsp");

		} catch (CadastroException e) {
			response.getWriter().write(Fail(e.getMessage()));
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public String Fail(String e) {
		StringBuffer mensagem= new StringBuffer("<!DOCTYPE html>");
		mensagem.append("html lang=\"pt-br\">\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Cadastro</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"index.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<div class=\"centro\">\r\n"
				+ "		<h1 class=Titulo>Cadastrar-se:</h1>\r\n"
				+ "		<form method=\"get\" action=\"CadastroServlet\">\r\n"
				+ "			<h2 class=\"tituloInput\">Usuário:</h2>\r\n"
				+ "			<input class=\"input\" type=\"text\" placeholder=\"Insira usuário\"\r\n"
				+ "				name=\"usuário\"><br>\r\n"
				+ "			<h2 class=\"tituloInput\">Nome:</h2>\r\n"
				+ "			<input class=\"input\" type=\"text\" placeholder=\"Insira nome\"\r\n"
				+ "				name=\"nome\"><br>\r\n"
				+ "			<h2 class=\"tituloInput\">Senha:</h2>\r\n"
				+ "			<input class=\"input\" type=\"password\" placeholder=\"Insira senha\"\r\n"
				+ "				name=\"senha\"><br> <input id=\"botão\" type=\"submit\"\r\n"
				+ "				value=\"cadastrar\">\r\n"
				+"           <p>"+e+"alo"+"</p>\r\n"
				+ "		</form>\r\n"
				+ "	</div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		return mensagem.toString();
	}
}
