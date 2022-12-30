package core.kswelder.crud.service;

import core.kswelder.crud.enums.ClienteStatus;
import core.kswelder.crud.model.Cliente;
import core.kswelder.crud.model.ClienteDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private Map<Long, Cliente> map = new HashMap<>();

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
        ClienteDTO dto = new ClienteDTO();
        dto.setId(id);
        dto.setNome(cliente.getNome());
        dto.setDataNascimento(cliente.getDataNascimento());
        dto.setDataDeAtualizacao(new Date().toString());
        dto.setStatus(cliente.getStatus());

        //map.put(dto.getId(), dto);
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
        try {
            Thread.sleep(2000);
            map.remove(id);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        return "Cliente DELETADO!";
    }

}
