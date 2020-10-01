package org.joparo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.stream.Collectors;

@Path("/hello")
public class HelloResource {

    int counter = 0;

    @Inject
    MyEntityCDIService cdiService;

    @Inject
    MyEntityService service;

    @Inject
    DependentScopedCDIService dependentScopedCdiService;

    @Inject
    ApplicationScopedCDIService appScopedCdiService;

    @Inject
    StatelessEEService statelessEEService;

    @Inject
    SingletonEEService singletonEEService;

    @Inject
    MyEntityRepository repo;

    @GET
    @Path("dep")
    @Produces("text/plain")
    public String dep() {
        System.out.println("Counter: " + counter);
        return "Id from me: " + (counter++) + ". Id from : " +
                dependentScopedCdiService.getClass().getName() +
                ":" + dependentScopedCdiService.getId();
    }

    @GET
    @Path("app")
    @Produces("text/plain")
    public String app() {
        return "Id from app scope CDI: " + appScopedCdiService.getId();
    }

    @GET
    @Path("stateless")
    @Produces("text/plain")
    public String stateless() {
        return "Id from stateless EE: ("+ statelessEEService.getClass().getName() + ") :" + statelessEEService.getId();
    }

    @GET
    @Path("singleton")
    @Produces("text/plain")
    public String singleton() {
        return "Id from singleton EE: " + singletonEEService.getId();
    }

    @GET
    @Path("insert")
    public String insert() {
        this.service.insert();
        return this.repo.findAll()
                .stream().map(MyEntity::getName).collect(Collectors.joining(","));
    }

    @GET
    @Path("get")
    public String get() {
        return this.repo.findAll()
                .stream().map(MyEntity::getName).collect(Collectors.joining(","));
    }

    @GET
    @Path("error")
    public String error() {
        this.service.insertManyWithRuntimeException();
        return "This transaction will be rolled backed...";
    }

    @GET
    @Path("exception")
    public String exception() {
        try {
            this.service.insertManyWithException();
        } catch (Exception e) {
            // Oops.
        }
        return "This transaction will not be rolled back";
    }

    @GET
    @Path("cdiinsert")
    public String cdiinsert() {
        this.cdiService.insertManyWithError();
        return "This transaction will not be rolled back...";
    }
}
