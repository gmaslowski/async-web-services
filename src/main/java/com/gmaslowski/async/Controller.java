package com.gmaslowski.async;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static com.gmaslowski.async.serviuce.LongRunningButActuallySleepingService.longRunning;

@RestController
public class Controller {

    @RequestMapping(value = "/future", method = RequestMethod.GET)
    @ResponseBody
    public Future<List<String>> getDriversWorker() {
        return new CompletableFuture<>().supplyAsync(() -> longRunning());
    }

    @RequestMapping(value = "/http", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getDriversHttp() {
        return longRunning();
    }

    @RequestMapping(value = "/callable", method = RequestMethod.GET)
    @ResponseBody
    public Callable<List<String>> getDriversCallable() {
        return () -> longRunning();
    }

}

