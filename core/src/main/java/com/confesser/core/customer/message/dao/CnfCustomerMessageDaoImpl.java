package com.confesser.core.customer.message.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.springframework.stereotype.Repository;

import com.confesser.core.customer.message.domain.CnfCustomerMessage;

@Repository("cnfCustomerMessageDao")
public class CnfCustomerMessageDaoImpl implements CnfCustomerMessageDao {

    @PersistenceContext(unitName = "blPU")
    protected EntityManager em;

    @Resource(name = "blEntityConfiguration")
    protected EntityConfiguration entityConfiguration;

    @Override
    public CnfCustomerMessage create() {
        return (CnfCustomerMessage) this.entityConfiguration.createEntityInstance(CnfCustomerMessage.class.getName());
    }

    @Override
    public CnfCustomerMessage save(final CnfCustomerMessage customerMessage) {
        return em.merge(customerMessage);
    }

    @Override
    public void delete(final CnfCustomerMessage customerMessage) {
        em.remove(customerMessage);
    }

    @Override
    public List<CnfCustomerMessage> readCustomerMessage(final Long customerId, final int start, final int limit) {
        final TypedQuery<CnfCustomerMessage> query = em.createNamedQuery("CNF_READ_CUSTOMER_MESSAGE", CnfCustomerMessage.class);
        query.setParameter("customerId", customerId);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

}
