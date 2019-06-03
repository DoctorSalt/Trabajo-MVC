package es.studium.practicamvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MenuControlador implements WindowListener, ActionListener{
	
	public MenuVista mv;
		
	MenuControlador(MenuVista mv1){
		mv=mv1;
		mv.demandantesBaja.addActionListener(this);
		mv.modificacionOfertas.addActionListener(this);
		mv.consultaOfertas.addActionListener(this);
		mv.altaGestion.addActionListener(this);	
		mv.addWindowListener(this);
		mv.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(mv.demandantesBaja)) {
			VistaBaja vb=new VistaBaja();
			Modelo2 mo = new Modelo2(vb);
			ControladorBaja cb = new ControladorBaja(vb,mo);  
		}else if(arg0.getSource().equals(mv.modificacionOfertas)) {
			VistaModificaciones vm=new VistaModificaciones();
			Modelo3 mo = new Modelo3(vm);
			ControladorModificaciones cm = new ControladorModificaciones(vm,mo);  
		}else if(arg0.getSource().equals(mv.consultaOfertas)) {
			VistaConsulta vc=new VistaConsulta();
			ControladorConsulta ca=new ControladorConsulta(vc);
		}else if(arg0.getSource().equals(mv.altaGestion)) {
			VistaAlta va=new VistaAlta();
			Modelo1 mo = new Modelo1(va);
			ControladorAlta ca=new ControladorAlta(va,mo);
		}
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		if(mv.isActive()) {
			mv.setVisible(false);
		}
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
