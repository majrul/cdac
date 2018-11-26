@interface TODO {

	String task();
	String assignedTo();
	String assignedDate();
}

class Shape {
	
	@TODO(task = "Write the code for drawing",assignedTo="Majrul", assignedDate="24/Nov/2018")
	void draw() {
		
	}
	
	@Deprecated
	void paint() {
		//bug here
	}
}

class Rectangle extends Shape {
	
	@Override
	void draw() {
		//code to draw a rectangle
	}
}

public class Demo /*extends Object*/ {

	public static void main(String[] args) {
		Shape s = new Shape();
		s.paint();
		
		//Thread t = new Thread();
		//t.start();
		//t.stop();
	}
}
