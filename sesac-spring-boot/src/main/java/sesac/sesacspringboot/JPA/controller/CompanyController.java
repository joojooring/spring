package sesac.sesacspringboot.JPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sesac.sesacspringboot.JPA.dto.CompanyDTO;
import sesac.sesacspringboot.JPA.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("/all")
    public List<CompanyDTO> getAll(){
        List<CompanyDTO> result = companyService.getMemberAll();
        return result;
    }
}
