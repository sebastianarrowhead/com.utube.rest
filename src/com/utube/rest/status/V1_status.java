package com.utube.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


/**
 * This is the root path for our restful api service
 * In the web.xml file, we specified that /api/* need to be in the URL to
 * get to this class.
 * 
 * We version the class in the URL path.  This is the first version v1.
 * Example how to get to the root of this application programming interface resource:
 * http://localhost:7001/com.youtube.rest/api/v1/status
 * 
 * @author 308tube
 *
 */
@Path("/v1/status") //removed * wildcard to make this more compatible with tomcat
public class V1_status {

	private static final String api_version = "00.02.00"; //version of the api
	
	/**
	 * This method sits at the root of the api.  It will return the name
	 * of this api.
	 * 
	 * @return String - Title of the api
	 */
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle() {
		return "<p>Java WS from method = V1_status.returnTitle</p>";
	}
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion() {
		return "<p>API version </p>" + api_version;
	}

}
