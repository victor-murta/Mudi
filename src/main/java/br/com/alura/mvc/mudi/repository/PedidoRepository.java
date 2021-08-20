package br.com.alura.mvc.mudi.repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long > {

    @Cacheable("books")
    List<Pedido> findByStatus(StatusPedido aguardando, Pageable sort);

    @Query(" select p from Pedido p join p.user u where u.username = :username")
    List<Pedido> findAllByUsuario(@Param("username") String username);

    @Query("select  p from Pedido p join p.user u where u.username = :username and p.status = :status")
    List<Pedido> findByStatusEUsuario(StatusPedido status, @Param("username")String username);

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
