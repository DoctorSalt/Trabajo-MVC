package es.studium.practicamvc;

public class PrincipalConector {

	public static void main(String[] args) {
		MenuVista mv=new MenuVista();
		MenuControlador mc=new MenuControlador(mv);
	}

}
