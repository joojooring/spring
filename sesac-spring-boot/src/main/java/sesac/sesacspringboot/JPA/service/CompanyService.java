package sesac.sesacspringboot.JPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import sesac.sesacspringboot.JPA.dto.CompanyDTO;
import sesac.sesacspringboot.JPA.entity.Company;
import sesac.sesacspringboot.JPA.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.List;

public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public List<CompanyDTO> getMemberAll(){
        List<Company> result = companyRepository.findAll();
        List<CompanyDTO> members = new ArrayList<>();

        for(Company member : result){
            CompanyDTO companyDTO = CompanyDTO.builder()
                    .name(member.getName())
                    .position(member.getPosition())
                    .number(member.getNumber())
                    .build();
            members.add(companyDTO);
        }
        return members;
    }
}
