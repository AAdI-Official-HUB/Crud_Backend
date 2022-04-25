
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
//import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class addActor
 */

@WebServlet("/addActor")
public class addActor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addActor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
try {
	        HashMap<Object, Object> Response = new HashMap<Object,Object>();
	        
//	        String  business_code  = request.getParameter("business_code");
//			Long  cust_number = Long.parseLong(request.getParameter("cust_number"));
//			String clear_date   = request.getParameter("clear_date");
//			int  buisness_year  = Integer.parseInt(request.getParameter("buisness_year"));
//			String  doc_id  = request.getParameter("doc_id");
//			String  posting_date  = request.getParameter("posting_date");
//			String   document_create_date = request.getParameter("document_create_date");
//			String  due_in_date  = request.getParameter("due_in_date");
//			String  invoice_currency  = request.getParameter("invoice_currency");
//			String  document_type  = request.getParameter("document_type");
//			int  posting_id  = Integer.parseInt(request.getParameter("posting_id"));
//			double  total_open_amount  =Double.parseDouble("total_open_amount");
//			String  baseline_create_date  = request.getParameter("baseline_create_date");
//			String  cust_payment_terms  = request.getParameter("cust_payment_terms");
//			int   invoice_id  = Integer.parseInt(request.getParameter("invoice_id"));
	        
	        
	        String  business_code  = request.getParameter("business_code");
			String  cust_number = request.getParameter("cust_number");
			String clear_date   = request.getParameter("clear_date");
			String  buisness_year  = request.getParameter("buisness_year");
			String  doc_id  = request.getParameter("doc_id");
			String  posting_date  = request.getParameter("posting_date");
			String   document_create_date = request.getParameter("document_create_date");
			String  due_in_date  = request.getParameter("due_in_date");
			String  invoice_currency  = request.getParameter("invoice_currency");
			String  document_type  = request.getParameter("document_type");
			String  posting_id  = request.getParameter("posting_id");
			String  total_open_amount  = request.getParameter("total_open_amount");
			String  baseline_create_date  = request.getParameter("baseline_create_date");
			String  cust_payment_terms  = request.getParameter("cust_payment_terms");
			String  invoice_id  = request.getParameter("invoice_id");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose","root","Aaditya$Goal");
		String sql = "INSERT INTO grey_goose.winter_internship (business_code,cust_number,clear_date,buisness_year, doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type, posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	//		String sql = "INSERT INTO winter_internship (business_code,cust_number) VALUES (?,?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
//			ps.setString(1,business_code);
//			ps.setLong(2,cust_number);
//			ps.setString(3,clear_date);
//			ps.setInt(4,buisness_year);
//			ps.setString(5,doc_id);
//			ps.setString(6,posting_date);
//			ps.setString(7,document_create_date);
//			ps.setString(8,due_in_date);
//			ps.setString(9,invoice_currency);
//			ps.setString(10,document_type);
//			ps.setInt(11,posting_id);
//			ps.setDouble(12,total_open_amount);
//			ps.setString(13,baseline_create_date);
//			ps.setString(14,cust_payment_terms);
//			ps.setInt(15,invoice_id);			
			
			
			ps.setString(1,business_code);
			ps.setString(2,cust_number);
			ps.setString(3,clear_date);
			ps.setString(4,buisness_year);
			ps.setString(5,doc_id);
			ps.setString(6,posting_date);
			ps.setString(7,document_create_date);
			ps.setString(8,due_in_date);
			ps.setString(9,invoice_currency);
			ps.setString(10,document_type);
			ps.setString(11,posting_id);
			ps.setString(12,total_open_amount);
			ps.setString(13,baseline_create_date);
			ps.setString(14,cust_payment_terms);
			ps.setString(15,invoice_id);
			if(ps.executeUpdate() > 0) {
				Response.put("insert", true);
				
			} else {
				Response.put("insert", true);
			}
			Gson gson = new Gson();
			String JSONresponse = gson.toJson(Response);
		response.setHeader("Access-Control-Allow-Origin", "*");
			
//			 response.addHeader("Access-Control-Allow-Origin", "*");
//			    response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
//			    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
//			    response.addHeader("Access-Control-Max-Age", "1728000");
			response.getWriter().append(JSONresponse);
			

			
			
		} catch (Exception e) {
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
