package es.studium.practicamvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
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
	TablaDeDatos(){
		conectar();
		String sentencia="SELECT idOferta,\r\n" + 
				"COUNT(idDemandanteFK) as 'NumeroDemandantes', \r\n" + 
				" fechaFinOferta as 'Fecha Fin'\r\n" + 
				"from practicamvc.ofertas, practicamvc.asignaciones \r\n" + 
				"where idOfertaFK=idDemandanteFK\r\n" + 
				"ORDER BY 1;";
		ejecutar(sentencia);
		desconectar();		
	}
	private static JTable ejecutar(String sentencia) {
		int tamano=3;
		try
		{
			String palabro="";
			Vector columnNames=new Vector();
			modelo.addColumn("Oferta");
			columnNames.addElement("Oferta");				
			modelo.addColumn("Numero de Demandantes");
			columnNames.addElement("Numero de Demandantes");				
			modelo.addColumn("Fecha Fin");
			columnNames.addElement("Fecha Fin");				
			modelo.setColumnIdentifiers(columnNames);
			statement = connection.createStatement();
			rs = statement.executeQuery(sentencia);
			while(rs.next())
			{
				Object [] fila = new Object[tamano];
				fila[0] = rs.getInt("idOferta");
				fila[1] = rs.getString("NumeroDemandantes");
				fila[2] = rs.getString("Fecha Fin");
				modelo.addRow(fila);				
			}
		}
		catch (SQLException sqle)
		{
			System.out.println("Error de SQL: "+sqle.getMessage());
		}
		JTable tabla = new JTable(modelo);
		return tabla;
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
