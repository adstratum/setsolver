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
		grabber = new OpenCVFrameGrabber(cameraID);
		try {
			grabber.start();
			IplImage img;
			while(canvasFrame.isActive() && canvasFrame != null) {
				img = grabber.grab();
				canvasFrame.setCanvasSize(grabber.getImageWidth(), grabber.getImageHeight()); 
				if (img != null) {
					segInstance.setImage(img);
					canvasFrame.showImage(segInstance.call());
				}

			}
			System.out.println("qwop");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setupClose() {
		canvasFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		canvasFrame.addWindowListener(new GrabberListener());
	}
	
    @Override
    public String toString(){
        return new Integer(this.cameraID).toString();
    }
    
    /**
     * Action listener that handles window closing, thread
     * safety be damned.
     * 
     * @author Lawrence
     *
     */
    private class GrabberListener implements WindowListener {
    	
    	@Override
    	public void windowClosing(WindowEvent arg0) {
    		if (grabber != null) {
    			try {
    				// Grabber must *always* be released first, otherwise
    				// SetRun will never terminate
					grabber.release();
					canvasFrame.dispose();
				} catch (Exception exc) {
					// TODO Auto-generated catch block
					exc.printStackTrace();
				}
    		}
    	}

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
    }
}
