package es.studium.practicamvc;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class VistaModificaciones2 extends Frame{

	private static final long serialVersionUID = 1L;
	
	Label numeroOferta = new Label();
	Label fecha1L = new Label("Fecha:");
	TextField fecha1T = new TextField("DD/MM/AAAA");
	Label fecha2L = new Label("Fecha Fin:");
	TextField fecha2T = new TextField("DD/MM/AAAA");
	Label requisitosL = new Label("Requisitos:");
	TextField requisitosT = new TextField("lorem ipsum...");
	Button actualizar = new Button("Actualizar");
	Button cancelar = new Button("Cancelar");
	
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();
	Panel panel4 = new Panel();
	Panel panel5 = new Panel();
		
	VistaModificaciones2(String t){
		setTitle("Edicion Oferta");
		setSize(300,300);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(5,1));
		numeroOferta.setText("Oferta: "+t);
		panel1.add(numeroOferta);
		panel2.add(fecha1L);
		panel2.add(fecha1T);
		panel3.add(fecha2L);
		panel3.add(fecha2T);
		panel4.add(requisitosL);
		panel4.add(requisitosT);
		panel5.add(actualizar);
		panel5.add(cancelar);
	}
}
