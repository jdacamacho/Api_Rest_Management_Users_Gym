package com.jdacamacho.management_gym.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jdacamacho.management_gym.Models.PlanEntity;

@Repository
public interface PlanRepository extends CrudRepository<PlanEntity,Long>{
    
}
