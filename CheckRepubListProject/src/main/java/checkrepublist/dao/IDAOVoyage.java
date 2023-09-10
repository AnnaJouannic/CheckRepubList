package checkrepublist.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import checkrepublist.model.Voyage;

public interface IDAOVoyage extends JpaRepository<Voyage, Integer> {

}
