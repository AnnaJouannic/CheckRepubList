package checkrepublist.group.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import checkrepublist.group.dao.IDAOVoyageur;
import checkrepublist.group.exception.VoyageNotFoundException;
import checkrepublist.group.exception.VoyageNotValidException;
import checkrepublist.group.exception.VoyageurNotFoundException;
import checkrepublist.group.model.Critere;
import checkrepublist.group.model.MaterielRef;
import checkrepublist.group.model.Voyage;
import checkrepublist.group.model.Voyageur;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/voyage")
@CrossOrigin("*")
public class VoyageApiController {
	@Autowired
	private IDAOVoyage repoVoyage;
	
	@Autowired
	private IDAOCritere repoCritere;
	
	@Autowired
	IDAOMaterielRef repoMaterielRef;
	
	@Autowired
	IDAOVoyageur repoVoyageur;
	
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
        response.setLogement(String.valueOf(voyage.getLogement()));
		response.setDeplacement(String.valueOf(voyage.getDeplacement()));
		response.setClimat(String.valueOf(voyage.getClimat()));
		
		List<Integer> id_materiels=new ArrayList<>();
		List<MaterielRef> obj_materiels = voyage.getMateriels();
		for( MaterielRef materiel : obj_materiels) {
			id_materiels.add(materiel.getId());
		}
		response.setIdMateriels(id_materiels);
		
		List<Integer> id_voyageurs=new ArrayList<>();
        List<Voyageur> obj_voyageurs = voyage.getVoyageurs();
        for( Voyageur voyageur : obj_voyageurs) {
            id_voyageurs.add(voyageur.getId());
        }
        response.setIdVoyageurs(id_voyageurs);
       
        return response;
	}

	@PostMapping
	@Transactional 
	public VoyageResponse add(@Valid @RequestBody VoyageRequest voyageRequest, BindingResult result) {
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
		
		this.repoVoyage.save(voyage);
		System.out.println(voyage);
		
		VoyageResponse response = new VoyageResponse();
		
		BeanUtils.copyProperties(voyage, response);
        response.setLogement(String.valueOf(voyage.getLogement()));
		response.setDeplacement(String.valueOf(voyage.getDeplacement()));
		response.setClimat(String.valueOf(voyage.getClimat()));
		
		List<Integer> id_materiels=new ArrayList<>();
		List<MaterielRef> obj_materiels = voyage.getMateriels();
		for( MaterielRef materiel : obj_materiels) {
			id_materiels.add(materiel.getId());
		}
		response.setIdMateriels(id_materiels);
		
		
		if (voyageRequest.getIdVoyageur() != null) {
		List<Integer> id_voyageurs=new ArrayList<>();
        List<Voyageur> obj_voyageurs = voyage.getVoyageurs();
        for( Voyageur voyageur : obj_voyageurs) {
            id_voyageurs.add(voyageur.getId());
        }
        response.setIdVoyageurs(id_voyageurs);
		}
		
		return response;
	}
	
	 
	@PutMapping("/{id}")
	@Transactional
	public VoyageResponse edit(@PathVariable Integer id, @Valid @RequestBody VoyageRequest voyageRequest,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new VoyageNotValidException();
		}

		Voyage voyage = this.repoVoyage.findById(id).orElseThrow(VoyageNotFoundException::new);

		BeanUtils.copyProperties(voyageRequest, voyage);
		
		System.out.println(voyageRequest.getIdVoyageur());
		if (voyageRequest.getIdVoyageur() != null) {
			System.out.println(voyageRequest.getIdVoyageur());
		Voyageur voyageur1 = this.repoVoyageur.findById(voyageRequest.getIdVoyageur()).orElseThrow(VoyageurNotFoundException::new);
		
		List<Voyageur> list = new ArrayList<>();
		list.add(voyageur1);
		voyage.setVoyageurs(list);
		}

		this.repoVoyage.save(voyage);
		System.out.println(voyage.getVoyageurs());
		
		VoyageResponse response = new VoyageResponse();
		
		BeanUtils.copyProperties(voyage, response);
        response.setLogement(String.valueOf(voyage.getLogement()));
		response.setDeplacement(String.valueOf(voyage.getDeplacement()));
		response.setClimat(String.valueOf(voyage.getClimat()));
		
		System.out.println(response);
		System.out.println(voyageRequest.getIdVoyageur());
		if (voyageRequest.getIdVoyageur() != null) {
		List<Integer> id_voyageurs=new ArrayList<>();
        List<Voyageur> obj_voyageurs = voyage.getVoyageurs();
        for( Voyageur voyageur : obj_voyageurs) {
        	
            id_voyageurs.add(voyageur.getId());
            System.out.println(id_voyageurs);
        }
        response.setIdVoyageurs(id_voyageurs);
		}
		
		return response;
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
		this.repoVoyage.deleteById(id);
	}
	

}
