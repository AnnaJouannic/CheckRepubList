package checkrepublist.group.api;

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

import checkrepublist.group.api.request.VoyageRequest;
import checkrepublist.group.api.response.VoyageResponse;
import checkrepublist.group.dao.IDAOCritere;
import checkrepublist.group.dao.IDAOVoyage;
import checkrepublist.group.exception.VoyageNotFoundException;
import checkrepublist.group.exception.VoyageNotValidException;
import checkrepublist.group.model.Voyage;
import eshop.formation.api.response.VoyageDetailResponse;
import eshop.formation.exception.VoyageNotFoundException;
import eshop.formation.model.Voyage;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/voyage")
public class VoyageApiController {
	@Autowired
	private IDAOVoyage voyageRepo;
	
	@Autowired
	private IDAOCritere critereRepo;

	@GetMapping
	public List<Voyage> findAll() {
		return this.voyageRepo.findAll();
	}

	@GetMapping("/{id}")
	@Transactional // Important pour garder l'EntityManager pour récupérer getProduits()
	public VoyageResponse findById(@PathVariable Integer id) {
		Voyage voyage = this.voyageRepo.findById(id).orElseThrow(VoyageNotFoundException::new);
		VoyageResponse response = new VoyageResponse();

		BeanUtils.copyProperties(voyage, response);

		response.setListeMateriel(voyage.getMateriels());

		return response;
	}

	@PostMapping
	public Voyage add(@Valid @RequestBody VoyageRequest voyageRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new VoyageNotValidException();
		}

		return this.voyageRepo.save(voyageRequest);
	}

	@PutMapping("/{id}")
	public Voyage edit(@PathVariable Integer id, @Valid @RequestBody Voyage voyage,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new VoyageNotValidException();
		}

		return this.voyageRepo.save(voyage);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
		this.voyageRepo.deleteById(id);
	}
}
