package core.kswelder.crud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

@SuperBuilder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco implements Serializable {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
