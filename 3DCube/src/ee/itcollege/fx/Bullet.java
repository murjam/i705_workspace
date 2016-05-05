package ee.itcollege.fx;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Translate;

public class Bullet extends Sphere {
	
	private double xAngle;
	private double yAngle;
	
	private double distance = 0;
	
	public Bullet(Translate shooterLocation, double xRotation, double yRotation) {
		super(3);
		this.yAngle = Math.toRadians(yRotation);
		this.xAngle = Math.toRadians(xRotation);
		setTranslateZ(shooterLocation.getZ());
		setTranslateY(shooterLocation.getY());
		setTranslateX(shooterLocation.getX());
		PhongMaterial blueMaterial = new PhongMaterial();
		blueMaterial.setDiffuseColor(Color.BLUE);
		setMaterial(blueMaterial);
		move();
	}
	
	
	public void move() {
		double step = 10;
		distance += step;
		double dx = step * Math.sin(yAngle) * Math.cos(xAngle);
		double dz = step * Math.cos(yAngle) * Math.cos(xAngle);
		double dy = step * -Math.sin(xAngle);
		setTranslateX(getTranslateX() + dx);
		setTranslateZ(getTranslateZ() + dz);
		setTranslateY(getTranslateY() + dy);
	}
	
	public double getDistance() {
		return distance;
	}
	
}
