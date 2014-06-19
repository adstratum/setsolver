/**
 * 
 */
package chen.lawrence.setcv;

/**
 * @author lawrence
 *
 */
public class SetRun {

	/**
	 * 
	 */
	public SetRun() {
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
