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

import checkrepublist.group.api.request.CritereRequest;
import checkrepublist.group.api.response.CritereResponse;
import checkrepublist.group.dao.IDAOCritere;
import checkrepublist.group.dao.IDAOMaterielRef;
import checkrepublist.group.exception.CritereNotFoundException;
import checkrepublist.group.exception.CritereNotValidException;
import checkrepublist.group.exception.MaterielRefNotFoundException;
import checkrepublist.group.model.Critere;
import checkrepublist.group.model.MaterielRef;
import checkrepublist.group.model.TypeClimat;
import checkrepublist.group.model.TypeDeplacement;
import checkrepublist.group.model.TypeLogement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/critere")
@CrossOrigin("*")
public class CritereApiController {

	@Autowired
	IDAOCritere repoCritere;
	
	@Autowired
	IDAOMaterielRef repoMaterielRef;
	
	
	@GetMapping("")
	@JsonView(Views.Critere.class)
	public List<Critere> findAll() {
		return this.repoCritere.findAll();
	}
	
	
	@GetMapping("/{id}")
	public CritereResponse findById(@PathVariable Integer id) {
		Critere critere = this.repoCritere.findById(id).orElseThrow(CritereNotFoundException::new);
		CritereResponse response = new CritereResponse();
		
		
		BeanUtils.copyProperties(critere, response);
	
		response.setIdMaterielref(critere.getMaterielref().getId());
		return CritereResponse.convert(critere);
	}
	
	@PostMapping("")
	public CritereResponse add(@Valid @RequestBody CritereRequest critereRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new CritereNotValidException();
		}
		
		Critere critere = new Critere();
		
		
		if (critereRequest.getLogement() != null) {
			critere.setLogement(TypeLogement.valueOf(critereRequest.getLogement()));;
		}
		if (critereRequest.getDeplacement() != null) {
			critere.setDeplacement(TypeDeplacement.valueOf(critereRequest.getDeplacement()));;
		}
		if (critereRequest.getClimat() != null) {
			critere.setClimat(TypeClimat.valueOf(critereRequest.getClimat()));;
		}
		
		Integer id_mat = critereRequest.getIdMaterielref();
		if (id_mat != null) {
			MaterielRef mat = this.repoMaterielRef.findById(id_mat).orElseThrow(MaterielRefNotFoundException::new);
			critere.setMaterielref(mat);
		}
		
		this.repoCritere.save(critere);
		return CritereResponse.convert(critere);
	}
	
	@PutMapping("/{id}")
	public CritereResponse edit(@PathVariable Integer id, @Valid @RequestBody CritereRequest critereRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new CritereNotValidException();
		}

		Critere critere = this.repoCritere.findById(id).orElseThrow(CritereNotFoundException::new);
		
		BeanUtils.copyProperties(critereRequest, critere);
		System.out.println(critere.getMaterielref());
		if (critereRequest.getLogement() != null) {
			critere.setLogement(TypeLogement.valueOf(critereRequest.getLogement()));;
		}
		if (critereRequest.getDeplacement() != null) {
			critere.setDeplacement(TypeDeplacement.valueOf(critereRequest.getDeplacement()));;
		}
		if (critereRequest.getClimat() != null) {
			critere.setClimat(TypeClimat.valueOf(critereRequest.getClimat()));;
		}
		
		this.repoCritere.save(critere);
		
		return CritereResponse.convert(critere);
	}
	

	
	@DeleteMapping("/{id}")
	@JsonView(Views.Critere.class)
	public void deleteById(@PathVariable Integer id) {
		this.repoCritere.deleteById(id);
	}
}
