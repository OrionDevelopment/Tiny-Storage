package com.timthebrick.tinystorage.util.math;

import java.util.Formatter;
import java.util.Locale;

/**
 * 
 * Implementaion of Quat taken from Botania by Vazkii
 * 
 * @author Vazkii
 *
 */
public class Quaternion {

	public double x;
	public double y;
	public double z;
	public double s;

	public Quaternion() {
		s = 1.0D;
		x = 0.0D;
		y = 0.0D;
		z = 0.0D;
	}

	public Quaternion(Quaternion Quaternion) {
		x = Quaternion.x;
		y = Quaternion.y;
		z = Quaternion.z;
		s = Quaternion.s;
	}

	public Quaternion(double d, double d1, double d2, double d3) {
		x = d1;
		y = d2;
		z = d3;
		s = d;
	}

	public void set(Quaternion Quaternion) {
		x = Quaternion.x;
		y = Quaternion.y;
		z = Quaternion.z;
		s = Quaternion.s;
	}

	public static Quaternion aroundAxis(double ax, double ay, double az, double angle) {
		angle *= 0.5D;
		double d4 = Math.sin(angle);
		return new Quaternion(Math.cos(angle), ax * d4, ay * d4, az * d4);
	}

	public void multiply(Quaternion Quaternion) {
		double d = s * Quaternion.s - x * Quaternion.x - y * Quaternion.y - z * Quaternion.z;
		double d1 = s * Quaternion.x + x * Quaternion.s - y * Quaternion.z + z * Quaternion.y;
		double d2 = s * Quaternion.y + x * Quaternion.z + y * Quaternion.s - z * Quaternion.x;
		double d3 = s * Quaternion.z - x * Quaternion.y + y * Quaternion.x + z * Quaternion.s;
		s = d;
		x = d1;
		y = d2;
		z = d3;
	}

	public void rightMultiply(Quaternion Quaternion) {
		double d = s * Quaternion.s - x * Quaternion.x - y * Quaternion.y - z * Quaternion.z;
		double d1 = s * Quaternion.x + x * Quaternion.s + y * Quaternion.z - z * Quaternion.y;
		double d2 = s * Quaternion.y - x * Quaternion.z + y * Quaternion.s + z * Quaternion.x;
		double d3 = s * Quaternion.z + x * Quaternion.y - y * Quaternion.x + z * Quaternion.s;
		s = d;
		x = d1;
		y = d2;
		z = d3;
	}

	public double mag() {
		return Math.sqrt(x * x + y * y + z * z + s * s);
	}

	public void normalize() {
		double d = mag();
		if (d == 0.0D) {
			return;
		} else {
			d = 1.0D / d;
			x *= d;
			y *= d;
			z *= d;
			s *= d;
			return;
		}
	}

	public void rotate(Vector3 vec) {
		double d = -x * vec.x - y * vec.y - z * vec.z;
		double d1 = s * vec.x + y * vec.z - z * vec.y;
		double d2 = s * vec.y - x * vec.z + z * vec.x;
		double d3 = s * vec.z + x * vec.y - y * vec.x;
		vec.x = d1 * s - d * x - d2 * z + d3 * y;
		vec.y = d2 * s - d * y + d1 * z - d3 * x;
		vec.z = d3 * s - d * z - d1 * y + d2 * x;
	}

	@Override
	public String toString() {
		StringBuilder stringbuilder = new StringBuilder();
		Formatter formatter = new Formatter(stringbuilder, Locale.US);
		formatter.format("Quaternionernion:\n", new Object[0]);
		formatter.format("  < %f %f %f %f >\n", Double.valueOf(s), Double.valueOf(x), Double.valueOf(y), Double.valueOf(z));
		formatter.close();
		return stringbuilder.toString();
	}

	public static Quaternion aroundAxis(Vector3 axis, double angle) {
		return aroundAxis(axis.x, axis.y, axis.z, angle);
	}

}
