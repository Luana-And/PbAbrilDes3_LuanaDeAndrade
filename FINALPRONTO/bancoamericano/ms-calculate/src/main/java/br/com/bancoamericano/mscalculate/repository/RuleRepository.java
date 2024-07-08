package br.com.bancoamericano.mscalculate.repository;

import br.com.bancoamericano.mscalculate.model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<Rule, Long> {
    Rule findByCategory(String category);
}


