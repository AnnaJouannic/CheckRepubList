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

import com.fasterxml.jackson.annotation.JsonView;

import checkrepublist.group.api.request.CritereRequest;
import checkrepublist.group.api.response.CritereResponse;
import checkrepublist.group.dao.IDAOCritere;
import checkrepublist.group.exception.CritereNotFoundException;
import checkrepublist.group.exception.CritereNotValidException;
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
	public CritereResponse findById(@PathVariable Integer id) {
		Critere critere = this.repoCritere.findById(id).orElseThrow(CritereNotFoundException::new);
		CritereResponse response = new CritereResponse();
		
		BeanUtils.copyProperties(critere, response);
		
		response.setMaterielref(critere.getMaterielref());
		
		return response;
	}
	
	@PostMapping("")
	public Critere add(@Valid @RequestBody CritereRequest critereRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new CritereNotValidException();
		}
		
		Critere critere = new Critere();
		
		BeanUtils.copyProperties(critereRequest, critere);
		
		critere.setMaterielref(critereRequest.getMaterielref());
		
		return this.repoCritere.save(critere);
	}
	
	@PutMapping("/{id}")
	public Critere edit(@PathVariable Integer id, @Valid @RequestBody CritereRequest critereRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new CritereNotValidException();
		}

		Critere critere = this.repoCritere.findById(id).orElseThrow(CritereNotFoundException::new);
		
		BeanUtils.copyProperties(critereRequest, critere);
		
		return this.repoCritere.save(critere);
	}
	

	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
		this.repoCritere.deleteById(id);
	}
}
