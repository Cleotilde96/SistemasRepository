package backend;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import backend.data.notransactional.ArticulosClienteImplement;
import backend.data.notransactional.ImpresionImplement;
import backend.dto.ArticulosClientes;
import backend.dto.Impresion;
import backend.enums.EnumImpresion;

public class testArticulos {
	

	
	public static void main(String[] args) {
		
//		int []array= {1,2,3,4,5};
//		
//		for(int x=1 ; x<10 ;x++){
//			
//			System.err.println("entrando al ciclo");
//			if(x==4){
//				continue;
//			}
//			System.out.println("el valor es:"+x);
//		}
//		System.out.println("has dejado el ciclo");
//
		
		try {
			
			
			int valor=-1;
			for(int x=1;x<=10;x++){
				valor = x;
				System.out.println("valor:"+x);
			}
			
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
		
		
	}
	

}
