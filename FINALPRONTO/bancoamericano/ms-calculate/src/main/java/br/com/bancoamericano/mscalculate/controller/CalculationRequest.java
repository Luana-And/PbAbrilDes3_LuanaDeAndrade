package br.com.bancoamericano.mscalculate.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculationRequest {
    private String category;
    private int value;

    public CalculationRequest() {
    }
}
