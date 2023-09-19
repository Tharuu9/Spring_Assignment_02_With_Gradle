package lk.ijse.gdse.aad.SpringMVC.repo;


import lk.ijse.gdse.aad.SpringMVC.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, String> {
}
