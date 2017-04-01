package com.confesser.core.customer.message.dao;

import java.util.List;

import com.confesser.core.customer.message.domain.CnfCustomerMessage;

public interface CnfCustomerMessageDao {

    public CnfCustomerMessage create();

    public CnfCustomerMessage save(CnfCustomerMessage customerMessage);

    public void delete(CnfCustomerMessage customerMessage);

    public List<CnfCustomerMessage> readCustomerMessage(Long customerId, int start, int limit);

}
