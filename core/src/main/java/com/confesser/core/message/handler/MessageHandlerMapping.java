package com.confesser.core.message.handler;

import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.broadleafcommerce.common.web.BLCAbstractHandlerMapping;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.service.CustomerService;

/**
 * Message Handler Mapping.
 * 
 * @author hafedh
 */
public class MessageHandlerMapping extends BLCAbstractHandlerMapping {

    @Resource(name = "blCustomerService")
    protected CustomerService customerService;

    @Override
    protected Object getHandlerInternal(final HttpServletRequest httpServletRequest) throws Exception {
        final String subdomain = httpServletRequest.getServerName().split("\\.")[0];
        final BroadleafRequestContext context = BroadleafRequestContext.getBroadleafRequestContext();
        final Customer customer = customerService.readCustomerByUsername(subdomain);
        if ((context != null) && (context.getRequestURIWithoutContext() != null)) {
            if (Objects.nonNull(customer)) {
                context.getRequest().setAttribute("CNF_CUSTOMER", customer);
                return "cnfCustomerController";
            }
        }

        return null;
    }

}
