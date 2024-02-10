package sesac.sesacspringboot.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sesac.sesacspringboot.JPA.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
