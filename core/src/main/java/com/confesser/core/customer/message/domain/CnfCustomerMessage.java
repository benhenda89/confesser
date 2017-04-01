package com.confesser.core.customer.message.domain;

import java.io.Serializable;
import java.util.Date;

import org.broadleafcommerce.profile.core.domain.Customer;

/**
 * customer message entity
 * 
 * @author hafedh
 */

public interface CnfCustomerMessage extends Serializable {

    public Long getId();

    public void setId(Long id);

    public Date getCreatedDate();

    public void setCreatedDate(Date createdDate);

    public String getMessage();

    public void setMessage(String message);

    public Customer getCustomerDestination();

    public void setCustomerDestination(Customer customerDestination);

    public Customer getCustomerSender();

    public void setCustomerSender(Customer customerSender);

}
