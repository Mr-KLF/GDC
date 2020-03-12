package gdp.api.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
/**
 * Servlet implementation class register
 */
//@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public register() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append(loadDatabase()).append(request.getContextPath());
	    final Gson gson = new Gson();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String loadDatabase() {
	    // Chargement du driver
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	    }

	    try {
	        Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gdc?" + 
	        		"serverTimezone=UTC", "root", "efrei123");
	        Statement statement = connexion.createStatement();
	        ResultSet resultat = statement.executeQuery("SELECT s_name as name FROM user;");
	        while(resultat.next()) {
	        	return(resultat.getString("name"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return("youpi");
	    }
	    return("oups");
	}
}




