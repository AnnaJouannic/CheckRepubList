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

import checkrepublist.group.api.request.ActiviteRefRequest;
import checkrepublist.group.api.response.ActiviteRefResponse;
import checkrepublist.group.dao.IDAOActiviteRef;
import checkrepublist.group.exception.ActiviteRefNotFoundException;
import checkrepublist.group.exception.ActiviteRefNotValidException;
import checkrepublist.group.model.ActiviteRef;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/activiteref")
@CrossOrigin("*")
public class ActiviteRefApiControlleur {

	@Autowired
	IDAOActiviteRef activiteRefRepo;
	
	@GetMapping("")
	public List<ActiviteRef> findAll() {
		return this.activiteRefRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@Transactional
	public ActiviteRefResponse findById(@PathVariable Integer id) {
		ActiviteRef activiteref = this.activiteRefRepo.findById(id).orElseThrow(ActiviteRefNotFoundException::new);
		ActiviteRefResponse response = new ActiviteRefResponse();
		
		BeanUtils.copyProperties(activiteref, response);

		
		return response;
	}
	
	@PostMapping("")
	public ActiviteRef create(@Valid @RequestBody ActiviteRefRequest activiterefRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new ActiviteRefNotValidException();
		}
		ActiviteRef	activiteref =	new ActiviteRef();
		activiteref = activiteRefRepo.save(activiteref);

		return activiteref;
	}
	
	@PutMapping("/{id}")
	public ActiviteRef edit( @PathVariable Integer id, @Valid @RequestBody ActiviteRefRequest activiterefRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new ActiviteRefNotValidException();
		}
		ActiviteRef activiteref = this.activiteRefRepo.findById(id).orElseThrow(ActiviteRefNotFoundException::new);
		BeanUtils.copyProperties(activiterefRequest, activiteref);

		return this.activiteRefRepo.save(activiteref);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
	
		this.activiteRefRepo.deleteById(id);
	}
}
