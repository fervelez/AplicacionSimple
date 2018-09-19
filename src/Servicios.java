package mx.org.ift.managedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


@ManagedBean
public class Servicios {
	private String[] selectedServicios;
	private List<String> servicios;

	@PostConstruct
	public void init() {
		servicios = new ArrayList<String>();
		servicios.add("Internet");
		servicios.add("Internet + Telefonía fija + TV de paga");
		servicios.add("Telefonía fija");
		servicios.add("Telefonía fija + TV de paga");
		servicios.add("Telefonía fija + Internet");
		servicios.add("Telefonía móvil");
		servicios.add("TV de paga");
	}

	public void siguiente(ActionEvent actionEvent) {
		System.out.println("----llega siguiente "+selectedServicios.length);
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Estamos buscando todos los proveedores que coincidan con tu selección", null);
		// msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
		// "Credenciales no v�lidas");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		//context.addCallbackParam("estaLogeado", logeado);

		try {
			//vamos a la base y ejecutamos consulta
			context.getExternalContext().redirect("contratos.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String[] getSelectedServicios() {
		return selectedServicios;
	}

	public void setSelectedServicios(String[] selectedServicios) {
		this.selectedServicios = selectedServicios;
	}

	public List<String> getServicios() {
		return servicios;
	}

}
