package org.egateway.core.configure;

public interface Configure<T> {
	/**
	 * @param file
	 */
	void load(String file);
	/**
	 * @param name
	 * @return
	 */
	<C> C getProperty(String name, Class<C> clazz);
	/**
	 * @return
	 */
	T getProperties();
}
