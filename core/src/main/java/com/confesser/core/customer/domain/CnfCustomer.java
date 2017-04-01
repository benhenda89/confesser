package com.confesser.core.customer.domain;

import org.broadleafcommerce.profile.core.domain.Customer;

public interface CnfCustomer extends Customer {

    public String getCustomerTextHome();

    public void setCustomerTextHome(String customerTextHome);

}
