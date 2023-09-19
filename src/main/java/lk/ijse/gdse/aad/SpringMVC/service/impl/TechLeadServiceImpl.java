package lk.ijse.gdse.aad.SpringMVC.service.impl;

import lk.ijse.gdse.aad.SpringMVC.dto.TechLeadDTO;
import lk.ijse.gdse.aad.SpringMVC.entity.TechLead;
import lk.ijse.gdse.aad.SpringMVC.repo.TechLeadRepo;
import lk.ijse.gdse.aad.SpringMVC.service.TechLeadService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class TechLeadServiceImpl implements TechLeadService {

    @Autowired
    private TechLeadRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveTechLead(TechLeadDTO dto) {
        if (!repo.existsById(dto.getTLId())){
            repo.save( mapper.map(dto, TechLead.class));
        }else {
            throw new RuntimeException("Customer Already Exist...!");
        }
    }

    @Override
    public void deleteTechLead(String id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
        }else {
            throw new RuntimeException("Customer Already Exist...!");
        }
    }

    @Override
    public void updateTechLead(TechLeadDTO dto) {
        if (repo.existsById(dto.getTLId())) {
            repo.save(mapper.map(dto,TechLead.class));
        }else {
            throw new RuntimeException("Customer NOT Exist...!");
        }
    }

    @Override
    public TechLeadDTO searchTechLead(String id) {
        if (repo.existsById(id)){
            TechLead techLead = repo.findById(id).get();
            return mapper.map(techLead,TechLeadDTO.class);
        }else {
            throw new RuntimeException("Customer NOT Exist...!");
        }
    }

    @Override
    public List<TechLeadDTO> getAllTechLead() {
        List<TechLead> all = repo.findAll();
        return mapper.map(all,new TypeToken<List<TechLeadDTO>>(){}.getType());
    }
}
