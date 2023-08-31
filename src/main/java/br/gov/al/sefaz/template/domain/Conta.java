package br.gov.al.sefaz.template.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "STR_CONTA", schema = "ADMSTR001")
public class Conta {

    @Id
    @Column(name = "SEQ_CONTA")
    private Long sequencialConta;

    @Column(name = "VAL_SALDO")
    private BigDecimal saldo;

    public Long getSequencialConta() {
        return sequencialConta;
    }

    public void setSequencialConta(Long sequencialConta) {
        this.sequencialConta = sequencialConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

}
