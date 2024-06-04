package com.jdacamacho.management_gym.Gateway.Interfaces;

import java.util.List;

import com.jdacamacho.management_gym.Services.DTO.PlanDTO;

public interface IPlanGateway {
    public List<PlanDTO> findAll();
    public PlanDTO save(PlanDTO plan);
    public PlanDTO findById(long idPlan);
    public boolean existsById(long idPlan);
}
