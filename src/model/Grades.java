package model;

public enum Grades {
	S(90),
	A(80),
	B(70),
	C(60),
	D(50),
	E(40),
	F(30),
	G(20),
	U(0);
	
	private int numVal;

    Grades(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
