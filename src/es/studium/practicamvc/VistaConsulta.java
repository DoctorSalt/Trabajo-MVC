package es.studium.practicamvc;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JScrollPane;

public class VistaConsulta extends Frame{

	private static final long serialVersionUID = 1L;
	
	
	
	TablaDeDatos ta=new TablaDeDatos();
	
	Button aceptar = new Button("aceptar");
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	
	VistaConsulta(){
		setTitle("Consulta Ofertas");
		setSize(700,200);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(2,1));
		panel1.add(new JScrollPane(ta.tabla));
		panel2.add(aceptar);
		add(panel1);
		add(panel2);
	}
}
