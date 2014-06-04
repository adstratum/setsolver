package chen.lawrence.setcv;

import java.util.concurrent.Callable;
import org.bytedeco.javacpp.opencv_imgproc;
import org.bytedeco.javacpp.opencv_core.*;

public class SetSegmentation implements Callable<IplImage> {
	
	private IplImage srcImg = new IplImage();
	
	public SetSegmentation() {
		
	}
	
	public SetSegmentation(IplImage image) {
		this.srcImg = image;
	}
	
	public IplImage call() {
		Mat srcMat = new Mat(srcImg);
		
		Mat cleanedMat = processMat(srcMat);
		
		segment(cleanedMat);
		return cleanedMat.asIplImage();
	}
	
	public Mat processMat(Mat srcMat) {
		Mat graySclMat = new Mat();
		Mat thresholdMat = new Mat();
		
		//convert to grayscale
		opencv_imgproc.cvtColor(srcMat, graySclMat, opencv_imgproc.CV_RGB2GRAY);
		
		//find edges and binarize
		opencv_imgproc.Canny(graySclMat, thresholdMat, 50, 100);
		return thresholdMat;
	}
	
	public void segment(Mat mat) {
		//Mat contourMat = opencv_imgproc.findContours(arg0, arg1, arg2, arg3);
	}
	
	public void setImage(IplImage image) {
		this.srcImg = image;
	}
	
	public IplImage getImage() {
		return srcImg;
	}
}
