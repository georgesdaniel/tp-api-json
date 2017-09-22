package dev.biblio.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.biblio.entity.Auteur;
import dev.biblio.entity.Config;
import dev.biblio.entity.Livre;
import dev.biblio.services.CrudAuteur;
import dev.biblio.services.CrudAuteurInterface;
import dev.biblio.services.CrudLivres;
import dev.biblio.services.CrudLivresInterface;

/**
 * Servlet implementation class ServletDetailLivre
 */
@WebServlet({ "/detaillivre", "/detaillivre/*" })
public class ServletDetailLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDetailLivre() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Config.getInstance();
		CrudLivresInterface crudlivre = new CrudLivres();

		int id = Integer.valueOf((request.getPathInfo().substring(1)));
		Livre livre = crudlivre.findById(id);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(livre);
		System.out.println(json);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
