package com.confesser.core.customer.web.service;

import org.broadleafcommerce.common.util.BLCSystemProperty;

public class MessageCriteria {

    public static String PAGE_SIZE_STRING = "pageSize";
    public static String PAGE_NUMBER = "page";

    protected Integer page;
    protected Integer pageSize = BLCSystemProperty.resolveIntSystemProperty("message.web.maxPageSize");

    public MessageCriteria() {
        this.page = Integer.valueOf(1);
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(final Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
    }

}
