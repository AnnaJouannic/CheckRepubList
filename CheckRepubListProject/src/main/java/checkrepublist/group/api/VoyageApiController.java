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

import checkrepublist.group.dao.IDAOVoyage;
import checkrepublist.group.exception.VoyageNotFoundException;
import checkrepublist.group.exception.VoyageNotValidException;
import checkrepublist.group.model.Voyage;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/voyage")
public class VoyageApiController {
	@Autowired
	private IDAOVoyage daoVoyage;

	@GetMapping
	public List<Voyage> findAll() {
		return this.daoVoyage.findAll();
	}

	@GetMapping("/{id}")
	public Voyage findById(@PathVariable Integer id) {
		return this.daoVoyage.findById(id).orElseThrow(VoyageNotFoundException::new);
		
	}

	@PostMapping
	public Voyage add(@Valid @RequestBody Voyage voyage, BindingResult result) {
		if (result.hasErrors()) {
			throw new VoyageNotValidException();
		}

		return this.daoVoyage.save(voyage);
	}

	@PutMapping("/{id}")
	public Voyage edit(@PathVariable Integer id, @Valid @RequestBody Voyage voyage,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new VoyageNotValidException();
		}

		return this.daoVoyage.save(voyage);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
		this.daoVoyage.deleteById(id);
	}
}
