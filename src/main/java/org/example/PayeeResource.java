package org.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/payees")
@Produces("application/json")
@Consumes("application/json")
public class PayeeResource {

    @Inject
    PayeeService payeeService;

    @POST
    public Response addPayee(Payee payee) {
        return Response.ok(payeeService.addPayee(payee)).status(201).build();
    }

    @PUT
    @Path("/{payeeId}")
    public Response updatePayee(@PathParam("payeeId") Long payeeId, Payee payee) {
        return Response.ok(payeeService.updatePayee(payeeId, payee)).build();
    }

    @DELETE
    @Path("/{payeeId}")
    public Response deletePayee(@PathParam("payeeId") Long payeeId) {
        payeeService.deletePayee(payeeId);
        return Response.noContent().build();
    }

    @GET
    @Path("/{payeeId}")
    public Response getPayeeById(@PathParam("payeeId") Long payeeId) {
        return payeeService.getPayeeById(payeeId)
                .map(payee -> Response.ok(payee).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}
