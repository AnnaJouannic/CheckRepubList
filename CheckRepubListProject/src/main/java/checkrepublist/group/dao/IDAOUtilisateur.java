package checkrepublist.group.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import checkrepublist.group.model.Utilisateur;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur,Integer>{
	public Optional<Utilisateur> findByUsername(String username);
	
	public Optional<Utilisateur> findByUsernameAndPassword(String username, String password);
	
	public boolean existsByUsername(String username);
}
