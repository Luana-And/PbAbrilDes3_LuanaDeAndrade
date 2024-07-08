package br.com.bancoamericano.mscalculate.controller;

import br.com.bancoamericano.mscalculate.model.Rule;
import br.com.bancoamericano.mscalculate.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class CalculateController {
    private final RuleService ruleService;

    @Autowired
    public CalculateController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping("/rules")
    public ResponseEntity<Rule> createRule(@Validated @RequestBody Rule rule) {
        return ResponseEntity.ok(ruleService.createRule(rule));
    }

    @GetMapping("/rules")
    public ResponseEntity<List<Rule>> getAllRules() {
        return ResponseEntity.ok(ruleService.getAllRules());
    }

    @GetMapping("/rules/{id}")
    public ResponseEntity<Rule> getRule(@PathVariable Long id) {
        Optional<Rule> rule = ruleService.getRule(id);
        return rule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/rules/{id}")
    public ResponseEntity<Rule> updateRule(@PathVariable Long id, @Validated @RequestBody Rule rule) {
        return ResponseEntity.ok(ruleService.updateRule(id, rule));
    }

    @DeleteMapping("/rules/{id}")
    public ResponseEntity<Void> deleteRule(@PathVariable Long id) {
        ruleService.deleteRule(id);
        return ResponseEntity.noContent().build();
    }
}
