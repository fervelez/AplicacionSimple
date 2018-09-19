package mx.org.ift.managedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

@ManagedBean
public class Contratos {
	
	private String[] selectedContratos;
	private List<String> contratos;

	private String txt1;
    private String txt2;
    private String txt3;
    private String txt4;
    private String txt5;
    private String txt6;
    private String txt7;
    private String txt8;
    
    
    @PostConstruct
	public void init() {
    	contratos = new ArrayList<String>();
    	contratos.add("AT&T");
    	contratos.add("Axtel");
    	contratos.add("Cablecom");
    	contratos.add("Cablevision");
    	contratos.add("Dish");
    	contratos.add("Maxcom");
    	contratos.add("Megacable");
    	contratos.add("Movistar");
    	contratos.add("Sky");
    	contratos.add("Star");
	}
    
    public void siguiente(ActionEvent actionEvent) {
		System.out.println("----llega siguiente "+selectedContratos.length);
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
			context.getExternalContext().redirect("resultado.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            results.add(query + i);
        }
         
        return results;
    }
         
    public void onItemSelect(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
    }
 
    public String getTxt1() {
        return txt1;
    }
 
    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }
 
    public String getTxt2() {
        return txt2;
    }
 
    public void setTxt2(String txt2) {
        this.txt2 = txt2;
    }
 
    public String getTxt3() {
        return txt3;
    }
 
    public void setTxt3(String txt3) {
        this.txt3 = txt3;
    }
 
    public String getTxt4() {
        return txt4;
    }
 
    public void setTxt4(String txt4) {
        this.txt4 = txt4;
    }
 
    public String getTxt5() {
        return txt5;
    }
 
    public void setTxt5(String txt5) {
        this.txt5 = txt5;
    }
 
    public String getTxt6() {
        return txt6;
    }
 
    public void setTxt6(String txt6) {
        this.txt6 = txt6;
    }
 
    public String getTxt7() {
        return txt7;
    }
 
    public void setTxt7(String txt7) {
        this.txt7 = txt7;
    }
 
    public String getTxt8() {
        return txt8;
    }
 
    public void setTxt8(String txt8) {
        this.txt8 = txt8;
    }
    
    public String[] getSelectedContratos() {
		return selectedContratos;
	}

	public void setSelectedContratos(String[] selectedContratos) {
		this.selectedContratos = selectedContratos;
	}

    public List<String> getContratos() {
		return contratos;
	}
    
}

