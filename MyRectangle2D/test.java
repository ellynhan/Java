
public class test {

	public static void main(String[] args) {
		MyRectangle2D r1 = new MyRectangle2D(2,2,5.5,4.9);
		System.out.print("r1's area: ");
		System.out.println(r1.getArea());
		System.out.print("r1's perimeter: ");
		System.out.println(r1.getPerimeter());
		System.out.print("r1 conatains (3,3) ? : ");
		System.out.println(r1.contains(3, 3));
		System.out.print("r1 conatains MyRectangle2D(4,5,10.5,3.2) ? : ");
		System.out.println(r1.contains(new MyRectangle2D(4,5,10.5,3.2)));
		System.out.print("r1 overlaps MyRectangle2D(3,5,2.3,5.4) ? : ");
		System.out.println(r1.overlaps(new MyRectangle2D(3,5,2.3,5.4)));
		
		//additional two my own data sets
		System.out.println("----First my own additional data set----");
		System.out.print("r1 conatains (5,4) ? : ");
		System.out.println(r1.contains(5, 4));
		System.out.print("r1 conatains MyRectangle2D(2.5,2.5,1,1) ? : ");
		System.out.println(r1.contains(new MyRectangle2D(2.5,2.5,1,1)));
		System.out.print("r1 overlaps MyRectangle2D(-1,5,6,6) ? : ");
		System.out.println(r1.overlaps(new MyRectangle2D(-1,2,6,2)));
		
		System.out.println("----Second my own additional data set----");
		System.out.print("r1 conatains (0,1) ? : ");
		System.out.println(r1.contains(0, 1));
		System.out.print("r1 conatains MyRectangle2D(0,0,10,8) ? : ");
		System.out.println(r1.contains(new MyRectangle2D(1,-2,2,2)));
		System.out.print("r1 overlaps MyRectangle2D(5,0,0.4,0.2) ? : ");
		System.out.println(r1.overlaps(new MyRectangle2D(6,0,1,0.5)));
		double[][] points5 = {{1,2.5},{3,4},{5,6},{7,8},{9,10}};
		double[][] points10 = {{0,0},{0,3},{1,0},{1,1},{1,2},{1,3},{2,0},{2,2},{2,3},{3,0}};
		double[][] points15 = {{-1,0},{-1,1},{0,-2},{0,2},{1,0},{2,-2},{2,-1},{3,-1},{3,2},{4,-2},{4,1},{4,3},{5,2},{6,3},{7,0}};
		
		MyRectangle2D answer1 = new MyRectangle2D().getRectangle(points10);
		MyRectangle2D answer2 = new MyRectangle2D().getRectangle(points15);

		System.out.print("Enter 10 Points: ");
		for(double[] point : points10) {
			System.out.print("("+point[0]+", "+point[1]+") ");
		}
		System.out.println();
		System.out.print("The bounding rectangle's center ("+answer1.getX()+", "+answer1.getY()+"), ");
		System.out.println("width "+answer1.getWidth()+", height "+answer1.getHeight());
		
		System.out.println("\n");
		
		System.out.print("Enter 15 Points: ");
		for(double[] point : points15) {
			System.out.print("("+point[0]+", "+point[1]+") ");
		}
		System.out.println();
		System.out.print("The bounding rectangle's center ("+answer2.getX()+", "+answer2.getY()+"), ");
		System.out.println("width "+answer2.getWidth()+", height "+answer2.getHeight());
		
	}
}
