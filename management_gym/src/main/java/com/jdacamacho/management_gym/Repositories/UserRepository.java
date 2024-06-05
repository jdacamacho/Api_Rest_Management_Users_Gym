package com.jdacamacho.management_gym.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jdacamacho.management_gym.Models.PlanEntity;
import com.jdacamacho.management_gym.Models.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long>{
    @Query("from PlanEntity")
    List<PlanEntity> findAllPlans();
}
