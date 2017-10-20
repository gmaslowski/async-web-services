package com.gmaslowski.async.cxf;

import org.apache.cxf.annotations.UseAsyncMethod;
import org.apache.cxf.jaxws.ServerAsyncResponse;

import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@WebService(endpointInterface = "com.gmaslowski.async.cxf.Baeldung")
public class BaeldungImpl implements Baeldung {
    private int counter;

    @UseAsyncMethod
    public String hello(String name) {
            try {
                Thread.sleep(15000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello " + name + "!";
    }

    @Override
    public Future<?> helloAsync(String requestType, AsyncHandler<String> asyncHandler) {
        final ServerAsyncResponse<String> r = new ServerAsyncResponse<>();

        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(15000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r.set("Hello " + requestType + "!");
            asyncHandler.handleResponse(r);
        });

        return r;
    }

    @Override
    public Response<String> helloAsync(String requestType) {
        return null;
    }


    public String register(Student student) {
        counter++;
        return student.getName() + " is registered student number " + counter;
    }
}