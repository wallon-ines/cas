package org.apereo.cas.support.saml.web;

import org.apereo.cas.ticket.proxy.ProxyHandler;
import org.apereo.cas.validation.ValidationSpecification;
import org.apereo.cas.web.AbstractServiceValidateController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The {@link SamlValidateController} is responsible for
 * validating requests based on the saml1 protocol.
 *
 * @author Misagh Moayyed
 * @since 4.2
 */
@RefreshScope
@Component("samlValidateController")
@Controller
public class SamlValidateController extends AbstractServiceValidateController {

    /**
     * Handle model and view.
     *
     * @param request the request
     * @param response the response
     * @return the model and view
     * @throws Exception the exception
     */
    @RequestMapping(path="/samlValidate", method = RequestMethod.POST)
    @Override
    protected ModelAndView handleRequestInternal(final HttpServletRequest request, final HttpServletResponse response)
            throws Exception {
        return super.handleRequestInternal(request, response);
    }

    @Override
    @Autowired
    @Scope("prototype")
    public void setValidationSpecification(
            @Qualifier("cas20WithoutProxyProtocolValidationSpecification")
            final ValidationSpecification validationSpecification) {
        super.setValidationSpecification(validationSpecification);
    }

    @Override
    @Autowired
    public void setFailureView(@Value("casSamlServiceFailureView") final String failureView) {
        super.setFailureView(failureView);
    }

    @Override
    @Autowired
    public void setSuccessView(@Value("casSamlServiceSuccessView") final String successView) {
        super.setSuccessView(successView);
    }

    @Override
    @Autowired
    public void setProxyHandler(@Qualifier("proxy20Handler") final ProxyHandler proxyHandler) {
        super.setProxyHandler(proxyHandler);
    }

}
