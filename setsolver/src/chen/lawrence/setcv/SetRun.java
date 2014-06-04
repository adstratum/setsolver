/**
 * 
 */
package chen.lawrence.setcv;

import java.util.*;
import org.bytedeco.javacpp.opencv_core.*;
import org.bytedeco.javacv.*;

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
		SetCapture captureInstance = new SetCapture(1);
		captureInstance.run();
	}

}
