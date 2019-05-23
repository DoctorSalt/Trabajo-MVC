package es.studium.practicamvc;
public class PrincipalConsultaOfertas {
	PrincipalConsultaOfertas(){
		VistaConsulta vc=new VistaConsulta();
		ControladorConsulta ca=new ControladorConsulta(vc);
	}
}
