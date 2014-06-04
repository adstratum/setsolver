package chen.lawrence.setcv;

import java.util.concurrent.Callable;
import org.bytedeco.javacpp.opencv_imgproc;
import org.bytedeco.javacpp.opencv_core.*;

public class SetSegmentation implements Callable<IplImage> {
	
	private IplImage srcImg = new IplImage();
	private Mat srcMat;
	private Mat graySclMat = new Mat();
	private Mat thresholdMat = new Mat();
	
	private static final int BLOCK_SIZE = 11;
	private static final int C = 10;
	
	public SetSegmentation() {
		
	}
	
	public SetSegmentation(IplImage image) {
		this.srcImg = image;
	}
	
	public IplImage call() {
		srcMat = new Mat(srcImg);
		//convert to grayscale
		opencv_imgproc.cvtColor(srcMat, graySclMat, opencv_imgproc.CV_RGB2GRAY);
		
		//binarize this sucker
		//consult docs.opencv.org/modules/imgproc/doc/miscellaneous_transformations to define this monstrosity
		opencv_imgproc.adaptiveThreshold(graySclMat, thresholdMat, 255, opencv_imgproc.ADAPTIVE_THRESH_MEAN_C, opencv_imgproc.THRESH_BINARY_INV, BLOCK_SIZE, C);
		
		segment(thresholdMat);
		return thresholdMat.asIplImage();
	}
	
	public void segment(Mat mat) {
		
	}
	
	public void setImage(IplImage image) {
		this.srcImg = image;
	}
	
	public IplImage getImage() {
		return srcImg;
	}
}
