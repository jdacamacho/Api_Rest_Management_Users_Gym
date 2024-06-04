package com.jdacamacho.management_gym.Services.Interfaces;

import java.util.List;

import com.jdacamacho.management_gym.Services.DTO.PlanDTO;

public interface IPlanService {
    public List<PlanDTO> listPlan();
    public PlanDTO savePlan(PlanDTO plan);
    public PlanDTO updatePlan(long idplan,PlanDTO plan);
    public PlanDTO findPlanById(long idplan);
}
