package es.studium.practicamvc;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class MenuVista extends Frame{
	private static final long serialVersionUID = 1L;
	MenuBar barramenu = new MenuBar();
	MenuItem demandantesBaja = new MenuItem ("Bajas");
	MenuItem modificacionOfertas = new MenuItem("Modificación");
	MenuItem consultaOfertas = new MenuItem("Consulta");
	MenuItem altaGestion = new MenuItem("Alta");
	
	Menu demandantes = new Menu("Demandantes");
	Menu ofertas = new Menu("Ofertas");
	Menu gestion = new Menu("Gestión");
	MenuVista(){
		setTitle("Practica MVC");
		setSize(300,200);
		setLocationRelativeTo(null);
		setMenuBar(barramenu);
		demandantes.add(demandantesBaja);
		ofertas.add(modificacionOfertas);
		ofertas.add(consultaOfertas);
		gestion.add(altaGestion);
		barramenu.add(demandantes);
		barramenu.add(ofertas);
		barramenu.add(gestion);
	}
}
