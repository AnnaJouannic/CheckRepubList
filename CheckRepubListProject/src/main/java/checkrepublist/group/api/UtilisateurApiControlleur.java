package checkrepublist.group.api;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import checkrepublist.group.api.request.ConnexionRequest;
import checkrepublist.group.api.request.InscriptionRequest;
import checkrepublist.group.api.response.ConnexionResponse;
import checkrepublist.group.api.response.UtilisateurResponse;
import checkrepublist.group.dao.IDAOUtilisateur;
import checkrepublist.group.exception.InscriptionNotValidException;
import checkrepublist.group.exception.UtilisateurNotFoundException;
import checkrepublist.group.model.Utilisateur;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/utilisateur")
@CrossOrigin("*")
public class UtilisateurApiControlleur {
	@Autowired
	private IDAOUtilisateur repoUtilisateur;
	
	@Autowired 
	//private AuthenticationManager authenticationManager;
	
	
	@GetMapping
	public List<Utilisateur> findAll() {
		return this.repoUtilisateur.findAll();
	}
	
	@PostMapping
	public UtilisateurResponse inscription(@Valid @RequestBody InscriptionRequest inscriptionRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new InscriptionNotValidException();
		}
		
		if (inscriptionRequest.getPassword().equals(inscriptionRequest.getPasswordVerif()) == false) {
			throw new InscriptionNotValidException();
		}
		
		Utilisateur utilisateur = new Utilisateur();
		
		BeanUtils.copyProperties(inscriptionRequest, utilisateur);
		
		
		this.repoUtilisateur.save(utilisateur);
		
		return (UtilisateurResponse) repoUtilisateur.findAll();
	}
	
	@PostMapping("/connexion")
	public ConnexionResponse connexion(@RequestBody ConnexionRequest connexionRequest) {
		// On va demander à SPRING SECURITY de vérifier le username / password
		// On a besoin d'un AuthenticationManager
		// On utilisera la méthode authenticate, qui attend un Authentication
		// Et on utilisera le type UsernamePasswordAuthenticationToken pour donner le username & le password
		//Authentication authentication =
				//new UsernamePasswordAuthenticationToken(connexionRequest.getLogin(), connexionRequest.getPassword());
		
		// On demande à SPRING SECURITY de vérifier ces informations de connexion
		//this.authenticationManager.authenticate(authentication);
		
		// Si on arrive ici, c'est que la connexion a fonctionné
		ConnexionResponse response = new ConnexionResponse();
		
		// On génère un jeton pour l'utilisateur connecté
		//String token = JwtUtil.generate(authentication);
		
		response.setSuccess(true);
		//response.setToken(token); // On donne le jeton en réponse
		
		return response;
	}
	
	@PostMapping("/authentification")
	public Utilisateur authentification(@RequestBody ConnexionRequest connexionRequest) {
		return this.repoUtilisateur.findByLoginAndPassword(connexionRequest.getLogin(), connexionRequest.getPassword()).orElseThrow(UtilisateurNotFoundException::new);
	}
	
}
