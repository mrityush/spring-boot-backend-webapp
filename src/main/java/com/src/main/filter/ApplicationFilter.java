package com.src.main.filter;

import com.src.main.constants.ApplicationConstant;
import com.src.main.constants.URLConstants;
import com.src.main.dao.interfaces.users.UserAuthorityDao;
import com.src.main.domains.users.User;
import com.src.main.domains.users.UserAuthority;
import com.src.main.exceptions.classes.InvalidUserException;
import com.src.main.filter.wrapper.HeaderMapRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(2)
@EnableTransactionManagement

public class ApplicationFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(ApplicationFilter.class);

    @Autowired
    private UserAuthorityDao userAuthorityDao;


    @Override
    public void destroy() {
    }

    @Override
    @Transactional
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HeaderMapRequestWrapper headerWrapper = null;
        String url = "";
        User user;

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (!httpRequest.getRequestURI().endsWith(URLConstants.DUMMY + "/test")) {
//        if (!httpRequest.getRequestURI().endsWith("/heartbeat")) {
            try {
                url = httpRequest.getHeader("remote-host");

                String authToken = httpRequest.getHeader(ApplicationConstant.X_AUTH_TOKEN);
                UserAuthority userAuthority = userAuthorityDao.findByAuthToken(authToken);
                if (userAuthority != null) {
                    user = userAuthority.getUser();
                } else {
                    throw new InvalidUserException("User not authenticated");
                }
                headerWrapper = new HeaderMapRequestWrapper(httpRequest);
                headerWrapper.addHeader("userId", String.valueOf(user.getId()));
                chain.doFilter(headerWrapper, response);
            } catch (Exception ex) {
                throw new IOException(ex.getMessage());
            }
        } else {
            chain.doFilter(request, response);
        }
        //TODO:Remove when use above code.
        //chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

}
