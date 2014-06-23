package com.springjerseydemo.rest;

import com.springjerseydemo.model.Demo;
import com.springjerseydemo.service.DemoService;
import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.Descriptions;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/demos")
public class DemoResource {

	@Autowired
	private DemoService demoService;
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
    @Descriptions({
            @Description(value = "Returns random Demo object", target = DocTarget.METHOD),
            @Description(value = "Requested Demo object", target = DocTarget.RETURN),
            @Description(value = "Request", target = DocTarget.REQUEST),
            @Description(value = "Response", target = DocTarget.RESPONSE),
            @Description(value = "Resource", target = DocTarget.RESOURCE)
    })
	public Response loadDemos()
	{
		Demo demo = demoService.loadRandom();
		return Response.ok(demo).status(200).build();
	}
		
}
