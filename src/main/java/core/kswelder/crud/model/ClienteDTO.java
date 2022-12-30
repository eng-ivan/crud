package core.kswelder.crud.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.concurrent.atomic.AtomicLong;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClienteDTO {

    private Long id;
    private String nome;
    private String dataNascimento;
    private String dataCriacao;
    private String dataDeAtualizacao;
    private String status;
    private Endereco endereco;

    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.dataNascimento = cliente.getDataNascimento();
        this.dataCriacao = cliente.getDataCriacao();
        this.dataDeAtualizacao = cliente.getDataDeAtualizacao();
        this.status = cliente.getStatus();
    }
}
