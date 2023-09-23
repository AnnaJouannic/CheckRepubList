package checkrepublist.group.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import checkrepublist.group.api.request.VoyageRequest;
import checkrepublist.group.api.response.VoyageResponse;
import checkrepublist.group.dao.IDAOCritere;
import checkrepublist.group.dao.IDAOMaterielRef;
import checkrepublist.group.dao.IDAOVoyage;
import checkrepublist.group.exception.VoyageNotFoundException;
import checkrepublist.group.exception.VoyageNotValidException;
import checkrepublist.group.model.Critere;
import checkrepublist.group.model.MaterielRef;
import checkrepublist.group.model.TypeClimat;
import checkrepublist.group.model.TypeDeplacement;
import checkrepublist.group.model.TypeLogement;
import checkrepublist.group.model.Voyage;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/voyage")
public class VoyageApiController {
	@Autowired
	private IDAOVoyage repoVoyage;
	
	@Autowired
	private IDAOCritere repoCritere;
	
	@Autowired
	IDAOMaterielRef repoMaterielRef;
	
	@GetMapping
	@JsonView(Views.Voyage.class)
	public List<Voyage> findAll() {
		return this.repoVoyage.findAll();
	}

	@GetMapping("/{id}")
	@Transactional 
	public VoyageResponse findById(@PathVariable Integer id) {
        Voyage voyage = this.repoVoyage.findById(id).orElseThrow(VoyageNotFoundException::new);
        VoyageResponse response = new VoyageResponse();

        BeanUtils.copyProperties(voyage, response);
        
        response.setVoyageurs(voyage.getVoyageurs());
        response.setMateriels(voyage.getMateriels());
      

        return response;
	}

	@PostMapping
	@Transactional 
	@JsonView(Views.Voyage.class)
	public Voyage add(@Valid @RequestBody VoyageRequest voyageRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new VoyageNotValidException();
		}
		
		Voyage voyage = new Voyage();

		BeanUtils.copyProperties(voyageRequest, voyage);
		
		List<Critere> criteres = this.repoCritere.findAllTest(voyage.getLogement(), voyage.getDeplacement(), voyage.getClimat());
		List<MaterielRef> listeMateriel = new ArrayList<>();
		for (Critere critere : criteres) {
	        listeMateriel.add(critere.getMaterielref());
	    }
		
		
		voyage.setMateriels(listeMateriel);

		return this.repoVoyage.save(voyage);
	}
	
	 
	@PutMapping("/{id}")
	@Transactional
	@JsonView(Views.Voyage.class)
	public Voyage edit(@PathVariable Integer id, @Valid @RequestBody VoyageRequest voyageRequest,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new VoyageNotValidException();
		}

		Voyage voyage = this.repoVoyage.findById(id).orElseThrow(VoyageNotFoundException::new);

		BeanUtils.copyProperties(voyageRequest, voyage);

		return this.repoVoyage.save(voyage);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
		this.repoVoyage.deleteById(id);
	}
	
	public List<MaterielRef> materielFiltre (List <Critere> criteres, TypeDeplacement deplacement,TypeClimat climat, TypeLogement logement){
		
		List<MaterielRef> listeMateriel = new ArrayList<>();
		
		for (Critere critere : criteres) {
			if (climat == null && deplacement == null && logement == null) {
				listeMateriel.add(critere.getMaterielref());
			}
            // Vérifiez si les trois critères correspondent.
            if (critereMatch(critere, climat, deplacement, logement, 3)) {
            	listeMateriel.add(critere.getMaterielref());
            }
            // Sinon, vérifiez si deux critères correspondent.
            else if (critereMatch(critere, climat, deplacement, logement, 2)) {
            	listeMateriel.add(critere.getMaterielref());
            }
            // Sinon, vérifiez si un critère correspond.
            else if (critereMatch(critere, climat, deplacement, logement, 1)) {
            	listeMateriel.add(critere.getMaterielref());
            }
        }
		return listeMateriel;
	}
	

	    private boolean critereMatch(Critere critere, TypeClimat climat, TypeDeplacement deplacement, TypeLogement logement, int numMatches) {
	        int matches = 0;

	        if (climat != null && climat.equals(critere.getClimat())) {
	            matches++;
	        }
	        if (deplacement != null && deplacement.equals(critere.getDeplacement())) {
	            matches++;
	        }
	        if (logement != null && logement.equals(critere.getLogement())) {
	            matches++;
	        }

	        return matches == numMatches;
	    }
	
}
