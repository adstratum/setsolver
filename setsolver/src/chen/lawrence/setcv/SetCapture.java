package chen.lawrence.setcv;

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
		
		//If running on Windows, use VideoInputFrameGrabber to get images;
		//otherwise, default to OpenCVFrameGrabber
		if (System.getProperty("os.name").indexOf("Win") >= 0) {
			grabber = new VideoInputFrameGrabber(cameraID);
		} else {
			grabber = new OpenCVFrameGrabber(cameraID);
		}
		
		try {
			grabber.start();
			
			while(canvasFrame.isEnabled()) {
				IplImage img = grabber.grab();
				String fpsString = new Double(grabber.getFrameRate()).toString();
				JLabel fpsLabel = new JLabel(fpsString);
				canvasFrame.setCanvasSize(grabber.getImageWidth(), grabber.getImageHeight()); 
				if (img != null && canvasFrame.isActive()) {
					segInstance.setImage(img);
					canvasFrame.add(fpsLabel);
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
