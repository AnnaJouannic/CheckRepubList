package checkrepublist.group.api;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import checkrepublist.group.api.response.UtilisateurResponse;
import checkrepublist.group.dao.IDAOUtilisateur;
import checkrepublist.group.model.Utilisateur;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurApiControlleur {
	@Autowired
	private IDAOUtilisateur daoUtilisateur;
	
	@GetMapping
	public List<Utilisateur> findAll() {
		return this.daoUtilisateur.findAll();
		
		//.stream();
		
		//.map(UtilisateurResponse::convert);
		
		//.toList();
		
	}
	
	@GetMapping("/old")
	public List<UtilisateurResponse> findAllOld() {
		
		List<UtilisateurResponse> response = new ArrayList<>();
		List<Utilisateur> utilisateurs = this.daoUtilisateur.findAll();
		
		for (Utilisateur utilisateur : utilisateurs) {
			
			//response.add(UtilisateurResponse.convert(utilisateur));
		}
		return response;
	}
	
	/*
	public UtilisateurResponse inscription(@Valid @RequestBody InscriptionRequest inscriptionRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new InscriptionNotValidException();
		}
		
		/*if (inscriptionRequest.getPassword().equals(inscriptionRequest.getPasswordVerif()) == false) {
			throw new InscriptionNotValidException();
		}
		
		Utilisateur utilisateur = new Utilisateur();
		
		BeanUtils.copyProperties(inscriptionRequest, utilisateur);
		
		this.daoUtilisateur.save(utilisateur);
		
		//return UtilisateurResponse.convert(utilisateur);
	}*/
}
