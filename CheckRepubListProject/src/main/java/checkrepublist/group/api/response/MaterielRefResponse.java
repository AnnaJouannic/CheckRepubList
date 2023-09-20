package checkrepublist.group.api.response;

import java.util.ArrayList;
import java.util.List;

import checkrepublist.group.model.Categorie;
import checkrepublist.group.model.Critere;

public class MaterielRefResponse {

	private Integer id;
	
	private String libelleMateriel;
	
	private Categorie categorie;
	
	List<Critere> criteres;
	
}
