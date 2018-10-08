package com.apress.prospring5.ch5;

/**
	For formatting reasons, this application uses System.out.print
	and System.out.println instead of a Logger.
**/
public class Agent {
	static int count = 0;
		
    public void speak() {
		if (count == 0)
			System.out.println("Bond");
		else
			System.out.print("Bond");
		
    }
}
