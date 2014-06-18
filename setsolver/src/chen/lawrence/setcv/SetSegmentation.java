package chen.lawrence.setcv;

import java.util.concurrent.Callable;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.MatVector;
import org.bytedeco.javacpp.opencv_imgproc;

//TODO documentation
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
		
		//convert colorspace of final Mat from grayscale to RGB
		Mat cleanedRGBMat = new Mat();
		opencv_imgproc.cvtColor(cleanedMat, cleanedRGBMat, opencv_imgproc.CV_GRAY2RGB);
		return overlay(srcMat, cleanedRGBMat).asIplImage();
	}
	
	/**
	 * Binarizes image before segmentation using Canny
	 * edge detection.
	 * 
	 * @param srcMat
	 * @return
	 */
	public Mat processMat(Mat srcMat) {
		Mat graySclMat = new Mat();
		Mat thresholdMat = new Mat();
		
		//convert to grayscale
		opencv_imgproc.cvtColor(srcMat, graySclMat, opencv_imgproc.CV_RGB2GRAY);
		
		//find edges and binarize
		opencv_imgproc.Canny(graySclMat, thresholdMat, 50, 100);
		return thresholdMat;
	}
	
	public Mat overlay(Mat mat0, Mat mat1) {
		Mat out = null;
		out = new Mat();
		opencv_core.addWeighted(mat0, 0.3, mat1, 0.7, 10, out);
		return out;
	}
	
	/**
	 * Segments the image into areas with the largest size.
	 * 
	 * @param mat0
	 */
	public void segment(Mat mat0) {
		MatVector contourArray = new MatVector();
		opencv_imgproc.findContours(mat0, contourArray, opencv_imgproc.CV_RETR_TREE, opencv_imgproc.CV_CHAIN_APPROX_SIMPLE);
		for (int i = 0; i < contourArray.size(); i++) {
			Mat tempMat = new Mat();
			tempMat = contourArray.get(i);
			opencv_imgproc.contourArea(tempMat);
		}
	}

	public void setImage(IplImage image) {
		this.srcImg = image;
	}
	
	public IplImage getImage() {
		return srcImg;
	}
}
