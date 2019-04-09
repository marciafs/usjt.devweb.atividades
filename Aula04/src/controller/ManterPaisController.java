package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PaisDAO;
import model.Pais;

/**
 * Servlet implementation class ManterPaisController
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Pais pais = new Pais();
		
		String nome = request.getParameter("nome");
		pais.setNome(nome);
		
		long populacao = Long.parseLong(request.getParameter("populacao"));
		pais.setPopulacao(populacao);
		
		double area = Double.parseDouble(request.getParameter("area"));
		pais.setArea(area);
		
		PaisDAO dao = new PaisDAO();
		pais.setId(dao.criar(pais));
	}

}
