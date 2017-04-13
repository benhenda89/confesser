package com.confesser.controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/message")
public class MessageController extends MessageAbstractController {

    @RequestMapping(method = RequestMethod.GET)
    public String getAllMessage(final HttpServletRequest request, final HttpServletResponse response, final Model model) {
        return super.getAllMessages(request, response, model);
    }

    // @RequestMapping(value = "/send", method = RequestMethod.POST)
    // public String sendMessage(final HttpServletRequest request, final HttpServletResponse response, final Model model) {
    // return super.getAllMessages(request, response, model);
    // }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String sendMessage(final HttpServletRequest request, final HttpServletResponse response, final Model model) {
        return super.getAllMessages(request, response, model);
    }

}
