package es.studium.practicamvc;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

public class VistaConsulta extends Frame{

	private static final long serialVersionUID = 1L;
	
	TablaDeDatos ta=new TablaDeDatos();
	
	Button aceptar = new Button("aceptar");
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	
	VistaConsulta(){
		setTitle("Consulta Ofertas");
		setSize(400,200);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(2,1));
		panel1.add(ta.tabla);
		panel2.add(aceptar);
		add(panel1);
		add(panel2);
	}
}
