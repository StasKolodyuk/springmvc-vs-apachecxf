package by.kolodyuk.logging;

import static java.lang.System.lineSeparator;

public class LoggingUtil {

    private static final String DASHES = "--------------------------------------" + lineSeparator();
    private static final String ID_FORMAT = "ID: {}" + lineSeparator();
    private static final String URL_FORMAT = "URL: {}" + lineSeparator();
    private static final String HTTP_METHOD_FORMAT = "Http Method: {}" + lineSeparator();
    private static final String CONTENT_TYPE_FORMAT = "Content-Type: {}" + lineSeparator();
    private static final String HEADERS_FORMAT = "Headers: {}" + lineSeparator();
    private static final String STATUS_CODE_FORMAT = "Status Code: {}" + lineSeparator();
    private static final String BODY_FORMAT = "Body: {}" + lineSeparator();

    static final String REQUEST_MESSAGE_FORMAT = lineSeparator() +
                                                 DASHES +
                                                 ID_FORMAT +
                                                 URL_FORMAT +
                                                 HTTP_METHOD_FORMAT +
                                                 CONTENT_TYPE_FORMAT +
                                                 HEADERS_FORMAT +
                                                 BODY_FORMAT +
                                                 DASHES;
    static final String RESPONSE_MESSAGE_FORMAT = lineSeparator() +
                                                  DASHES +
                                                  ID_FORMAT +
                                                  STATUS_CODE_FORMAT +
                                                  CONTENT_TYPE_FORMAT +
                                                  HEADERS_FORMAT +
                                                  BODY_FORMAT +
                                                  DASHES;
}
