package es.studium.practicamvc;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class VistaModificaciones extends Frame{

	private static final long serialVersionUID = 1L;
	
	Label eligeL = new Label("Elija la oferta a Editar");
	Choice ofertaCM = new Choice();
	
	Button editar = new Button("editar");
	Button cancelar = new Button("cancelar");
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();
	
	VistaModificaciones(){
		setTitle("Modificacion Oferta");
		setSize(300,300);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3,1));
		panel1.add(eligeL);
		ofertaCM.addItem("Seleccione oferta ...");
		panel2.add(ofertaCM);
		panel3.add(editar);
		panel3.add(cancelar);
		add(panel1);
		add(panel2);
		add(panel3);
	}
}
