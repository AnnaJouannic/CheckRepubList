package checkrepublist.group.api.request;

import checkrepublist.group.model.TypeClimat;
import checkrepublist.group.model.TypeDeplacement;
import checkrepublist.group.model.TypeLogement;
import jakarta.validation.constraints.NotBlank;

public class CritereRequest {

	@NotBlank
	private String libelleMateriel;
	
	private TypeLogement logement;
	
	private TypeDeplacement deplacement;

	private TypeClimat climat;
}
