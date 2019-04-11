package es.studium.practicamvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modelo2 {
	public VistaBaja vb;
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/practicamvc?autoReconnect=true&useSSL=false";
	String login = "root";
	String password = "Studium2018;";
	Connection connection = null;
	java.sql.Statement statement = null;
	ResultSet rs = null;	
	
	Modelo2(VistaBaja vb1){
		vb=vb1;
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
				vb.demandanteCD.addItem(numeroId+" - "+nombre+" - "+apellido+" - "+dni);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}
	private void desconectar() {
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
	private void ejecutar(String sentencia) {
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sentencia);
		}
		catch(SQLException sqle) {
			System.out.println("Error al ejecutar:");
			System.out.println(sqle);
		}				
	}
	private void conectar() {
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
	public String Elegir(String elegido) {
		String[] cosasElegidas = elegido.split(" - ");
		String numeroElegido = cosasElegidas[0];
		return numeroElegido;
	}
	public String ElegirN(String numeroSeleccionado) {
		String nombre="";
		String sentencia="select nombreDemandante as 'nombre' from demandantes where idDemandante="+numeroSeleccionado+";";
		conectar();
		ejecutar(sentencia);
		try {
			rs.next();
			nombre = rs.getString("nombre");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		desconectar();	
		return nombre;
	}
	public void eliminar(String sentencia) {
		conectar();
		ejecutar2(sentencia);
		desconectar();		
	}
	private void ejecutar2(String sentencia) {
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sentencia);	
			}catch(SQLException error)
			{
				System.out.println("SQl te dio el siguiente error:");
				System.out.println(error);
			}						
	}	
}
