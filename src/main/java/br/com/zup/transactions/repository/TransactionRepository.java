package br.com.zup.transactions.repository;

import br.com.zup.transactions.model.Card;
import br.com.zup.transactions.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    boolean existsByExternalId(UUID externalId);

    List<Transaction> findTop10ByCardOrderByActivateAt(Card card);

}
