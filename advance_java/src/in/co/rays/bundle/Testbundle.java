package in.co.rays.bundle;

import java.util.ResourceBundle;

public class Testbundle {

	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.ok_hi");
		System.out.println(rb.getString("ok"));

	}

}
