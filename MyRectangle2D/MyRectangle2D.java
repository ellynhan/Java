
public class MyRectangle2D {
	private double x,y;
	private double width, height;
	
	//constructor (default)
	MyRectangle2D(){
		this.x=0;
		this.y=0;
		this.width=1;
		this.height=1;
	}
	
	//constructor overloading
	MyRectangle2D(double x, double y, double w, double h){
		setXY(x,y);
		setWidthHeight(w,h);
	}
	
	//x,y setter
	public void setXY(double x, double y) {
		this.x = x;
		this.y = y;
	}

	//x,y getter
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	
	//width, height setter
	public void setWidthHeight(double w, double h) {
		this.width=w;
		this.height=h;
	}
	
	//width, height getter
	public double getWidth() {
		return this.width;
	}
	public double getHeight() {
		return this.height;
	}
	
	//get Area
	public double getArea() {
		double area = getWidth()*getHeight();
		return area;
	}
	
	//get Perimeter
	public double getPerimeter() {
		double sum = getWidth()+getHeight();
		return 2*sum;
	}
	
	//check (x,y) is inside this rectangle
	public boolean contains(double x, double y) {
		//calculate this ractangle's bottomLeft edge point and topRight edge point.
		double bottomLeftX = getX()-getWidth()/2;
		double bottomLeftY = getY()-getHeight()/2;
		double topRightX = getX()+getWidth()/2;
		double topRightY = getY()+getHeight()/2;
		//if(x,y) is inside this rectangle,
		//(x,y) should be bigger than bottomLeft point
		//(x,y) should be smaller than topRight point
		if(x>bottomLeftX&&x<topRightX&&y>bottomLeftY&&y<topRightY) {
			return true;
		}
		return false;
		
	}
	
	//contains overloading
	//check rectangle r is inside this rectangle
	public boolean contains(MyRectangle2D r) {
		double bottomLeftX = r.getX()-r.getWidth()/2;
		double bottomLeftY = r.getY()-r.getHeight()/2;
		double topRightX = r.getX()+r.getWidth()/2;
		double topRightY = r.getY()+r.getHeight()/2;
		
		//check r's bottomLeft point is inside this rectangle
		if(contains(bottomLeftX,bottomLeftY)==true) {
			//check r's topRight point is inside this rectangle
			if(contains(topRightX,topRightY)==true) {
				return true;
			}
		}
		return false;
	}
	
	//check rectangle r is overlapped with this rectangle.
	public boolean overlaps(MyRectangle2D r) {
		//for calculate topLeft,topRight,bottomRight,bottomLeft points
		double [] xOper = {-0.5,0.5,0.5,-0.5};
		double [] yOper = {0.5,0.5,-0.5,-0.5};
		
		//if rectangle r is inside this rectangle, then it's not overlapped.
		if(contains(r)==false) {
			//check one point of r rectangle's points is inside this rectangle.
			for(int i=0; i<4; i++) {
				double x = r.getX()+xOper[i]*r.getWidth();
				double y = r.getY()+yOper[i]*r.getHeight();
				//if so, it's overlapped.
				if(contains(x,y)==true) {
					return true;
				}
			}
		}
		return false;
	}

	public static MyRectangle2D getRectangle(double[][] points) {
		double[] max= {points[0][0],points[0][1]};
		double[] min= {points[0][0],points[0][1]};
		
		for(double[] point:points) {
			if(max[0]<point[0]) {
				max[0]=point[0];
			}
			if(max[1]<point[1]) {
				max[1]=point[1];
			}
			if(min[0]>point[0]) {
				min[0]=point[0];
			}
			if(min[1]>point[1]) {
				min[1]=point[1];
			}
		}
		double x = (max[0]+min[0])/2;
		double y = (max[1]+min[1])/2;
		double w = max[0]-min[0];
		double h = max[1]-min[1];
		MyRectangle2D br = new MyRectangle2D(x,y,w,h);
		return br;
		
	}
}


