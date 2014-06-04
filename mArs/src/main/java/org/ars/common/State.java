package org.ars.common;

/**
 * status abstract class(The state model)
 * @author Administrator
 *
 */
public abstract class  State {
	
	private State prev;

	public State getPrev() {
		return prev;
	}
	public void setPrev(State prev) {
		this.prev = prev;
	}
	
	/**
	 * state executive
	 */
	public abstract void execute();
}
