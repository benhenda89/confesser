package com.confesser.core.customer.web.service;

import javax.servlet.http.HttpServletRequest;

public interface CnfMessageCriteriaService {

    public MessageCriteria buildMessageCriteria(HttpServletRequest paramHttpServletRequest);
}
