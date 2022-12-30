package core.kswelder.crud.utils;

import core.kswelder.crud.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface EnderecoRequest {

    @GetMapping(path = "/{cep}/json/")
    Endereco requestEndereco(@PathVariable(name = "cep") String cep);
}
