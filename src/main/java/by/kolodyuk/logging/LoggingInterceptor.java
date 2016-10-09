package by.kolodyuk.logging;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import static by.kolodyuk.logging.LoggingUtil.REQUEST_MESSAGE_FORMAT;
import static by.kolodyuk.logging.LoggingUtil.RESPONSE_MESSAGE_FORMAT;
import static java.nio.charset.StandardCharsets.UTF_8;

public class LoggingInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingInterceptor.class);
    private static final AtomicLong ID = new AtomicLong();

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        long id = ID.incrementAndGet();

        LOGGER.debug(REQUEST_MESSAGE_FORMAT, id, request.getURI(), request.getMethod(), request.getHeaders().getContentType(),
                request.getHeaders(), new String(body, UTF_8));

        ClientHttpResponse response = execution.execute(request, body);

        LOGGER.debug(RESPONSE_MESSAGE_FORMAT, id, response.getStatusCode(), response.getHeaders().getContentType(),
                response.getHeaders(), IOUtils.toString(response.getBody(), UTF_8));

        return response;
    }
}