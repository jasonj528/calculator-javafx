package now;

public class Vector {

	private double x;
	private double y;
	
	public Vector(double x, double y) {
		
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		
		return x;
	}
	
	public double getY() {
		
		return y;
	}
	
	public void setX(int x) {
		
		this.x = x;
	}
	
	public void setY(int y) {
		
		this.y = y;
	}
	
	public String toString() {
		
		return "X = " + x + ", Y = " + y;
	}
}