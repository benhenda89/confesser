package com.confesser.core.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "CNF_CUSTOMER")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "blCustomerElements")
public class CnfCustomerImpl extends CustomerImpl implements CnfCustomer {

    private static final long serialVersionUID = 1L;

    @Lob
    @Type(type = "org.hibernate.type.StringClobType")
    @Column(name = "TEXT_HOME", length = 2147483646)
    protected String customerTextHome;

    @Override
    public String getCustomerTextHome() {
        return customerTextHome;
    }

    @Override
    public void setCustomerTextHome(final String customerTextHome) {
        this.customerTextHome = customerTextHome;
    }

}
