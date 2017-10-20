package com.gmaslowski.async.cxf;

import com.gmaslowski.async.serviuce.LongRunningButActuallySleepingService;
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
        return LongRunningButActuallySleepingService.longRunning(name);
    }

    @Override
    public Future<?> helloAsync(String requestType, AsyncHandler<String> asyncHandler) {
        final ServerAsyncResponse<String> r = new ServerAsyncResponse<>();

        CompletableFuture.runAsync(() -> {
            String retVal = LongRunningButActuallySleepingService.longRunning(requestType);
            r.set(retVal);
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