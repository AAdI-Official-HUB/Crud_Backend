
import java.util.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			HashMap<Object,Object>Response = new HashMap<Object,Object>();
			String sl=request.getParameter("sl_no");
			int slno=Integer.parseInt(sl);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String query = "DELETE FROM winter_internship WHERE sl_no= ?";
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose","root","Aaditya$Goal");

			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, slno);
			if(ps.executeUpdate()>0) {
				Response.put("status", true);
			}
			else {
				Response.put("status", false);
			}
			Gson gson = new Gson();
			String ResponseJSON = gson.toJson(Response);
			try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.getWriter().append(ResponseJSON);
			System.out.println(ResponseJSON);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("exception occur");
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
