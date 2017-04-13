package com.confesser.core.customer.web.service;

import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.broadleafcommerce.common.util.BLCSystemProperty;
import org.springframework.stereotype.Service;

@Service("cnfMessageCriteriaService")
public class CnfMessageCriteriaServiceImpl implements CnfMessageCriteriaService {

    @Override
    public MessageCriteria buildMessageCriteria(final HttpServletRequest request) {
        final MessageCriteria messageCriteria = new MessageCriteria();

        for (final Map.Entry entry : request.getParameterMap().entrySet()) {
            final String key = (String) entry.getKey();
            if (Objects.equals(key, MessageCriteria.PAGE_NUMBER)) {
                messageCriteria.setPage(Integer.valueOf(Integer.parseInt(((String[]) entry.getValue())[0])));
            } else if (Objects.equals(key, MessageCriteria.PAGE_SIZE_STRING)) {
                final int requestedPageSize = Integer.parseInt(((String[]) entry.getValue())[0]);
                final int maxPageSize = getMaxPageSize();
                messageCriteria.setPageSize(Integer.valueOf(Math.min(requestedPageSize, maxPageSize)));
            } else {
                /* nothing */
            }
        }

        return messageCriteria;
    }

    protected int getMaxPageSize() {
        return BLCSystemProperty.resolveIntSystemProperty("message.web.maxPageSize");
    }

}
