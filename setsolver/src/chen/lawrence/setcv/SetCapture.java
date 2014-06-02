package chen.lawrence.setcv;

import org.bytedeco.javacpp.opencv_core.*;
import org.bytedeco.javacv.*;

public class SetCapture implements Runnable{
	
	CanvasFrame canvasFrame = new CanvasFrame("qwop");
	long GRAB_INTERVAL = 1000;
	
	public SetCapture() {
		canvasFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
	}
	
	public void run() {
		FrameGrabber grabber = new OpenCVFrameGrabber(0);
		try {
			grabber.start();
			IplImage img;
			img = grabber.grab();
			if (img != null) {
				canvasFrame.showImage(img);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the gRAB_INTERVAL
	 */
	public long getUpdateInterval() {
		return GRAB_INTERVAL;
	}

	/**
	 * @param gRAB_INTERVAL the gRAB_INTERVAL to set
	 */
	public void setUpdateInterval(long interval) {
		GRAB_INTERVAL = interval;
	}

}
