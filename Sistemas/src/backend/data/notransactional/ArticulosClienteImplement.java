package backend.data.notransactional;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import backend.dto.ArticulosClientes;
import backend.dto.Clientes;
import backend.enums.EnumArticulos;
import config.CConnection;

public class ArticulosClienteImplement implements ArticulosClienteDao {

	private Connection conection;
	
	@Override
	public List<ArticulosClientes> articulosClientes(Integer idClientes,Integer opction) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArticulosClientes articulos= null;
        List<ArticulosClientes>listArticulos= new ArrayList<>();
        try {
            conn = this.conection != null ? this.conection : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumArticulos.ARTICULOSCLIENTES.getQuery());
            stmt.setInt(1, idClientes);
            rs = stmt.executeQuery();
            
            while (rs.next()) {      
            	articulos = new ArticulosClientes();	
            	articulos.setIdClaveUnidadPeso(rs.getInt("Id_c_ClaveUnidadPeso"));
            	articulos.setClaveUnidad(rs.getString("ClaveUnidad"));
            	articulos.setDescripUnidad(rs.getString("Nombre"));
            	articulos.setIdClaveProdServCP(rs.getInt("Id_c_ClaveProdServCP"));
            	articulos.setClaveProducto(rs.getString("ClaveProducto"));
            	articulos.setDescripProducto(rs.getString("Descripcion"));
            	if(opction.equals(1)){
            		articulos.setCliente(EnumArticulos.REMITENTE.getQuery());
            	}
            	else if(opction.equals(2)){
            		articulos.setCliente(EnumArticulos.DESTINATARIO.getQuery());
            	}
            	listArticulos.add(articulos);
            	    
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conection == null) {
            	CConnection.close(conn);
            }

        }      
		return listArticulos;
	}

	@Override
	public List<ArticulosClientes> articulos() throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArticulosClientes articulos= null;
        List<ArticulosClientes>listArticulos= new ArrayList<>();
        try {
            conn = this.conection != null ? this.conection : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumArticulos.TIPOARTICULOS.getQuery());
            rs = stmt.executeQuery();
            
            while (rs.next()) {      
            	articulos = new ArticulosClientes();	
            	articulos.setIdClaveUnidadPeso(rs.getInt("Id_c_ClaveUnidadPeso")); 	
            	articulos.setDescripUnidad(rs.getString("tipoArticulo"));            	
            	listArticulos.add(articulos);
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conection == null) {
            	CConnection.close(conn);
            }

        }      
		return listArticulos;
	}

	@Override
	public ArticulosClientes claveProducto(String claveProducto) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArticulosClientes productoServ= null;
        try {
            conn = this.conection != null ? this.conection : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumArticulos.CLAVEPRODUCTO.getQuery());
            stmt.setString(1,claveProducto.trim());
            rs = stmt.executeQuery();
            
            if (rs.next()) {      
            	productoServ = new ArticulosClientes();	
            	productoServ.setIdClaveProdServCP(rs.getInt("Id_c_ClaveProdServCP")); 	
            	productoServ.setDescripProducto(rs.getString("Descripcion"));            	            	
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conection == null) {
            	CConnection.close(conn);
            }

        }      
		return productoServ;
	}

	@Override
	public Integer spiCodigosClientes(ArticulosClientes codigosClientes) throws SQLException {
		 Connection conn = null;
	     CallableStatement cstmt = null;
	     int idCodigosClientes = 0;	
	     try {
	     conn = this.conection != null ? this.conection : CConnection.getConnection();
	     cstmt = conn.prepareCall(EnumArticulos.SPICODIGOSCLIENTES.getQuery());
	     cstmt.setInt(1,codigosClientes.getIdClaveUnidadPeso());
	     cstmt.setInt(2,codigosClientes.getIdClaveProdServCP());
	     cstmt.setInt(3,codigosClientes.getIdEmpleado());
	     cstmt.registerOutParameter(4, Types.INTEGER);
	     cstmt.execute();
	     idCodigosClientes=cstmt.getInt(4);
	     
	    }
	    finally {
	    	 CConnection.close(cstmt);
	            if (this.conection == null) {
	            	CConnection.close(conn);
	            	}
	    }	
		return idCodigosClientes;
	}

	@Override
	public Integer spiClientesHCodigos(ArticulosClientes codigosClientes) throws SQLException {
		Connection conn = null;
	     CallableStatement cstmt = null;
	     int idClientesHCodigos = 0;	
	     try {
	     conn = this.conection != null ? this.conection : CConnection.getConnection();
	     cstmt = conn.prepareCall(EnumArticulos.SPICLIENTESHCODIGOS.getQuery());
	     cstmt.setInt(1,codigosClientes.getIdClientes());
	     cstmt.setInt(2,codigosClientes.getIdCodigosClientes());
	     cstmt.registerOutParameter(3, Types.INTEGER);
	     cstmt.execute();
	     idClientesHCodigos=cstmt.getInt(3);	     
	    }
	    finally {
	    	 CConnection.close(cstmt);
	            if (this.conection == null) {
	            	CConnection.close(conn);
	            	}
	    }	
		return idClientesHCodigos;
	}

	@Override
	public ArticulosClientes claveProductoCliente(Integer idClientesHCodigos) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArticulosClientes productoServ= null;
        try {
            conn = this.conection != null ? this.conection : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumArticulos.ASIGCODIGOSCLIENTES.getQuery());
            stmt.setInt(1,idClientesHCodigos);
            rs = stmt.executeQuery();
            
            if (rs.next()) {      
            	productoServ = new ArticulosClientes();
            	productoServ.setClaveProducto(rs.getString("ClaveProducto"));
            	productoServ.setDescripProducto(rs.getString("Descripcion"));           	        	            	
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conection == null) {
            	CConnection.close(conn);
            }

        }      
		return productoServ;
	}

	@Override
	public List<Clientes> buscarCliente(Clientes cliente) throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Clientes clientes=null;
        List<Clientes> listClientes= new ArrayList<>();
        String query="";
  
        try {
            conn = this.conection != null ? this.conection : CConnection.getConnection();
           
            
            if(cliente.getIdCliente() >0){
            	query = EnumArticulos.CLIENTES.getQuery()
            			.concat(EnumArticulos.NOMBRECLIENTES.getQuery()
            			.concat(EnumArticulos.APELLIDOUNO.getQuery()
            			.concat(EnumArticulos.APELLIDODOS.getQuery()
            		    .concat(EnumArticulos.IDCLIENTE.getQuery()))
            			));
            	
                stmt = conn.prepareStatement(query);
                stmt.setString(1,"%"+cliente.getNombre()+"%");
                stmt.setString(2,"%"+cliente.getApellidoUno()+"%");
                stmt.setString(3,"%"+cliente.getApellidoDos()+"%");
                stmt.setInt(4,cliente.getIdCliente());
            }
            else if(!cliente.getNombre().equals("") && !cliente.getApellidoUno().equals("") && !cliente.getApellidoDos().equals("")){
            	query = EnumArticulos.CLIENTES.getQuery()
            			.concat(EnumArticulos.NOMBRECLIENTES.getQuery()
            			.concat(EnumArticulos.APELLIDOUNO.getQuery()
            			.concat(EnumArticulos.APELLIDODOS.getQuery())));
            	
                stmt = conn.prepareStatement(query);
                stmt.setString(1,"%"+cliente.getNombre()+"%");
                stmt.setString(2,"%"+cliente.getApellidoUno()+"%");
                stmt.setString(3,"%"+cliente.getApellidoDos()+"%");
          
            	
            }
            else if(!cliente.getNombre().equals("") && !cliente.getApellidoUno().equals("")){
            	query = EnumArticulos.CLIENTES.getQuery().concat(EnumArticulos.NOMBRECLIENTES.getQuery().concat(EnumArticulos.APELLIDOUNO.getQuery()));          	
            	stmt = conn.prepareStatement(query);
                stmt.setString(1,"%"+cliente.getNombre()+"%");
                stmt.setString(2,"%"+cliente.getApellidoUno()+"%");
              
            }
            else if(!cliente.getNombre().equals("")){
            	query = EnumArticulos.CLIENTES.getQuery().concat(EnumArticulos.NOMBRECLIENTES.getQuery());            	
            	stmt = conn.prepareStatement(query);
            
            	System.out.println("entra");
                stmt.setString(1,"%"+cliente.getNombre()+"%");
               
            }
            
            
            rs = stmt.executeQuery();
            int x=0;
            while (rs.next()) {      
            	clientes = new Clientes();
            	clientes.setIdCliente(rs.getInt("IdCliente"));
            	clientes.setNombre(rs.getString("Nombre"));
            	clientes.setRfc(rs.getString("RFC"));
            	clientes.setDireccion(rs.getString("Direccion"));
            	clientes.setLocalidad(rs.getString("Localidad"));
            	listClientes.add(clientes);
            	  x++;        	        	            	
            }
            
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conection == null) {
            	CConnection.close(conn);
            }

        }      
		return listClientes;
	}

	@Override
	public List<ArticulosClientes> selectClientesArticulos() throws SQLException {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArticulosClientes articulos= null;
        Clientes clientes=null;
        List<ArticulosClientes>listArticulos= new ArrayList<>();
        try {
            conn = this.conection != null ? this.conection : CConnection.getConnection();
            stmt = conn.prepareStatement(EnumArticulos.SELECTCLIENTESARTICULOS.getQuery());
            rs = stmt.executeQuery();
            
            while (rs.next()) {      
            	articulos = new ArticulosClientes();	
            	clientes=new Clientes();
            	clientes.setIdCliente(rs.getInt("IdClientes"));
            	clientes.setNombre(rs.getString("NombreCliente"));
            	articulos.setClientesArticulos(clientes);
             	articulos.setClaveUnidad(rs.getString("ClaveUnidad"));
            	articulos.setDescripUnidad(rs.getString("Nombre"));	
            	articulos.setClaveProducto(rs.getString("ClaveProducto"));
            	articulos.setDescripProducto(rs.getString("Descripcion"));    	
            	listArticulos.add(articulos);
            	    
            }     
        } finally {
        	CConnection.close(rs);
        	CConnection.close(stmt);
            if (this.conection == null) {
            	CConnection.close(conn);
            }

        }      
		return listArticulos;
	}

}
