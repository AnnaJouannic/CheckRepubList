package checkrepublist.group.api;

import java.util.List;

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

import checkrepublist.group.dao.IDAOVoyageur;
import checkrepublist.group.model.Voyageur;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/voyageur")
public class VoyageurApiController {

	@Autowired
	private IDAOVoyageur daoVoyageur;

	@GetMapping
	
	public List<Voyageur> findAll() {
		return this.daoVoyageur.findAll();
	}

	@GetMapping("/{id}")
	@Transactional // Important pour garder l'EntityManager pour récupérer getProduits()
	public Voyageur findById(@PathVariable Integer id) {
		Voyageur voyageur = this.daoVoyageur.findById(id).orElseThrow(VoyageurNotFoundException::new);
		//VoyageurResponse response = new VoyageurResponse();

		//BeanUtils.copyProperties(voyageur, response);

		//response.setVoyage(voyageur.getVoyages());

		//return response;
		return voyageur;
	}

	@PostMapping
	
	public Voyageur add(@Valid @RequestBody Voyageur voyageur, BindingResult result) {
		if (result.hasErrors()) {
			throw new VoyageurNotValidException();
		}

		//Voyageur voyageur = new Voyageur();

		//BeanUtils.copyProperties(voyageurRequest, voyageur);

		return this.daoVoyageur.save(voyageur);
	}

	@PutMapping("/{id}")
	
	public Voyageur edit(@PathVariable Long id, @Valid @RequestBody Voyageur voyageur,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new VoyageurNotValidException();
		}

		//Voyageur voyageur = this.daoVoyageur.findById(id).orElseThrow(VoyageurNotFoundException::new);

		//BeanUtils.copyProperties(voyageurRequest, voyageur);

		return this.daoVoyageur.save(voyageur);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
		this.daoVoyageur.deleteById(id);
	}
}
	

