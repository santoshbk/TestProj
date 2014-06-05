package com.santosh.test;

public class C implements A, B {

	public void b1() {
		System.out.println();
	}

	public void b2() {
	}

	public void a1() {
	}

	public void a2() {
	}

}

interface A{	void a1();	void a2(); }


interface B{ 	void b1(); 	void b2(); }