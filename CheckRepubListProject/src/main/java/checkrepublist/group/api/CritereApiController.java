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

import checkrepublist.group.dao.IDAOCritere;
import checkrepublist.group.model.Critere;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/critere")
public class CritereApiController {

	@Autowired
	IDAOCritere repoCritere;
	
	
	@GetMapping("")
	public List<Critere> findAll() {
		return this.repoCritere.findAll();
	}
	
	@GetMapping("/{id}")
	public Critere findById(@PathVariable int id) {
		return repoCritere.findById(id).get();
	}
	
	@PostMapping("")
	public Critere create(@Valid @RequestBody Critere critere, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Critere invalide");
		}
		
		critere = repoCritere.save(critere);

		return critere;
	}
	
	@PutMapping("/{id}")
	public Critere update(@RequestBody Critere critere, @PathVariable int id) {
		critere = repoCritere.save(critere);

		return critere;
	}
	
	@PatchMapping("/{id}")
	public Critere partialEdit(@RequestBody Map<String, Object> fields, @PathVariable int id) {
		Critere critere = this.repoCritere.findById(id).get();
		
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Critere.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, critere, value);
		});
		
		Critere critereReturn = repoCritere.save(critere);
		
		return critereReturn;
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		if(!repoCritere.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		repoCritere.deleteById(id);
	}
}
