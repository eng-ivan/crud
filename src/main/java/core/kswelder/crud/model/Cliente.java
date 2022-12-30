package core.kswelder.crud.model;

import core.kswelder.crud.enums.ClienteStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente implements Serializable {

    private Long id;
    private String nome;
    private String dataNascimento;
    private String dataCriacao;
    private String dataDeAtualizacao;
    private String status;
    private String endereco;
}
