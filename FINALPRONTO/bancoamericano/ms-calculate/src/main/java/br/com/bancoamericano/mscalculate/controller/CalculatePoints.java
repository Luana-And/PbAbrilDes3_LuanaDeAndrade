package br.com.bancoamericano.mscalculate.controller;

import br.com.bancoamericano.mscalculate.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class CalculatePoints {
    private final RuleService ruleService;

    @Autowired
    public CalculatePoints(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<Integer> calculatePoints(@RequestBody CalculationRequest request) {
        int points = ruleService.calculatePoints(request.getCategory(), request.getValue());
        return ResponseEntity.ok(points);
    }
}
