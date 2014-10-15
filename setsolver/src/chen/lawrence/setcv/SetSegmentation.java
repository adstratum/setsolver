package chen.lawrence.setcv;

import java.util.concurrent.Callable;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.Size;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.MatVector;
import org.bytedeco.javacpp.opencv_imgproc;

//TODO documentation
public class SetSegmentation implements Callable<IplImage> {
	
	//gaussian blur constants
	private static final Size KERNEL_SIZE = new Size(3,3);
	private static final int SIGMA = 1;
	
	//thresholding constants; see opencv docs for more info
	private static final double THRESHOLD_VALUE = 150;
	private static final double MAX_VALUE = 255;
	private static final int THRESHOLD_TYPE = opencv_imgproc.THRESH_TOZERO + opencv_imgproc.THRESH_OTSU;
	private static final int ADAPTIVE_TYPE = opencv_imgproc.ADAPTIVE_THRESH_GAUSSIAN_C;
	private static final int THRESHOLD_ADAPTIVE_TYPE = opencv_imgproc.CV_THRESH_BINARY;
	private static final int BLOCK_SIZE = 3;
	private static final double THRESHOLD_CONSTANT = 3.5;
	
	private IplImage srcImg = new IplImage();
	
	public SetSegmentation() {
		
	}
	
	public SetSegmentation(IplImage image) {
		this.srcImg = image;
	}
	
	public IplImage call() {
		Mat srcMat = new Mat(srcImg);
		
		//binarize image
		Mat cleanedMat = processMat(srcMat);
		
		//find largest areas in image
		segment(cleanedMat);
		
		//convert colorspace of final Mat from grayscale to RGB
		Mat segmentedRGBMat = new Mat();
		opencv_imgproc.cvtColor(cleanedMat, segmentedRGBMat, opencv_imgproc.CV_GRAY2RGB);
		
		//return contours overlaid onto original image 
		//return overlay(srcMat, segmentedRGBMat).asIplImage();
		
		return segmentedRGBMat.asIplImage();
	}
	
	/**
	 * Binarizes image before segmentation.
	 * 
	 * @param matIn
	 * @return
	 */
	public Mat processMat(Mat matIn) {
		Mat graySclMat = new Mat();
		Mat blurredMat = new Mat();
		Mat thresholdedMat = new Mat();
		Mat thresholdedMat2 = new Mat();
		
		
		//convert to grayscale
		opencv_imgproc.cvtColor(matIn, graySclMat, opencv_imgproc.CV_RGB2GRAY);
		
		opencv_imgproc.GaussianBlur(graySclMat, blurredMat, KERNEL_SIZE, SIGMA);
		
		//binarize image
		//opencv_imgproc.adaptiveThreshold(graySclMat, thresholdedMat, MAX_VALUE, ADAPTIVE_TYPE, THRESHOLD_TYPE, BLOCK_SIZE, THRESHOLD_CONSTANT);
		opencv_imgproc.threshold(blurredMat, thresholdedMat, THRESHOLD_VALUE, MAX_VALUE, THRESHOLD_TYPE);
		opencv_imgproc.adaptiveThreshold(thresholdedMat, thresholdedMat2, MAX_VALUE, ADAPTIVE_TYPE, THRESHOLD_ADAPTIVE_TYPE, BLOCK_SIZE, THRESHOLD_CONSTANT);
		return thresholdedMat2;
	}
	
	/**
	 * Segments the image into areas with the largest size.
	 * 
	 * @param mat0
	 */
	public void segment(Mat matIn) {
		MatVector contourArray = new MatVector();
		opencv_imgproc.findContours(matIn, contourArray, opencv_imgproc.CV_RETR_TREE, opencv_imgproc.CV_CHAIN_APPROX_SIMPLE);
		findBoundingBoxes(contourArray);
	}
	
	//TODO javadoc
	public void findBoundingBoxes(MatVector matVector) {
		for (int i = 0; i < matVector.size(); i++) {
			Mat tempMat = matVector.get(i);
			//TODO pass tempMat to opencv to find bounding boxes
		}
	}
	
	/**
	 * Overlays one Mat onto another.
	 *
	 */
	public Mat overlay(Mat matIn0, Mat matIn1) {
		Mat out = null;
		out = new Mat();
		opencv_core.addWeighted(matIn0, 0.3, matIn1, 0.7, 10, out); //TODO replace these numbers with constants
		return out;
	}

	public void setImage(IplImage image) {
		this.srcImg = image;
	}
	
	public IplImage getImage() {
		return srcImg;
	}
}
