package br.com.bancoamericano.mscalculate.service;

import br.com.bancoamericano.mscalculate.model.Rule;
import br.com.bancoamericano.mscalculate.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RuleService {
    private final RuleRepository ruleRepository;

    @Autowired
    public RuleService(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public Rule createRule(Rule rule) {
        return ruleRepository.save(rule);
    }

    public List<Rule> getAllRules() {
        return ruleRepository.findAll();
    }

    public Optional<Rule> getRule(Long id) {
        return ruleRepository.findById(id);
    }

    public Rule updateRule(Long id, Rule rule) {
        rule.setId(id);
        return ruleRepository.save(rule);
    }

    public void deleteRule(Long id) {
        ruleRepository.deleteById(id);
    }

    public int calculatePoints(String category, int value) {
        Rule rule = ruleRepository.findByCategory(category);
        return (rule != null) ? rule.getParity() * value : value;
    }
}

