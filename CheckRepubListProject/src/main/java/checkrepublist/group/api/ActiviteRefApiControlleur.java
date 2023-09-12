package checkrepublist.group.api;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import checkrepublist.group.dao.IDAOActiviteRef;
import checkrepublist.group.dao.IDAOCritere;
import checkrepublist.group.model.ActiviteRef;
import checkrepublist.group.model.Critere;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/activiteref")
public class ActiviteRefApiControlleur {

	@Autowired
	IDAOActiviteRef repoActiviteRef;
	
	@Autowired
	IDAOCritere repoCritere;
	
	@GetMapping("")
	public List<ActiviteRef> findAll() {
		return this.repoActiviteRef.findAll();
	}
	
	@GetMapping("/{id}")
	public ActiviteRef findById(@PathVariable int id) {
		return repoActiviteRef.findById(id).get();
	}
	
	@PostMapping("")
	public ActiviteRef create(@Valid @RequestBody ActiviteRef activiteRef, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ActiviteRef invalide");
		}
		//Critere critere = (Critere) repoCritere.findAll();
		//activiteRef.setCritere(critere);
		activiteRef = repoActiviteRef.save(activiteRef);

		return activiteRef;
	}
	
	@PutMapping("/{id}")
	public ActiviteRef update(@RequestBody ActiviteRef activiteRef, @PathVariable int id) {
		activiteRef = repoActiviteRef.save(activiteRef);

		return activiteRef;
	}
	
	@PatchMapping("/{id}")
	public ActiviteRef partialEdit(@RequestBody Map<String, Object> fields, @PathVariable int id) {
		ActiviteRef activiteRef = this.repoActiviteRef.findById(id).get();
		
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(ActiviteRef.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, activiteRef, value);
		});
		
		ActiviteRef activiteRefReturn = repoActiviteRef.save(activiteRef);
		
		return activiteRefReturn;
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		if(!repoActiviteRef.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		repoActiviteRef.deleteById(id);
	}
}
