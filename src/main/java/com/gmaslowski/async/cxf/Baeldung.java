package com.gmaslowski.async.cxf;

import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.util.concurrent.Future;

@WebService
public interface Baeldung {
    String hello(String name);

    public Future<?> helloAsync(String requestType, AsyncHandler<String> asyncHandler);

    public Response<String> helloAsync(String requestType);

    String register(Student student);
}