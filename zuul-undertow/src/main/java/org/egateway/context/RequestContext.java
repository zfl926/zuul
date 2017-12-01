package org.egateway.context;

public class RequestContext {

    protected static final ThreadLocal<RequestContext> threadLocal = new ThreadLocal<RequestContext>() {
        @Override
        protected RequestContext initialValue() {
            try {
                return RequestContext.class.newInstance();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    };
    
    
	/**
	 * @return
	 */
	public static RequestContext getCurrentContext(){
		return threadLocal.get();
	}
	
	/**
	 *  remove the context from thread local
	 */
	public void unAttached(){
		threadLocal.remove();
	}
	
	
}
