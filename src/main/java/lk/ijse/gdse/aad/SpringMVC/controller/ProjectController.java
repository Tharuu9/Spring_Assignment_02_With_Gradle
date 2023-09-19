package lk.ijse.gdse.aad.SpringMVC.controller;

import lk.ijse.gdse.aad.SpringMVC.dto.ProjectDTO;
import lk.ijse.gdse.aad.SpringMVC.service.ProjectService;
import lk.ijse.gdse.aad.SpringMVC.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers(){
        return new ResponseUtil(200,"OK",projectService.getAllProject());
    }

    @ResponseStatus(HttpStatus.CREATED)//201

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@RequestBody ProjectDTO dto){
        System.out.println(dto.toString());
        projectService.saveProject(dto);
        return new ResponseUtil(200,"Saved..!",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody ProjectDTO dto){
        projectService.updateProject(dto);
        return new ResponseUtil(200,"Updated..!",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String id){
        projectService.deleteProject(id);
        return new ResponseUtil(200,"Deleted..!",null);
    }

    @GetMapping(path = "/id",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String id){
        return new ResponseUtil(200,"OK",projectService.searchProject(id));
    }
}
