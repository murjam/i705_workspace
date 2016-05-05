package ee.itcollege.fx;

import java.awt.Robot;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class JavaFxSample extends Application {
	
	double lastMouseX = 0;
	double lastMouseY = 0;
	
	Rotate yRotation = new Rotate(23, Rotate.Y_AXIS);
	Rotate xRotation = new Rotate(0, Rotate.X_AXIS);
	Translate cameraLocation = new Translate(-15, -8, -10);
	
	Stage stage;
	
	public int getAbsoluteCenterX() {
		return (int) (stage.getX() + stage.getWidth() / 2);
	}
	
	public int getAbsoluteCenterY() {
		return (int) (stage.getY() + stage.getHeight() / 2);
	}
	
	public void moveCursorToTheCenter() {
		try {
			Robot r = new Robot();
			r.mouseMove(getAbsoluteCenterX(), getAbsoluteCenterY());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@SuppressWarnings("incomplete-switch")
	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;

		stage.setTitle("Fly around the cube!");

		Pane layout = new Pane();
		
		Box cube = new Box(10, 10, 10);
		cube.setTranslateZ(30);
		PhongMaterial redMaterial = new PhongMaterial();
		redMaterial.setDiffuseColor(Color.RED);
		cube.setMaterial(redMaterial);
		layout.getChildren().add(cube);
		
		cube = new Box(4, 4, 8);
		cube.setTranslateZ(20);
		cube.setTranslateX(40);
		PhongMaterial greenMaterial = new PhongMaterial();
		greenMaterial.setDiffuseColor(Color.GREEN);
		cube.setMaterial(greenMaterial);
		layout.getChildren().add(cube);
		
		PerspectiveCamera camera = new PerspectiveCamera(true);
		camera.setFieldOfView(70);
		camera.getTransforms().add(cameraLocation);
		camera.getTransforms().add(yRotation);
		camera.getTransforms().add(xRotation);
		camera.setNearClip(.1);
		camera.setFarClip(1000); // how far does the camer see
		
		
		stage.addEventFilter(MouseEvent.MOUSE_MOVED, (event) -> {
			double dx = event.getScreenX() - getAbsoluteCenterX();
			double dy = event.getScreenY() - getAbsoluteCenterY();
			
			moveCursorToTheCenter();
			yRotation.setAngle(yRotation.getAngle() + dx / 10.);
			xRotation.setAngle(xRotation.getAngle() - dy / 10.);
			event.consume();
		});
		
		stage.addEventFilter(MouseEvent.MOUSE_PRESSED, (event) -> {
			Bullet bullet = new Bullet(cameraLocation, xRotation.getAngle(), yRotation.getAngle());
			layout.getChildren().add(bullet);
			
//			yRotation.setAngle(yRotation.getAngle() + dx / 10.);
//			xRotation.setAngle(xRotation.getAngle() - dy / 10.);
		});
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				ObservableList<Node> children = layout.getChildren();
				for (int i = 0; i < children.size(); i++) {
					Node node = children.get(i);
					if (node instanceof Bullet) {
						Bullet bullet = ((Bullet)node);
//						if (bullet.getDistance() > 200) {
//							children.remove(i--);
//							continue;
//						}
						bullet.move();
					}
				}
			}
		}, 100, 100);
		
		stage.addEventFilter(KeyEvent.KEY_PRESSED, (event) -> {
			double step = 1;
			double a = Math.toRadians(yRotation.getAngle());
			double dx = step * Math.sin(a);
			double dz = step * Math.cos(a);
			
			switch (event.getCode()) {
				case RIGHT:
					yRotation.setAngle(yRotation.getAngle() + 1);
					break;
				case LEFT:
					yRotation.setAngle(yRotation.getAngle() - 1);
					break;
				case W:
					cameraLocation.setX(cameraLocation.getX() + dx);
					cameraLocation.setZ(cameraLocation.getZ() + dz);
					break;
				case S: 
					cameraLocation.setX(cameraLocation.getX() - dx);
					cameraLocation.setZ(cameraLocation.getZ() - dz);
					break;
				case A:
					cameraLocation.setX(cameraLocation.getX() - dz);
					cameraLocation.setZ(cameraLocation.getZ() + dx);
					break;
				case D:
					cameraLocation.setX(cameraLocation.getX() + dz);
					cameraLocation.setZ(cameraLocation.getZ() - dx);
					break;
				case ESCAPE:
					System.exit(0);
			}
		});
		
		Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

		layout.setMinSize(screenSize.getWidth(), screenSize.getHeight());
		Scene scene = new Scene(layout, screenSize.getWidth() / 2, screenSize.getHeight() / 2, false, SceneAntialiasing.BALANCED);
		scene.setCamera(camera);
		scene.setCursor(Cursor.CROSSHAIR);
		stage.setScene(scene);
		
		//stage.setFullScreen(true);
		stage.show();
		stage.setOnCloseRequest((e) -> System.exit(0));
		moveCursorToTheCenter();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}