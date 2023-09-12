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
import checkrepublist.group.dao.IDAOMaterielRef;
import checkrepublist.group.model.Critere;
import checkrepublist.group.model.MaterielRef;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/materielref")
public class MaterielRefApiControlleur {

	@Autowired
	IDAOMaterielRef repoMaterielRef;
	
	@Autowired
	IDAOCritere repoCritere;
	
	@GetMapping("")
	public List<MaterielRef> findAll() {
		return this.repoMaterielRef.findAll();
	}
	
	@GetMapping("/{id}")
	public MaterielRef findById(@PathVariable int id) {
		return repoMaterielRef.findById(id).get();
	}
	
	@PostMapping("")
	public MaterielRef create(@Valid @RequestBody MaterielRef materielRef, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "MaterielRef invalide");
		}
		//Critere critere = (Critere) repoCritere.findAll();
		//materielRef.setCritere(critere);
		materielRef = repoMaterielRef.save(materielRef);

		return materielRef;
	}
	
	@PutMapping("/{id}")
	public MaterielRef update(@RequestBody MaterielRef materielRef, @PathVariable int id) {
		materielRef = repoMaterielRef.save(materielRef);

		return materielRef;
	}
	
	@PatchMapping("/{id}")
	public MaterielRef partialEdit(@RequestBody Map<String, Object> fields, @PathVariable int id) {
		MaterielRef materielRef = this.repoMaterielRef.findById(id).get();
		
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(MaterielRef.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, materielRef, value);
		});
		
		MaterielRef materielRefReturn = repoMaterielRef.save(materielRef);
		
		return materielRefReturn;
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		if(!repoMaterielRef.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		repoMaterielRef.deleteById(id);
	}
}
