package es.studium.practicamvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaDeDatos {
	public VistaBaja vb;
	
	static DefaultTableModel modelo = new DefaultTableModel();
	JTable tabla = new JTable(modelo);

	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/practicamvc?autoReconnect=true&useSSL=false";
	static String login = "root";
	static String password = "Studium2018;";
	static Connection connection = null;
	static java.sql.Statement statement = null;
	static ResultSet rs = null;	
	
	public static void main(String[] args) {
		conectar();
		String sentencia="select * from practicamvc.ofertas;";
		ejecutar(sentencia);
		desconectar();
	}
	
	
	private static void desconectar() {
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
	/* EN PROCESO DE FRABICACION
	private static void ejecutar(String sentencia) {
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sentencia);
			//creo columnas
			modelo.addColumn("idOferta");
			modelo.addColumn("Nº Demandantes Asignados");
			modelo.addColumn("Fecha final");
			// Bucle para cada resultado en la consulta
			while (rs.next())
			{
			   // Se crea un array que será una de las filas de la tabla. 
			   Object [] fila = new Object[3]; // Hay tres columnas en la tabla

			   // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
			   for (int i=0;i<3;i++)
			      fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
			   // Se añade al modelo la fila completa.
			   modelo.addRow(fila); 
			}
		}
		catch(SQLException sqle) {
			System.out.println("Error al ejecutar:");
			System.out.println(sqle);
		}				
	}
	*/
	private static void conectar() {
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
}
