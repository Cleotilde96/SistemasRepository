package PermisosWeb.Consultas;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conexion.conexBDSQL;



public class ConsutaUsuariosWeb {
public boolean consultaUsuarios(HttpServletRequest request,HttpServletResponse response,HttpSession ses){
	
	 conexBDSQL con = new conexBDSQL();
	
	int registros=0;
	ArrayList<String[]> arraylist = new ArrayList<String[]>();
	try {
		PreparedStatement ps=null;
		ResultSet rs=null;
		
   String sql = "  SELECT ISNULL(USW.IdUsuariosSistemaWeb,0) idUsw,ISNULL(NE.IdEmpleados,0) idemp, ISNULL (NE.NombreEmpleado + ' ' + NE.ApellidoPaterno,'') NombreEmpleado ,ISNULL(USW.NombreUsuario,'') Nuser,ISNULL(USW.ContraseniaUsuario,'') PSW " 
		      + " FROM UsuariosSistemaWeb USW "
		      + " LEFT JOIN  Empleados NE  ON USW.IdEmpleados = NE.IdEmpleados " 
		      + " WHERE USW.FechaDesactiva IS NULL " 
		      + " ORDER BY NE.IdEmpleados  " ;
		
		ps= con.conex().prepareStatement(sql);
		//ps.setString(1, "");
		rs = ps.executeQuery();
		try {
			while (rs.next()) {
				String [] arr= new String[5];
				
				arr[0]= rs.getString(1);
				arr[1]= rs.getString(2);
				arr[2]= rs.getString(3);
				arr[3]= rs.getString(4);
				arr[4]= rs.getString(5);
				registros= registros +1;
				
				arraylist.add(arr);
				
			}
		} catch (Exception e) {
			System.out.println("error");
		}
		finally {
			con.conex().close();
		}		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	
	ses.setAttribute("arrayUsers", arraylist);
		return true;
	}

public boolean tbl(HttpServletRequest request,HttpServletResponse response,HttpSession ses){
	


	try {
	PrintWriter out = response.getWriter();
	/*<div class="card" style="width: 18rem;">
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Cras justo odio</li>
    <li class="list-group-item">Dapibus ac facilisis in</li>
    <li class="list-group-item">Vestibulum at eros</li>
  </ul>
</div>*/
	
	
	out.println("<div class='card' style='width: 18rem;'>");
	out.print("<ul class='list-group list-group-flush'>");
	out.print(" <li class='list-group-item'>Usuarios");
	out.print(" <li class='list-group-item'>usuaei1</li>");
	out.print("</ul>");
	out.print("</div>");
	out.print("<br>");
	out.print("<button type='button' class='btn btn-outline-success' onclick='cargaPantalla();'>Success</button>");
	out.print("<br>");
	out.print("<br>");
	out.print("<select id='opc' onchange='hola();'>");
	out.print("<option value='1' selected >valor 1</option>");
	out.print("<option value='2'  >valor 2</option>");
	
	out.println("</select>");  
	out.flush();
    out.close();
		
 
				
	} catch (Exception e) {
		// TODO: handle exception
	}

		return true;
}

public boolean MenuPermisos(HttpServletRequest request,HttpServletResponse response,HttpSession ses){
	
	return true;
}
public boolean FormarPermiso(HttpServletRequest request,HttpServletResponse response,HttpSession ses){
	String nombrePermiso = ((String) request.getParameter("nombrePermiso"));
	String rutaJsp = ((String) request.getParameter("rutaJsp"));
	String tipoPermiso = ((String) request.getParameter("tipoPermiso"));
	//String rutaJsp="'../menu/Contabilidad/ReporteRep/WindowLoad.jsp'";
	String mjsCarga="'Cargando.....'";
	String []array;
	String cadenaLiga="";
	try {
		PrintWriter out = response.getWriter();
		
		if(!nombrePermiso.equals("NULL") || !nombrePermiso.equals("rutaJsp") || !nombrePermiso.equals("tipoPermiso")  ){
			
			//["||Reporte Rep","javascript:entrando_frame('../menu/Contabilidad/ReporteRep/WindowLoad.jsp','Cargando.....',3);","", "", "", "frmSet", "", "1", "", "", "", ],  
			
			if(tipoPermiso.equals("1")){
				//[ "Administración", "", "", "", "", "", "1", "","", "", "", ],
				cadenaLiga="["+nombrePermiso+", '', '', '', '', '', '1', '','', '', '', ],";
			}
			else if(tipoPermiso.equals("2")){
				cadenaLiga="['||"+nombrePermiso+"','javascript:entrando_frame("+rutaJsp+","+mjsCarga+",3);','', '', '', 'frmSet', '', '1', '', '', '', ],";
			}
			else if(tipoPermiso.equals("3")){
				
			}
			
		
			
			out.println(cadenaLiga);
			out.flush();
		    out.close();
		}
		
	} catch (Exception e) {
		System.err.println("Error al generar la liga");
	}
	
	
	System.err.println("nombrePermiso:"+nombrePermiso);
	return true;
}


public boolean ConsultaSubmenu(HttpServletRequest request,HttpServletResponse response,HttpSession ses) throws SQLException{
	
	int  menu = Integer.parseInt( request.getParameter("menu"));
	System.err.println("valor:"+menu);
	try {
		PrintWriter out = response.getWriter();
		out.println("<select>");
		out.println(" <option value="+menu+">hola</option>");
		out.println("/<select>");
		out.flush();
	    out.close();
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	return true;
}


public boolean agregaUser(HttpServletRequest request,HttpServletResponse response,HttpSession ses) throws SQLException{
	String user = ((String) request.getParameter("usuario"));

	PreparedStatement ps=null;
	ResultSet rs=null;
	 conexBDSQL con = new conexBDSQL();
	int registros=0;
	ArrayList<String[]> arraylist = new ArrayList<String[]>();
	String sql ="";
	try {
		PrintWriter out = response.getWriter();
	
		sql = "	SELECT  ISNULL (NE.NombreEmpleado + ' ' + NE.ApellidoPaterno+' '+NE.ApellidoMaterno,'') NombreEmpleado "
		          + " FROM UsuariosSistemaWeb USW " 
		       + " LEFT JOIN  Empleados NE  ON USW.IdEmpleados = NE.IdEmpleados " 
		       + " WHERE USW.FechaDesactiva IS NULL  AND USW.IdUsuariosSistemaWeb IN("+user+")"
		       + " ORDER BY NE.IdEmpleados ";  		
		ps= con.conex().prepareStatement(sql);
		//ps.setInt(1, Integer.parseInt(user));
		rs = ps.executeQuery();
	
			while (rs.next()) {
				String [] arr= new String[1];
				arr[0]= rs.getString(1);
				
				registros= registros +1;
				
				arraylist.add(arr);
			}			
			/*
			 <div class="card" style="width: 18rem;">
  <div class="card-header">
    Featured
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Cras justo odio</li>
    <li class="list-group-item">Dapibus ac facilisis in</li>
    <li class="list-group-item">Vestibulum at eros</li>
  </ul>
</div>*/
			
	out.println("<div class='card' style='width: 18rem;''>"); 
	out.println("<div class='card-header'>USUARIOS"+" ["+registros+"]");
	out.println("</div>");

	if(arraylist.size()==0){
		out.println("<ul class='list-group list-group-flush'>");
		out.println("<li class='list-group-item'>VACIO</li>");
		out.println("</ul>");
	}else{
		for (int i = 0; i < arraylist.size(); i++) {
			String nombre[] = (String[]) arraylist.get(i);
			out.println("<ul class='list-group list-group-flush'>");
			out.println("<li class='list-group-item'>"+nombre[0]+"</li><a href='#' class='btn btn-primary'>Borrar</a>");
			out.println("</ul>");
		}
		
		
		out.flush();
	    out.close();
	}
	} catch (Exception e) {
		System.out.println("error al consultar users");
	}
	finally {
		con.conex().close();
	}	
	
		
	
	return true;
}

//public static void main(String[] args) {
//	ConsutaUsuariosWeb user = new  ConsutaUsuariosWeb();
//	user.consultaUsuarios();
//}
}
