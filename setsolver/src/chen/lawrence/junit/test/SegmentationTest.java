package chen.lawrence.junit.test;

import static org.junit.Assert.*;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_imgproc;
import org.bytedeco.javacpp.opencv_imgproc.*;
import org.bytedeco.javacpp.helper.opencv_highgui;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.JavaCV;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import chen.lawrence.setcv.SetSegmentation;

public class SegmentationTest {
	
	static CanvasFrame canvasFrame = new CanvasFrame("SegTest");
	static Mat matload;
	static IplImage image;
	static IplImage out;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Loader.load(org.bytedeco.javacpp.opencv_core.class); //some sort of class loader bug
		canvasFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		matload = org.bytedeco.javacpp.opencv_highgui.imread("C:\\Users\\Lawrence\\Downloads\\photo.jpg");
		image = matload.asIplImage();
	}
	
	@Test
	public void test() throws Exception{
		SetSegmentation segInstance = new SetSegmentation(image);
		out = segInstance.call();
		while(true) {
			canvasFrame.showImage(out);
		}
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println(out);
	}
}
