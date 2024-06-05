package com.jdacamacho.management_gym.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdacamacho.management_gym.Services.DTO.PlanDTO;
import com.jdacamacho.management_gym.Services.Interfaces.IPlanService;

@RestController
@RequestMapping("/api/plans")
public class PlanRestController {
    @Autowired
    private IPlanService planService;

    @GetMapping("")
    public ResponseEntity<List<PlanDTO>> index(){
        List<PlanDTO> plans = this.planService.listPlan();
        ResponseEntity<List<PlanDTO>> objResponse = new ResponseEntity<List<PlanDTO>>(plans,HttpStatus.OK);
        return objResponse;
    }

    @GetMapping("/{idPlan}")
    public ResponseEntity<PlanDTO> get(@PathVariable long idPlan){
        PlanDTO plan = this.planService.findPlanById(idPlan);
        ResponseEntity<PlanDTO> objResponse = new ResponseEntity<PlanDTO>(plan,HttpStatus.OK);
        return objResponse;
    }

    @PostMapping("")
    public ResponseEntity<PlanDTO> save(@RequestBody PlanDTO request){
        PlanDTO plan = this.planService.savePlan(request);
        ResponseEntity<PlanDTO> objResponse = new ResponseEntity<PlanDTO>(plan,HttpStatus.CREATED);
        return objResponse;
    }

    @PutMapping("/{idPlan}")
    public ResponseEntity<PlanDTO> update(@PathVariable long idPlan ,@RequestBody PlanDTO request){
        PlanDTO plan = this.planService.updatePlan(idPlan, request);
        ResponseEntity<PlanDTO> objResponse = new ResponseEntity<PlanDTO>(plan,HttpStatus.OK);
        return objResponse;
    }

}
