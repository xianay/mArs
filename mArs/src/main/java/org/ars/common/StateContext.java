package org.ars.common;

/**
 * status transition context class (The state model)
 * @author Administrator
 *
 */
public abstract class StateContext implements Runnable{
	
	private boolean flag;
	private State state;
	
	/**
	 * get the current state
	 * @return
	 */
	public State getState() {
		return state;
	}
	
	/**
	 * set the current state
	 * @param state
	 */
	public void setState(State state) {
		this.state = state;
	}
	
	/**
	 * Terminate the thread
	 */
	public void finish(){
		flag = true;
	}
	
	/**
	 * initialization status transition context
	 */
	protected abstract void init();


	public void run() {
		init();
		while(!flag){
			if(state!=null){
				state.execute();
			}else{
				System.err.println("δ֪��״̬ת��������");
			}
		}
	}
	
	

}
