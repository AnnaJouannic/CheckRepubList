package checkrepublist.group.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import checkrepublist.group.model.Utilisateur;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur,Integer>{

}
