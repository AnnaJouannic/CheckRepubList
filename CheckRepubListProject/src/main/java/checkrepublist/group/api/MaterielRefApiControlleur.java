package checkrepublist.group.api;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
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
import checkrepublist.group.exception.CritereNotValidException;
import checkrepublist.group.exception.CritereRefNotFoundException;
import checkrepublist.group.exception.MaterielRefNotFoundException;
import checkrepublist.group.exception.MaterielRefNotValidException;
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
	

	@GetMapping("/{id}")
	public MaterielRefResponse findById(@PathVariable Integer id) {
		MaterielRef materielRef = this.repoMaterielRef.findById(id).orElseThrow(MaterielRefNotFoundException::new);
		MaterielRefResponse response = new MaterielRefResponse();
		
		BeanUtils.copyProperties(materielRef, response);
		
		return response;
	}
	
	@PostMapping("")
	public MaterielRef add(@Valid @RequestBody MaterielRefRequest materielRefRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new MaterielRefNotValidException();
		}
		
		MaterielRef materielRef = new MaterielRef();
		
		BeanUtils.copyProperties(materielRefRequest, materielRef);
		

		return this.repoMaterielRef.save(materielRef);
	}
	
	@PutMapping("/{id}")
	public MaterielRef edit(@PathVariable Integer id, @Valid @RequestBody MaterielRefRequest materielRefRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new MaterielRefNotValidException();
		}

		MaterielRef materielRef = new MaterielRef();
		
		BeanUtils.copyProperties(materielRefRequest, materielRef);
		

		return this.repoMaterielRef.save(materielRef);
	}
	

	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
		this.repoMaterielRef.deleteById(id);
	}
}

