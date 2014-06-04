package org.ars.start;

import org.ars.common.SpringUtils;
import org.ars.common.State;
import org.ars.common.StateContext;

/**
 * main class
 * @author Administrator
 *
 */
public class Ars extends StateContext {

	private static StateContext context;
	
	/**
	 * ars start-up
	 */
	public static synchronized void start() {
		if (context == null) {
			SpringUtils.build();
			context = SpringUtils.getBean("main");
			new Thread(context).start();
		}
		
	}
	
	/**
	 * transition state
	 * @param state
	 */
	public static void transition(State state) {
		context.setState(state);
	}

	@Override
	protected void init() {

	}
	
	/**
	 * ars exit
	 */
	public static synchronized void shutdown(){
		context.finish();
	}
	
	public static void main(String[] args) {
		Ars.start();
	}

}
