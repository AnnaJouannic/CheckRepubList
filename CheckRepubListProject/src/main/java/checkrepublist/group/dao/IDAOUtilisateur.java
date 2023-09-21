package checkrepublist.group.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import checkrepublist.group.model.Utilisateur;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur,Integer>{
	
	public Optional<Utilisateur> findByLoginAndPassword(String login, String password);

}
