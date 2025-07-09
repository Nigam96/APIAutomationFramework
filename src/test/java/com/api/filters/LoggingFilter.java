package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {

	private static final Logger getLogger = LogManager.getLogger(LoggingFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response=ctx.next(requestSpec, responseSpec);
		logResponse(response);
		return response;
	}

	public void logRequest(FilterableRequestSpecification requestSpec) {
		getLogger.info(requestSpec.getBaseUri());
		getLogger.info("Request Payload"+requestSpec.getBody());
		getLogger.info(requestSpec.getHeaders());
	}

	public void logResponse(Response response) {
		getLogger.info(response.getStatusCode());
		getLogger.info("Response Payload"+response.getBody());
		getLogger.info(response.getHeaders());
	}

}
