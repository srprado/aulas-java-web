
package modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OperacoesConta {
    private LocalDateTime data;
    private BigDecimal valor;
    private String tipo;

    public OperacoesConta(BigDecimal valor, String tipo) {
        this.data = LocalDateTime.now();
        this.valor = valor;
        this.tipo = tipo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }   
}
