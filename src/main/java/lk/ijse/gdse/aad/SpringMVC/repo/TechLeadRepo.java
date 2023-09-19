package lk.ijse.gdse.aad.SpringMVC.repo;


import lk.ijse.gdse.aad.SpringMVC.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechLeadRepo extends JpaRepository<TechLead,String> {
    TechLead getTechLeadsById(String id);
}
