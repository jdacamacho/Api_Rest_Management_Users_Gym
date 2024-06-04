package com.jdacamacho.management_gym.Gateway.Implementations;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.jdacamacho.management_gym.Gateway.Interfaces.IPlanGateway;
import com.jdacamacho.management_gym.Models.PlanEntity;
import com.jdacamacho.management_gym.Repositories.PlanRepository;
import com.jdacamacho.management_gym.Services.DTO.PlanDTO;

@Service
public class PlanGateway implements IPlanGateway{
    private final PlanRepository repository;
    private final ModelMapper mapper;

    public PlanGateway(PlanRepository repository, ModelMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PlanDTO> findAll() {
        Iterable<PlanEntity> data = this.repository.findAll();
        List<PlanDTO> response = this.mapper.map(data, new TypeToken<List<PlanDTO>>(){}.getType());
        return response;
    }

    @Override
    public PlanDTO save(PlanDTO plan) {
        PlanEntity planToSave = this.mapper.map(plan, PlanEntity.class);
        PlanEntity planSaved = this.repository.save(planToSave);
        PlanDTO response = this.mapper.map(planSaved, PlanDTO.class);
        return response;
    }

    @Override
    public PlanDTO findById(long idPlan) {
        PlanEntity data = this.repository.findById(idPlan).get();
        PlanDTO response = this.mapper.map(data, PlanDTO.class);
        return response;
    }

    @Override
    public boolean existsById(long idPlan) {
        return this.repository.existsById(idPlan);
    }
}
