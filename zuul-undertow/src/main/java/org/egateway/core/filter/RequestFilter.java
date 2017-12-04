package org.egateway.core.filter;

import org.egateway.core.RequestWrapper;

/**
 *  Filter all the request
 */
public interface RequestFilter {
	/**
	 * @param request
	 * @return
	 */
	boolean shouldFilter(RequestWrapper request);
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
