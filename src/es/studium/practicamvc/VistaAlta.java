package es.studium.practicamvc;

import java.awt.*;

public class VistaAlta extends Frame{

	private static final long serialVersionUID = 1L;
	
	Label fechaL = new Label("Fecha");
	TextField fechaT = new TextField("DD/MM/AAAA");
	Label ofertaL = new Label("Oferta:");	
	Choice ofertaC = new Choice();
	Label demandanteL = new Label("Demandante:");
	Choice demandanteC = new Choice();
	Button aceptar = new Button("Aceptar");
	Button cancelar = new Button("Cancelar");
	
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();
	Panel panel4 = new Panel();
	
	VistaAlta(){
		setTitle("Alta Asignacion");
		setSize(300,400);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(5,1));
		panel1.add(fechaL);
		panel1.add(fechaT);
		ofertaC.addItem("Seleccione una oferta ...");
		panel2.add(ofertaL);
		panel2.add(ofertaC);
		demandanteC.addItem("Seleccione un demandante ...");
		panel3.add(demandanteL);
		panel3.add(demandanteC);
		panel4.add(aceptar);
		panel4.add(cancelar);
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
	}
	
}
