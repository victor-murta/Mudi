package br.com.alura.mvc.mudi.api;

import br.com.alura.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public Oferta criaOferta(RequisicaoNovaOferta requisicao){

        Optional<Pedido> pedido = pedidoRepository.findById(requisicao.findById(requisicao.getPedidoId()));

        if(!pedido.isPresent()){
            return null;
        }

        Oferta nova = requisicao.toOferta();
    }
}
