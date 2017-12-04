package org.egateway.core.filter;

import org.egateway.core.ResponseWrapper;

/**
 * Filter all the response
 */
public interface ResponseFilter {
	/**
	 * @param request
	 * @return
	 */
	boolean shouldFilter(ResponseWrapper response);
	/**
	 *  do the filter process
	 */
	void filter();
	/**
	 * @return
	 */
	int getOrder();
	/**
	 * @param order
	 */
	void setOrder(int order);
}
