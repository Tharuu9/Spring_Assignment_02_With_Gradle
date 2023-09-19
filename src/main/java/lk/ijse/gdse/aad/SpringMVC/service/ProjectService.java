package lk.ijse.gdse.aad.SpringMVC.service;

import lk.ijse.gdse.aad.SpringMVC.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    public void saveProject(ProjectDTO dto);

    public void deleteProject(String id);

    public void updateProject(ProjectDTO dto);

    public ProjectDTO searchProject(String id);

    public List<ProjectDTO> getAllProject();

}
