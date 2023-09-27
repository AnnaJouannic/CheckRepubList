package checkrepublist.group.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import checkrepublist.group.model.MaterielRef;

public interface IDAOMaterielRef extends JpaRepository<MaterielRef, Integer> {
	//@Query("select distinct id from MaterielRef m where m.id = ?1")
	//Optional<MaterielRef> findById(Integer id);
	
}
