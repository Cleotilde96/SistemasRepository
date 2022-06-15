package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import backend.data.notransactional.LoginUsersImplement;
import backend.dto.LoginUsers;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user="" , password="" ,pagina = "";
		HttpSession ses = request.getSession();
		user = (""+(request.getParameter("usuario"))).equals("null")?"es null":""+request.getParameter("usuario");
		password = (""+(request.getParameter("contrasenia"))).equals("null")?"es null":""+request.getParameter("contrasenia");
		LoginUsersImplement loginUserImplement=new  LoginUsersImplement();
		LoginUsers users= new LoginUsers();
		
		
		
		
		
		try {
			users = loginUserImplement.userAuthentication(user, password);
			
			if(users !=null){
				
			
				
				if(users.getIdTipoAccesoSistema() == 4 && users.getBloqueo().length()==0){
					pagina ="index.jsp";
					ses.setAttribute("name", users.getNombre());
					ses.setAttribute("user", user);
					
				}
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		
		getServletContext().getRequestDispatcher("/"+pagina).forward(request, response);	
		
	
		
			
	}

}
