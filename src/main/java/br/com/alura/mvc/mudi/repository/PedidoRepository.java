package br.com.alura.mvc.mudi.repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long > {
    List<Pedido> findByStatus(StatusPedido aguardando);
    // <Sua entidade (Pedido) , seu tipo de id (Long)>
    //@PersistenceContext //configurando o EntityManager
    //private EntityManager entityManager;
    //JPA já sabe como usar o EntityManager

    //public List<Pedido> recuperaTodosOsPedidos(){
    //    Query query = entityManager.createQuery("select p from Pedido p", Pedido.class);
    //    return query.getResultList();
    //}

    //public List<Pedido> findAll();//JPA já entende que o find all é para encontrar todos | findAll == recuperaTodosOsPedidos
    //JPA jpa entende o findAll e nem precisa dele
}
