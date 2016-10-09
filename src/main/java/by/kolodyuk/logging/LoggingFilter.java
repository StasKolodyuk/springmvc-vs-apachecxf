package by.kolodyuk.logging;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;


import static by.kolodyuk.logging.LoggingUtil.*;
import static java.nio.charset.StandardCharsets.UTF_8;

@Component
public class LoggingFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);
    private static final AtomicLong ID = new AtomicLong();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        long id = ID.incrementAndGet();

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        LOGGER.debug(REQUEST_MESSAGE_FORMAT, id, requestWrapper.getRequestURI(), requestWrapper.getMethod(), requestWrapper.getContentType(),
                new ServletServerHttpRequest(requestWrapper).getHeaders(), IOUtils.toString(requestWrapper.getInputStream(), UTF_8));

        filterChain.doFilter(requestWrapper, responseWrapper);

        LOGGER.debug(RESPONSE_MESSAGE_FORMAT, id, responseWrapper.getStatus(), responseWrapper.getContentType(),
                new ServletServerHttpResponse(responseWrapper).getHeaders(), IOUtils.toString(responseWrapper.getContentInputStream(), UTF_8));

        responseWrapper.copyBodyToResponse();
    }
}
