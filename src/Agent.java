

public class Agent {

	private double x,y,f;
	private int a,b,c,ad,bd;

	Agent() {
		this.x = 0;
		this.y = 0;
		this.f = 0;
		this.a = 0;
		this.b = 0;
		this.c = 0;
		this.ad = 0;
		this.bd = 0;
	}

	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void addY(double y) {
		this.y += y;
	}

	public double getF() {
		return this.f;
	}

	public void setF() {
		this.f = ((double)this.a * this.x * this.x) + ((double)this.b * this.x) + (double)this.c;
	}

	public int getA() {
		return this.a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return this.b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return this.c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getAd() {
		return this.ad;
	}

	public void setAd(int ad) {
		this.ad = ad;
	}

	public int getBd() {
		return this.bd;
	}

	public void setBd(int bd) {
		this.bd = bd;
	}
}
