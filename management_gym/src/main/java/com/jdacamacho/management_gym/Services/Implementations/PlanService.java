package com.jdacamacho.management_gym.Services.Implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdacamacho.management_gym.Exceptions.OwnException.EntityNotFoundException;
import com.jdacamacho.management_gym.Exceptions.OwnException.NoDataException;
import com.jdacamacho.management_gym.Gateway.Interfaces.IPlanGateway;
import com.jdacamacho.management_gym.Services.DTO.PlanDTO;
import com.jdacamacho.management_gym.Services.Interfaces.IPlanService;

@Service
public class PlanService implements IPlanService {
    private final IPlanGateway gateway;

    public PlanService( IPlanGateway gateway){
        this.gateway = gateway;
    }

    @Override
    public List<PlanDTO> listPlan() {
        List<PlanDTO> plans = this.gateway.findAll();
        if(plans.isEmpty()){
            throw new NoDataException("There are no plans in the system");
        }
        return plans;
    }

    @Override
    public PlanDTO savePlan(PlanDTO plan) {
        PlanDTO planSaved = this.gateway.save(plan);
        return planSaved;
    }

    @Override
    public PlanDTO updatePlan(long idplan, PlanDTO plan) {
        PlanDTO oldPlan = null;
        if(!this.gateway.existsById(idplan)){
            throw new EntityNotFoundException("Plan was not found");
        }
        oldPlan = this.gateway.findById(idplan);
        oldPlan.update(plan);
        return this.gateway.save(oldPlan);
    }

    @Override
    public PlanDTO findPlanById(long idplan) {
        if(!this.gateway.existsById(idplan)){
            throw new EntityNotFoundException("Plan was not found");
        }
        return this.gateway.findById(idplan);
    }
    
}
