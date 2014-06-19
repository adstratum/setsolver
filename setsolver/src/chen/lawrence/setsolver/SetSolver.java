/**
 * 
 */
package chen.lawrence.setsolver;

import chen.lawrence.setcv.SetCapture;

/**
 * Main entry point for SetSolver program.
 * 
 * @author lawrence
 *
 */
public class SetSolver {

	/**
	 * 
	 */
	public SetSolver() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO interactive camera selection
		SetCapture captureInstance = new SetCapture(0);
		captureInstance.run();
		
	}

}
