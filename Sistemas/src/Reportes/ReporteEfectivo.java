package Reportes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conexion.conexBDSQL;

public class ReporteEfectivo {
	public boolean reporteEfectivo(HttpServletRequest request,HttpServletResponse response,HttpSession ses){
		
		 conexBDSQL con = new conexBDSQL();
		 System.out.println("entrando al proceso");
		 
			String fecha=request.getParameter("fecha"); //2020-12-28
			String fechaE[] = fecha.split("-");
			String fechaFinal = fechaE[2]+"/"+fechaE[1]+"/"+fechaE[0]; 
		int registros=0;
		ArrayList<String[]> arraylist = new ArrayList<String[]>();
		try {
			PreparedStatement ps=null;
			ResultSet rs=null;			
	  String sql = " SELECT DISTINCT T.FechaTalon, T.NumeroControl, C.NombreCliente + ' ' + C.ApellidoPaterno + ' ' + C.ApellidoMaterno AS ClientePaga, "
	        +" CASE WHEN CC.IdClientesCredito IS NOT NULL THEN 'CON CREDITO' ELSE 'CONTADO' END AS EstatusCredito, "
	        +" T.ValorFlete,T.ValorSeguro,T.ValorDescarga,T.ValorTransbordador,T.ValorEntrega,T.ValorCarga,T.ValorRecoleccion,T.ValorDeclarado, "
	        +" T.ImporteSubTotal, T.ImporteIVA, T.ImporteRetencion,PCC.ImportePagado "
	        +" FROM Talones T "
            +" LEFT JOIN Talones_Clientes TC ON T.IdTalones = TC.IdTalones "
	        +" LEFT JOIN ClientesHistorial CH ON TC.IdClientes =CH.IdClientesHistorial "
	        +" LEFT JOIN Clientes C ON CH.IdClientes = C.IdClientes "
	        +" LEFT JOIN ClientesCredito CC ON C.IdClientes = CC.IdClientes "
	        +" LEFT JOIN Pagos_Cheques_Clientes PCC ON PCC.IdTalones=T.IdTalones "
	        +" LEFT JOIN Pagos_Clientes PC ON PC.IdPagos_Clientes=PCC.IdPagos_Clientes "
	        +" WHERE (T.IdEstatusProceso = 1 OR T.IdEstatusProceso = 14) "
	        +" AND (T.TipoDocumento = 1) "
	        +" AND (T.NumeroControl <> 0) "
	        +" AND (TC.QuienPaga = -3) "
	        +" AND (PC.IdTipoPago = 1) "
	        +" AND (PC.FechaDePago = ?) "
	        +" AND T.TipoSerie like 'B' "
	        +" ORDER BY T.FechaTalon ";
	 
			ps= con.conex().prepareStatement(sql);
			ps.setString(1, fechaFinal);
			rs = ps.executeQuery();
			try {
				while (rs.next()) {
					String [] arr= new String[16];
					
					arr[0]= rs.getString(1);
					arr[1]= rs.getString(2);
					arr[2]= rs.getString(3);
					arr[3]= rs.getString(4);
					arr[4]= rs.getString(5);
					arr[5]= rs.getString(5);
					arr[6]= rs.getString(7);
					arr[7]= rs.getString(8);
					arr[8]= rs.getString(9);
					arr[9]= rs.getString(10);
					arr[10]= rs.getString(11);
					arr[11]= rs.getString(12);
					arr[12]= rs.getString(13);
					arr[13]= rs.getString(14);
					arr[14]= rs.getString(15);
					arr[15]= rs.getString(16);
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
		
		
		//System.out.println("registtros:" +registros);
		ses.setAttribute("arrayFact", arraylist);
			return true;
		}
	//public static void main(String[] args) {
//		ConsutaUsuariosWeb user = new  ConsutaUsuariosWeb();
//		user.consultaUsuarios();
	//}
	
}
