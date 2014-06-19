package chen.lawrence.setcv;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.helper.opencv_highgui;
import org.bytedeco.javacpp.opencv_core.*;
import org.bytedeco.javacv.*;

import java.awt.Frame;
import java.awt.event.*;

import javax.swing.*;

/**
 * Handles the webcam feed for SetSolver.
 * 
 * @author Lawrence
 *
 */
public class SetCapture implements Runnable{
	//TODO documentation
	SetSegmentation segInstance = new SetSegmentation();
	CanvasFrame canvasFrame = new CanvasFrame("SetSolver");
	FrameGrabber grabber;
	int cameraID = 0;
	
	public SetCapture() {
		setupClose();
	}
	
	public SetCapture(int camera) {
		setupClose();
		cameraID = camera;
	}
	
	@Override
	public void run() {
		try {
			
			//If running on Windows, use VideoInputFrameGrabber to get images;
			//otherwise, default to OpenCVFrameGrabber
			if (System.getProperty("os.name").indexOf("Win") >= 0) {
				grabber = new VideoInputFrameGrabber(cameraID);
			} else {
				grabber = new OpenCVFrameGrabber(cameraID);
			}
			
			grabber.start();
			IplImage img;
			while(canvasFrame.isEnabled()) {
				img = grabber.grab();
				canvasFrame.setCanvasSize(grabber.getImageWidth(), grabber.getImageHeight()); 
				if (img != null && canvasFrame.isActive()) {
					segInstance.setImage(img);
					canvasFrame.showImage(segInstance.call());
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setupClose() {
		canvasFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
    @Override
    public String toString(){
        return new Integer(this.cameraID).toString();
    }
}
