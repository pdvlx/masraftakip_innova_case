package com.innovacase.services;
import com.innovacase.models.Transaction;
import com.innovacase.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;


@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long transactionId) {
        try {
            return transactionRepository.findById(transactionId)
                    .orElseThrow(ChangeSetPersister.NotFoundException::new);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Transaction updateTransaction(Long transactionId, Transaction transactionDetails) {
        Transaction transaction = getTransactionById(transactionId);
        transaction.setAmount(transactionDetails.getAmount());
        // Diğer özellikleri de güncelleyebilirsiniz

        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long transactionId) {
        Transaction transaction = getTransactionById(transactionId);
        transactionRepository.delete(transaction);
    }
    public double getTotalTransactionByPerson(Long personId){
        List<Transaction> transactions = transactionRepository.findByPersonId(personId);
        double totalExpense = transactions.stream().mapToDouble(Transaction::getAmount).sum();
        return totalExpense;
    }
}
