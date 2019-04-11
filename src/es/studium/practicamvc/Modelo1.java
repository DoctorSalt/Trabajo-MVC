package es.studium.practicamvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class Modelo1{
	public VistaAlta va;
	Modelo1(VistaAlta va1){
		va=va1;
	}	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/practicamvc?autoReconnect=true&useSSL=false";
	String login = "root";
	String password = "Studium2018;";
	Connection connection = null;
	java.sql.Statement statement = null;
	ResultSet rs = null;
	
	public void meterDatosdeOfertanteC(String sentencia) {
		conectar();
		ejecutar(sentencia);
		try {
			while(rs.next()) {
				int numeroId=rs.getInt("idOferta");
				String detalle =rs.getString("requisitosOferta");
				String fechaFin = fechaNormalizacion(rs.getString("fechaFinOferta"));
				va.ofertaC.addItem(numeroId+" - "+detalle+" - "+fechaFin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}
	
	public void conectar() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);	
		}catch(ClassNotFoundException cnfe) {
			System.out.println("Error 1: "+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
			System.out.println("Error C");
		}		
	}
	
	public void ejecutar(String sentencia) {
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sentencia);
		}
		catch(SQLException sqle) {
			System.out.println("Error al ejecutar:");
			System.out.println(sqle);
		}		
	}
	
	public void ejecutar2(String sentencia) {
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sentencia);	
			}catch(SQLException error)
			{
				System.out.println("SQl te dio el siguiente error:");
				System.out.println(error);
			}				
	}
	
	public void desconectar() {
		try
		{
			if(connection!=null)
			{
				connection.close();
			}
		}
		catch (SQLException e)
		{
			System.out.println("Error 3: "+e.getMessage());
		}			
	}	
	
	public String americanizacionFecha(String fechaOrigen) {
		String[] fecha = fechaOrigen.split("/");
		String fechaAmericana ="'"+fecha[2]+"-"+fecha[1]+"-"+fecha[0]+"'";
		return fechaAmericana;
	}
	public String actualFecha() {
		Calendar c1 = Calendar.getInstance(); 
		int dia = c1.get(Calendar.DATE);
		int mes = c1.get(Calendar.MONTH)+1;
		int anyo = c1.get(Calendar.YEAR);
		String fecha = dia+"/"+mes+"/"+anyo;
		return fecha;
	}
	public String Elegir(String elegido){
		String[] cosasElegidas = elegido.split(" - ");
		String numeroElegido = cosasElegidas[0];
		return numeroElegido;
	}
	public String fechaNormalizacion(String fechaOrigen) {
		String[] fecha = fechaOrigen.split("-");
		String fechaNuestra ="'"+fecha[2]+"-"+fecha[1]+"-"+fecha[0]+"'";
		return fechaNuestra;
	}

	public void meterDatosdeDemandante(String sentencia) {
		//Aqui hay que meter por otra parte los datos del choice de demadanteC
		sentencia="Select * from practicamvc.demandantes";
		conectar();
		ejecutar(sentencia);
		try {
			while(rs.next()) {
				int numeroId=rs.getInt("idDemandante");
				String nombre =rs.getString("nombreDemandante");
				String apellido =rs.getString("apellidosDemandante");
				String dni = rs.getString("dniDemandante");
				va.demandanteC.addItem(numeroId+" - "+nombre+" - "+apellido+" - "+dni);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}
	public void insertarDatosDeAlta(String sentencia) {
		conectar();
		ejecutar2(sentencia);
		desconectar();
	}
}
