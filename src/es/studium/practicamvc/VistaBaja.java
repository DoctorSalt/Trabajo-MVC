package es.studium.practicamvc;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class VistaBaja extends Frame{

	private static final long serialVersionUID = 1L;
	
	Label eligeL =new Label("Elegir demandante a dar de baja");
	Choice demandanteCD = new Choice();
	Button eliminar = new Button("Eliminar");
	Button cancelar = new Button("Cancelar");
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();
	
	Dialog confirmarBaja =new Dialog(this);
	//meter aqui algo que se diga
	Label seguroL = new Label(); 
	Button si = new Button("Sí");
	Button no = new Button("No");
	Panel panelA = new Panel();
	Panel panelB = new Panel();
	
	VistaBaja(){
		setTitle("Baja Demandante");
		setSize(300,300);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3,1));
		demandanteCD.addItem("Seleccione un demandante ...");
		panel1.add(eligeL);
		panel2.add(demandanteCD);
		panel3.add(eliminar);
		panel3.add(cancelar);
		add(panel1);
		add(panel2);
		add(panel3);
	}
	public void confirmarBajasC(String t){
		confirmarBaja.setTitle("¿Seguro/a?");
		confirmarBaja.setSize(300,150);
		confirmarBaja.setLocationRelativeTo(null);
		confirmarBaja.setLayout(new GridLayout(2,1));
		seguroL.setText("Seguro/a de eliminar a "+t);
		panelA.add(seguroL);
		panelB.add(si);
		panelB.add(no);
		confirmarBaja.add(panelA);
		confirmarBaja.add(panelB);
	}
	
}
