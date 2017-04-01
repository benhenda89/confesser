package com.confesser.core.customer.message.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "CNF_CUSTOMER_MESSAGE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "blCustomerElements")
public class CnfCustomerMessageImpl implements CnfCustomerMessage {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CUSTOMER_MESSAGE_ID")
    protected Long id;

    @Column(name = "SUBMIT_DATE")
    protected Date createdDate;

    @Lob
    @Type(type = "org.hibernate.type.StringClobType")
    @Column(name = "MESSAGE", length = 2147483646)
    protected String message;

    @ManyToOne(cascade = {javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.MERGE }, targetEntity = CustomerImpl.class,
            optional = false)
    @JoinColumn(name = "CUSTOMER_SENDER")
    protected Customer customerSender;

    @ManyToOne(cascade = {javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.MERGE }, targetEntity = CustomerImpl.class,
            optional = false)
    @JoinColumn(name = "CUSTOMER_DESTINATION")
    protected Customer customerDestination;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long id) {
        this.id = id;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(final String message) {
        this.message = message;
    }

    @Override
    public Customer getCustomerSender() {
        return customerSender;
    }

    @Override
    public void setCustomerSender(final Customer customerSender) {
        this.customerSender = customerSender;
    }

    @Override
    public Customer getCustomerDestination() {
        return customerDestination;
    }

    @Override
    public void setCustomerDestination(final Customer customerDestination) {
        this.customerDestination = customerDestination;
    }

}
