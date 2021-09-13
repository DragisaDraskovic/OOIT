package geometry;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) throws Exception {
		
		Point p = new Point();
		p.setX(100);
		System.out.println(p.getX());
		
	
		
		Point p1 = new Point();
		Point p2 = new Point();
		Line l = new Line();
		Circle c = new Circle();
		Rectangle r = new Rectangle();
		
		p1.setX(10);
		p1.setY(20);
		
		p2.setX(20);
		p2.setY(40);
		
		l.setStartPoint(p1);
		l.setEndPoint(p2);
		
		System.out.println("Duzina linije je: " + l.length());
		
		
		
		Point p3 = new Point();
		p3.setX(50);
		p3.setY(50);
		

		c.setRadius(50);
		c.setCenter(p3);
		
		System.out.println("Obim kruga je:" + c.volume());
		System.out.println("Povrsina kruga je :" + c.area());
	


	
	Point p4 = new Point();
	p4.setX(70);
	p4.setY(70);
	
	r.setUpperLeft(p4);
	r.setHeight(60);
	r.setWidth(200);
	
	System.out.println("Povrsina pravugaonika iznosi: " + r.area());
	System.out.println("Obim pravugaonika iznosi: " + r.volume());
	
	
	
	
	if(c.area() > r.area()) {
		System.out.println("Povrsina kruga je veca od povrsine pravugaonika");
		
	}
	else if (c.area() < r.area()) {
		System.out.println("Povrsina kruga je manja od povrsine pravugaonika");
	}
	else {
		System.out.println("Povrsine su jednake");
	}
	
	
	
	
	if(c.volume() > r.volume()) {
		System.out.println("Obim kruga je veci!");
	}
	else if (c.volume() < c.volume()) {
		System.out.println("Obim pravugaonija je veci!");
	}
	else {
		System.out.println("Obimi su jednaki!");
	}
	
	
	
	System.out.println(p1.toString());
	System.out.println(l.toString());
	System.out.println(c.toString());
	System.out.println(r.toString());
	
	Rectangle r2 = new Rectangle(p1, 20, 50);
	Rectangle r3 = new Rectangle(p1, 20, 50, true);
	
	System.out.println(r2);
	System.out.println(r2.equals(r3));
	
	
	
	Donut d = new Donut(new Point(10,20), 20, 10);
	System.out.println("Povrsina je: " + d.area());
	System.out.println(d);
	
	
	
	Point point1 = new Point(20,20);
	point1.move(5, 3);
	System.out.println(point1);
	point1.move(30, 30);
	System.out.println(point1);
	

	
	Line line1 = new Line(new Point(50,50), new Point(100,100));
	line1.move(10, 10);
	System.out.println(line1);
	line1.move(100, 100);  		
	System.out.println(line1);
	
	
	
	Circle circle1 = new Circle(new Point(30,30), 40);
	circle1.move(40, 10);
	System.out.println(circle1);
	circle1.move(400, 400);
	System.out.println(circle1);
	

	
	Shape shape1 = new Donut(new Point(10,10), 20, 10);
	Donut donut1 = new Donut(new Point(10,10), 20, 10);
	Shape line2 = line1;
	Shape circle2 = circle1;
	
	System.out.println("########################### SAMO ISPIS #################");
	
	Shape[] shapes = {shape1, donut1,line2,circle2};
	for (int i = 0; i < shapes.length; i++) {
		System.out.println(shapes[i]);
	}
	
	
	System.out.println("#################### MOVE BY #########################");
	
	for (int i = 0; i < shapes.length; i++) {
		shapes[i].move(5, 10);
		System.out.println(shapes[i]);
	}
	
	int[] ints = {5,2,4,1,3};
	System.out.println("Ne sortirani niz -");
	for (int i = 0; i < ints.length; i++) {
		System.out.println(ints[i]);
	}
	
	Arrays.sort(ints);
	System.out.println("Sortirani niz -");
	for(int i = 0; i < ints.length; i++) {
		System.out.println(ints[i]);
	}
	
	 Arrays.sort(shapes);
	for (int i = 0; i < shapes.length; i++) {
		System.out.println(shapes[i]);
	}		
	
	int[] ints2 = new int[5];
	ints2[0] = 2;
	ints2[4] = 5;
	
	
	
	
	Circle[] circles = new Circle[5];
	circles[0] = new Circle(new Point(20, 20), 20);
	circles[1] = new Circle(new Point(40,40), 40);
	circles[2] = new Circle(new Point(120,120), 300);
	
	double totalArea = 0;
	
	for (int i = 0; i < circles.length; i++) {
		if (circles[i] !=null) {
			totalArea = totalArea + circles[i].area();
		}
	}
	System.out.println("Total area " + totalArea);
	
	
	
	
	
	 c.setRadius(-5); //izbacuje exception!!!
	
	for(int i = 0; i < 10; i++) {
		if(i % 2==0) {
			continue;
		}
		
		if (i == 7) {
			break;
		}
		
		System.out.println(i);
	}
	
	
	
	Circle c5 = new Circle();
		try {
			c5.setRadius(-7);
		}
		
		catch (Exception e) {
			System.out.println("Ne moze se uneti broj manji od 0");
			e.printStackTrace();
		}
		finally {
			System.out.println("Ja se uvek izvrsim! :)");
		}
	}
}
