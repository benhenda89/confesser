package com.confesser.core.customer.message.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.springframework.stereotype.Service;

import com.confesser.core.customer.message.dao.CnfCustomerMessageDao;
import com.confesser.core.customer.message.domain.CnfCustomerMessage;

@Service("cnfCustomerMessageService")
public class CnfCustomerMessageServiceImpl implements CnfCustomerMessageService {

    private static final Log LOG = LogFactory.getLog(CnfCustomerMessageServiceImpl.class);

    @Resource(name = "cnfCustomerMessageDao")
    protected CnfCustomerMessageDao customerMessageDao;

    @Override
    public CnfCustomerMessage create() {
        return customerMessageDao.create();
    }

    @Override
    public CnfCustomerMessage save(final CnfCustomerMessage customerMessage) {
        return customerMessageDao.save(customerMessage);
    }

    @Override
    public void delete(final CnfCustomerMessage customerMessage) {
        customerMessageDao.delete(customerMessage);
    }

    @Override
    public List<CnfCustomerMessage> readCustomerMessage(final Customer customer, final int start, final int limit) {
        if (customer == null) {
            LOG.error("can not process to this service with a null customer");
            throw new NullPointerException("can not process to this service with a null customer");
        }
        final List<CnfCustomerMessage> messages = customerMessageDao.readCustomerMessage(customer.getId(), start, limit);
        return messages;

    }
}
