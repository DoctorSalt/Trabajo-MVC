package es.studium.practicamvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modelo3 {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/practicamvc?autoReconnect=true&useSSL=false";
	String login = "root";
	String password = "Studium2018;";
	Connection connection = null;
	java.sql.Statement statement = null;
	ResultSet rs = null;
	private VistaModificaciones vis;
	Modelo3(VistaModificaciones v1){
		vis=v1;
	}
	
	
	public String americanizacionFecha(String fechaOrigen) {
		String[] fecha = fechaOrigen.split("/");
		String fechaAmericana ="'"+fecha[2]+"-"+fecha[1]+"-"+fecha[0]+"'";
		return fechaAmericana;
	}
	public String fechaNormalizacion(String fechaOrigen) {
		String[] fecha = fechaOrigen.split("-");
		String fechaNuestra ="'"+fecha[2]+"/"+fecha[1]+"/"+fecha[0]+"'";
		return fechaNuestra;
	}
	

	public String Elegir(String elegido) {
		String[] cosasElegidas = elegido.split(" - ");
		String numeroElegido = cosasElegidas[0];
		return numeroElegido;
	}

	public String RecogerNombre(String numeroElegido) {
		// TODO Auto-generated method stub
		String sentencia="";
		conectar();
		ejecutar(sentencia);
		String nombre="";
		try {
			nombre = rs.getString("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		desconectar();
		return nombre;
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

	public String[] datosRellena(String numero) {
		String sentencia="select * from practicamvc.oferta where idOferta="+numero+";";
		String[] datos= new String[3];
		conectar();
		ejecutar(sentencia);
		try {
		while(rs.next()) {
			datos[0]=rs.getString("fechaOferta");
			datos[1]=rs.getString("fechaFinOferta");
			datos[2]=rs.getString("requisitosOferta");
		}
		}catch(SQLException e){
			System.out.println(e);
		}
		desconectar(); 
		return datos;
	}


	public void MeterDatosChoice() {
		String sentencia="select * from practicamvc.ofertas;";
		conectar();
		ejecutar(sentencia);
		try {
			while(rs.next()) {
				int numeroId=rs.getInt("idOferta");
				String detalle =rs.getString("requisitosOferta");
				String fechaFin = fechaNormalizacion(rs.getString("fechaFinOferta"));
				vis.ofertaCM.addItem(numeroId+" - "+detalle+" - "+fechaFin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}	
}
