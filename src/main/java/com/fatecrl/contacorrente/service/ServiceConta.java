package com.fatecrl.contacorrente.service;

import java.util.ArrayList;
import java.util.List;

import com.fatecrl.contacorrente.model.Conta;

public class ServiceConta {
    private static List<Conta> contas = new ArrayList<Conta>();

    public ServiceConta(){
        ContaFake();
    }

    private void ContaFake(){
        Conta conta = new Conta();
        conta.setAgencia(1234);
        conta.setId(1L);
        conta.setNumero("1234");
        conta.setSaldo(1000.00);
        conta.setTitular("Marina Camaño");
        contas.add(conta);
    }

    public List<Conta> findAll(){
        return contas;
    }

    public Conta find(Conta conta){
        return contas.stream()
                            .filter(c -> c.equals(conta))
                            .findFirst().orElse(null);
    }

    public Conta find(Long id){
        return find(new Conta(id));
    }

    public void Create(Conta conta){
        Long newId = (long) (contas.size() + 1);
        conta.setId(newId);
        contas.add(conta);
    }
}
