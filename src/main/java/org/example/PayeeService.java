package org.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
public class PayeeService {

    @Transactional
    public Payee addPayee(Payee payee) {
        payee.persist();
        return payee;
    }

    @Transactional
    public Payee updatePayee(Long payeeId, Payee updatedPayee) {
        Payee payee = Payee.findById(payeeId);
        if (payee == null) {
            throw new RuntimeException("Payee not found");
        }
        payee.payeeName = updatedPayee.payeeName;
        payee.accountNumber = updatedPayee.accountNumber;
        payee.address = updatedPayee.address;
        return payee;
    }

    @Transactional
    public void deletePayee(Long payeeId) {
        Payee.deleteById(payeeId);
    }

    public Optional<Payee> getPayeeById(Long payeeId) {
        return Payee.findByIdOptional(payeeId);
    }
}
