package com.innovacase.controllers;

import com.innovacase.models.Transaction;
import com.innovacase.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public Transaction createTransaction( @RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable(value = "id") Long transactionId) {
        return transactionService.getTransactionById(transactionId);
    }

    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable(value = "id") Long transactionId, @RequestBody Transaction transactionDetails) {
        return transactionService.updateTransaction(transactionId, transactionDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable(value = "id") Long transactionId) {
        transactionService.deleteTransaction(transactionId);
        return ResponseEntity.ok().build();
    }
}
