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

import checkrepublist.group.api.request.MaterielRefRequest;
import checkrepublist.group.api.response.MaterielRefResponse;
import checkrepublist.group.dao.IDAOCritere;
import checkrepublist.group.dao.IDAOMaterielRef;
import checkrepublist.group.exception.MaterielRefNotFoundException;
import checkrepublist.group.exception.MaterielRefNotValidException;
import checkrepublist.group.model.Categorie;
import checkrepublist.group.model.Critere;
import checkrepublist.group.model.MaterielRef;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/materielref")
@CrossOrigin("*")
public class MaterielRefApiControlleur {

	@Autowired
	IDAOMaterielRef repoMaterielRef;
	
	@Autowired
	IDAOCritere repoCritere;
	
	@GetMapping
	@JsonView(Views.MaterielRef.class)
	public List<MaterielRef> findAll() {
		return this.repoMaterielRef.findAll();
	}

	@GetMapping("/{id}")
	@Transactional
	public MaterielRefResponse findById(@PathVariable Integer id) {
		MaterielRef materielRef = this.repoMaterielRef.findById(id).orElseThrow(MaterielRefNotFoundException::new);
		MaterielRefResponse response = new MaterielRefResponse();
		
		BeanUtils.copyProperties(materielRef, response);
		if (materielRef.getCategorie() != null) {
			response.setCategorie(materielRef.getCategorie().name());
		}
		
		List<Integer> id_criteres=new ArrayList<>();
		List<Critere> obj_criteres = materielRef.getCriteres();
		for( Critere critere : obj_criteres) {
			id_criteres.add(critere.getId());
		}
		response.setIdCriteres(id_criteres);
		
		
		return response;
	}
	
	@PostMapping("")
	public MaterielRefResponse add(@Valid @RequestBody MaterielRefRequest materielRefRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new MaterielRefNotValidException();
		}
		
		MaterielRef materielRef = new MaterielRef();
		
		BeanUtils.copyProperties(materielRefRequest, materielRef);
		if (materielRefRequest.getCategorie() != null) {
			materielRef.setCategorie(Categorie.valueOf(materielRefRequest.getCategorie()));;
		}
		
		this.repoMaterielRef.save(materielRef);

		return MaterielRefResponse.convertCritere(materielRef);
	}
	
	@PutMapping("/{id}")
	public MaterielRefResponse edit(@PathVariable Integer id, @Valid @RequestBody MaterielRefRequest materielRefRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new MaterielRefNotValidException();
		}

		MaterielRef materielRef = this.repoMaterielRef.findById(id).orElseThrow(MaterielRefNotFoundException::new);
		
		BeanUtils.copyProperties(materielRefRequest, materielRef);
		
		if (materielRefRequest.getCategorie() != null) {
			materielRef.setCategorie(Categorie.valueOf(materielRefRequest.getCategorie()));;
		}
		
	
		this.repoMaterielRef.save(materielRef);

		return MaterielRefResponse.convertCritere(materielRef);
	}
	

	
	@DeleteMapping("/{id}")
	@JsonView(Views.MaterielRef.class)
	public void deleteById(@PathVariable Integer id) {
		this.repoMaterielRef.deleteById(id);
	}
}

