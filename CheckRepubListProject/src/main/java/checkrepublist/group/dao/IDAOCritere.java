package checkrepublist.group.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import checkrepublist.group.model.Critere;
import checkrepublist.group.model.TypeClimat;
import checkrepublist.group.model.TypeDeplacement;
import checkrepublist.group.model.TypeLogement;

public interface IDAOCritere  extends JpaRepository<Critere, Integer>  {
	
	@Query("select c from Critere c"
			+ "where (c.logement = TypeLogement.TOUS and c.deplacement is null and c.climat is null)"
			+ "or (c.logement = ?1 or c.deplacement = ?2 or c.climat = ?3)"
			+ "or (c.logement = ?1 and c.deplacement = ?2 and c.climat = ?3)"
			+ "or (c.logement = ?1 and c.deplacement = ?2) "
			+ "or (c.logement = ?1 and c.climat = ?3)"
			+ "or (c.deplacement = ?2 and c.climat = ?3)")
	List<Critere> findAllTest(TypeLogement logement, TypeDeplacement deplacement, TypeClimat climat);
}
