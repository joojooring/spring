package sesac.sesacspringboot.tripjavatest.repository;

import sesac.sesacspringboot.tripjavatest.entity.TouristEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepository extends JpaRepository<TouristEntity, Long> {

}
