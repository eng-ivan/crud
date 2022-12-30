package core.kswelder.crud.controller;

import core.kswelder.crud.model.Cliente;
import core.kswelder.crud.model.ClienteDTO;
import core.kswelder.crud.model.ConnectTest;
import core.kswelder.crud.model.Endereco;
import core.kswelder.crud.service.ClienteService;
import core.kswelder.crud.utils.EnderecoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    EnderecoRequest request;

    @PostMapping(path = "/cliente/save")
    public ResponseEntity<ClienteDTO> save(@RequestBody Cliente cliente) {
        ClienteDTO clientSaved = clienteService.save(cliente);
        Endereco endereco = request.requestEndereco(cliente.getEndereco());
        clientSaved.setEndereco(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
    }

    @GetMapping(path = "/cliente/list")
    public ResponseEntity<List<Cliente>> list(){
        List<Cliente> list = clienteService.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(path = "/cliente/list-ativo")
    public ResponseEntity<List<Cliente>> listAtivo(){
        List<Cliente> list = clienteService.listAtivo();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(path = "/cliente/find/{id}")
    public ResponseEntity<Cliente> findByID(@PathVariable("id") Long id){
        Cliente cliente = clienteService.findByID(id);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @PutMapping(path = "/cliente/update/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable("id") Long id, Cliente cliente){

        return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(id, cliente));
    }

    @DeleteMapping(path = "/cliente/delete/{id}")
    ResponseEntity<String> delete(@PathVariable("id")Long id){
        String response = clienteService.deleteByID(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente Deletado");
    }

    @GetMapping(path = "/test")
    public ResponseEntity<ConnectTest> testConnect() throws UnknownHostException {
        String uuid = UUID.randomUUID().toString();
        ConnectTest test = ConnectTest
                .builder()
                .address(InetAddress.getLocalHost())
                .keyConnection(uuid)
                .timestamp(new Date().toString())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(test);
    }
}
