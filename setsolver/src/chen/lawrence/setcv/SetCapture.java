package chen.lawrence.setcv;

import org.bytedeco.javacpp.opencv_core.*;
import org.bytedeco.javacv.*;

/**
 * Handles the webcam feed for SetSolver.
 * 
 * @author Lawrence
 *
 */
public class SetCapture implements Runnable{
	
	SetSegmentation segInstance = new SetSegmentation();
	CanvasFrame canvasFrame = new CanvasFrame("SetSolver");
	int cameraID = 0;
	
	public SetCapture() {
		canvasFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
	}
	
	public SetCapture(int camera) {
		canvasFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		cameraID = camera;
	}
	
	@Override
	public void run() {
		FrameGrabber grabber = new OpenCVFrameGrabber(cameraID);
		try {
			grabber.start();
			IplImage img;
			while(true) {
				img = grabber.grab();
				if (img != null) {
					segInstance.setImage(img);
					canvasFrame.showImage(segInstance.call());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    @Override
    public String toString(){
        return new Integer(this.cameraID).toString();
    }


}
