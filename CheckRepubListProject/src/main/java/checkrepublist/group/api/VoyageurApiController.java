package checkrepublist.group.api;

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

import checkrepublist.group.api.request.VoyageurRequest;
import checkrepublist.group.api.response.VoyageurResponse;
import checkrepublist.group.dao.IDAOVoyageur;
import checkrepublist.group.exception.VoyageurNotFoundException;
import checkrepublist.group.exception.VoyageurNotValidException;
import checkrepublist.group.model.Voyageur;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/voyageur")
@CrossOrigin("*")
public class VoyageurApiController {

	@Autowired
	private IDAOVoyageur repoVoyageur;

	@GetMapping
	public List<Voyageur> findAll() {
		return this.repoVoyageur.findAll();
	}

	@GetMapping("/{id}")
	@Transactional 
	public VoyageurResponse findById(@PathVariable Integer id) {
		Voyageur voyageur = this.repoVoyageur.findById(id).orElseThrow(VoyageurNotFoundException::new);
		VoyageurResponse response = new VoyageurResponse();

		BeanUtils.copyProperties(voyageur, response);

		return response;
	}

	@PostMapping
	public Voyageur add(@Valid @RequestBody VoyageurRequest voyageurRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new VoyageurNotValidException();
		}

		Voyageur voyageur = new Voyageur();

		BeanUtils.copyProperties(voyageurRequest, voyageur);

		return this.repoVoyageur.save(voyageur);
	}

	@PutMapping("/{id}")
	public Voyageur edit(@PathVariable Integer id, @Valid @RequestBody VoyageurRequest voyageurRequest,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new VoyageurNotValidException();
		}

		Voyageur voyageur = this.repoVoyageur.findById(id).orElseThrow(VoyageurNotFoundException::new);

		BeanUtils.copyProperties(voyageurRequest, voyageur);

		return this.repoVoyageur.save(voyageur);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
		this.repoVoyageur.deleteById(id);
	}
}
	

