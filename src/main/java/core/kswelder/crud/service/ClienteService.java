package core.kswelder.crud.service;

import core.kswelder.crud.enums.ClienteStatus;
import core.kswelder.crud.model.Cliente;
import core.kswelder.crud.model.ClienteDTO;
import core.kswelder.crud.model.Endereco;
import core.kswelder.crud.utils.EnderecoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    EnderecoRequest request;
    private static Map<Long, Cliente> map = new HashMap<>();

    public ClienteDTO save(Cliente cliente){
        Long incrementID = map.keySet().size() + 1L;
        cliente.setId(incrementID);
        cliente.setDataCriacao(new Date().toString());
        cliente.setDataDeAtualizacao(new Date().toString());
        map.put(incrementID, cliente);
        ClienteDTO dto = new ClienteDTO(cliente);
        return dto;
    }

    public ClienteDTO update(Long id, Cliente cliente){
        Endereco endereco = request.requestEndereco(cliente.getEndereco());
        ClienteDTO dto = new ClienteDTO();
        dto.setId(id);
        dto.setNome(cliente.getNome());
        dto.setDataNascimento(cliente.getDataNascimento());
        dto.setDataDeAtualizacao(new Date().toString());
        dto.setStatus(cliente.getStatus());
        dto.setEndereco(endereco);
        map.put(id,cliente);
        return dto;
    }

    public Cliente findByID(Long id){
        Cliente cliente = map.get(id);
        return cliente;
    }

    public List<Cliente> listAll(){
        return new ArrayList<>(map
                .values()
                .stream()
                .collect(Collectors.toList()));
    }

    public List<Cliente> listAtivo(){
        return new ArrayList<>(map
                .values()
                .stream()
                .filter(c -> c.getStatus().equals("ATIVO"))
                .collect(Collectors.toList()));
    }

    public String deleteByID(Long id){
        map.remove(id);
        return "Cliente DELETADO!";
    }

}
