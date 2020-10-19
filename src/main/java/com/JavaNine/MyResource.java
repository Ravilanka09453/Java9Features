package com.JavaNine;

/**
 * 
 * My Resource used to demonstrate behavior of try with resource which gives
 * process close methods and how exceptions are thrown for certain Id
 * 
 * when resource id=0-no exceptions are thrown. resource id=1-process method
 * throws exception. resource id=2-close method throws exception.
 *
 */

public class MyResource implements AutoCloseable {

	int id;

	public MyResource(int id) {
		this.id = id;
		System.out.println("Creating a resource" + id);
	}

	public void process() throws Exception {
		System.out.println("Process resource id" + id);
		if (id == 1) {
			throw new Exception("Exception in process");
		}
	}

	@Override
	public void close() throws Exception {
		System.out.println("Closing resource id" + id);

		if (id == 2) {
			throw new Exception("Exception in close");
		}

	}

}
