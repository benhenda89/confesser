package com.confesser.controller.message;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.broadleafcommerce.common.web.controller.BroadleafAbstractController;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.web.core.CustomerState;
import org.springframework.ui.Model;

import com.confesser.core.customer.message.domain.CnfCustomerMessage;
import com.confesser.core.customer.message.service.CnfCustomerMessageService;
import com.confesser.core.customer.web.service.CnfMessageCriteriaService;
import com.confesser.core.customer.web.service.MessageCriteria;

public class MessageAbstractController extends BroadleafAbstractController {

    protected static String messageView = "message/message";
    protected static String loginView = "authentication/login";

    public static String CUSTOMER_MESSAGE = "customermessages";

    @Resource(name = "cnfCustomerMessageService")
    protected CnfCustomerMessageService messageService;

    @Resource(name = "cnfMessageCriteriaService")
    protected CnfMessageCriteriaService criteriaService;

    public String getAllMessages(final HttpServletRequest request, final HttpServletResponse response, final Model model) {
        final Customer customer = CustomerState.getCustomer();
        if (customer != null && customer.isLoggedIn()) {
            final MessageCriteria criteria = criteriaService.buildMessageCriteria(request);
            final List<CnfCustomerMessage> messages = messageService.readCustomerMessage(customer, criteria);
            model.addAttribute(CUSTOMER_MESSAGE, messages);
            return messageView;
        }
        /* redirect to login view */
        return loginView;
    }

    protected String getMessageView() {
        return messageView;
    }
}
