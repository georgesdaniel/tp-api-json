package dev.biblio.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.biblio.entity.Auteur;
import dev.biblio.entity.Config;
import dev.biblio.services.CrudAuteur;
import dev.biblio.services.CrudAuteurInterface;

/**
 * Servlet implementation class Servlet
 */

@WebServlet({ "/detailauteur", "/detailauteur/*" })
public class ServletDetailAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDetailAuteur() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Config.getInstance();
		CrudAuteurInterface crudauteur = new CrudAuteur();

		int id = Integer.valueOf((request.getPathInfo().substring(1)));
		Auteur auteur = crudauteur.findById(id);
		if (auteur == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter()
			  .append("{\"Error\" : \"Auteur non connu\"}");
		} else {

			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String json = gson.toJson(auteur);
			System.out.println(json);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append(json);

		}
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
