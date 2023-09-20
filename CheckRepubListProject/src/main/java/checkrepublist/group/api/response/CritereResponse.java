package checkrepublist.group.api.response;

import checkrepublist.group.model.TypeClimat;
import checkrepublist.group.model.TypeDeplacement;
import checkrepublist.group.model.TypeLogement;
import jakarta.validation.constraints.NotBlank;

public class CritereResponse {
	
	private Integer id;
	
	@NotBlank
	private String libelleMateriel;
	
	private TypeLogement logement;
	
	private TypeDeplacement deplacement;

	private TypeClimat climat;

}
