package checkrepublist.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import checkrepublist.model.Compte;

public interface IDAOCompte extends JpaRepository<Compte,Integer>{

}
