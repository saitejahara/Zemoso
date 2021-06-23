import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public int getNumPoints (Shape s) {
        int numPoints=0;
        for(Point p : s.getPoints()){
            numPoints+=1;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double length=getPerimeter(s);
        double numSides=(double) getNumPoints(s);
        double avgLength=length / numSides;
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point lastPoint=s.getLastPoint();
        double largestSide=0.0;
        
        for(Point p : s.getPoints()){
            double dist=lastPoint.distance(p);
            if(dist>largestSide) {
                largestSide=dist;
            }
            lastPoint=p;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        Point lastPoint=s.getLastPoint();
        int lastPointX=lastPoint.getX();
        double largestX=(double) lastPointX;
        
        for(Point p : s.getPoints()){
            int newX=p.getX();
            if(newX>largestX) {
                largestX=(double) newX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource directoryResource=new DirectoryResource();
        double largestPerimeter=0.0;
        FileResource largestFile=null;

        for(File f : directoryResource.selectedFiles()){
            FileResource file=new FileResource(f);
            Shape shape=new Shape(file);
            double perimeter=getPerimeter(shape);
            if(perimeter>largestPerimeter) {
                largestPerimeter=perimeter;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource directoryResource=new DirectoryResource();
        double largestPerim=0.0;
        File largestFile=null;

        for(File f : directoryResource.selectedFiles()){
            FileResource fileResource=new FileResource(f);
            Shape shape=new Shape(fileResource);
            double perimeter=getPerimeter(shape);
            if(perimeter>largestPerim) {
                largestPerim=perimeter;
                largestFile=f;
            }
        }
        return largestFile.getName();
    }

    public void testPerimeterMultipleFiles() {
        // Put code here
        double largest=getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter is: "+largest);
    }

    public void testFileWithLargestPerimeter() {
        String fileName=getFileWithLargestPerimeter();
        System.out.println("Largest perimeter file is: "+fileName);
    }
    
    public double getPerimeter (Shape s) {
        double totalPerimeter=0.0;
        Point prevPoint=s.getLastPoint();
        for (Point currentPoint : s.getPoints()) {
            double currentDist=prevPoint.distance(currentPoint);
            totalPerimeter=totalPerimeter+currentDist;
            prevPoint=currentPoint;
        }
        return totalPerimeter;
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle=new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double perimeter=getPerimeter(triangle);
        System.out.println("perimeter="+perimeter);
    }
    
    public void testPerimeter () {
        FileResource fr=new FileResource();
        Shape s=new Shape(fr);
        double length=getPerimeter(s);
        int numPoints=getNumPoints(s);
        double averageLength=getAverageLength(s);
        double largestSide=getLargestSide(s);
        double largestX=getLargestX(s);
        
        System.out.println("perimeter="+length);
        System.out.println("Number of Points: "+numPoints);
        System.out.println("Average Length: "+averageLength);
        System.out.println("Largest Side: "+largestSide);
        System.out.println("Largest X is: "+largestX );
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr=new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr=new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}