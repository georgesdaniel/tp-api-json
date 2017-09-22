package dev.biblio.servlet;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dev.biblio.entity.Auteur;
import dev.biblio.entity.Config;
import dev.biblio.services.CrudAuteur;
import dev.biblio.services.CrudAuteurInterface;

@WebServlet("/createauteur")
public class ServletCreateAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCreateAuteur() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		if (request.getPathInfo() == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} else {
			CrudAuteurInterface crudauteur = new CrudAuteur();
			Auteur auteur1 = new Auteur();

			auteur1.setNom(request.getParameter("nom"));
			// System.out.println("AUTEUR ======> " + request.getParameter("nom"));
			auteur1.setPrenom(request.getParameter("prenom"));
			auteur1.setLangue(request.getParameter("langue"));
			crudauteur.Sauvegarde(auteur1);

		}
	}

}
