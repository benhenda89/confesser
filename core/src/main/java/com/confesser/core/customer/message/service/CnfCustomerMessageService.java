package com.confesser.core.customer.message.service;

import java.util.List;

import org.broadleafcommerce.profile.core.domain.Customer;

import com.confesser.core.customer.message.domain.CnfCustomerMessage;

public interface CnfCustomerMessageService {

    public CnfCustomerMessage create();

    public CnfCustomerMessage save(CnfCustomerMessage customerMessage);

    public void delete(CnfCustomerMessage customerMessage);

    public List<CnfCustomerMessage> readCustomerMessage(Customer customerId, int start, int limit);
}
