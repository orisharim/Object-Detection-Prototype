package application;

import org.opencv.core.Core;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Program extends Application
{
	//to run add to the vm arguments "--module-path "YOUR\PATH\lib" --add-modules javafx.controls,javafx.fxml"
	@Override
	public void start(Stage primaryStage){
		try{
			// load the FXML resource
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ObjectDetection.fxml"));
			// store the root element so that the controllers can use it
			BorderPane root = (BorderPane) loader.load();
			// set a whitesmoke background
			root.setStyle("-fx-background-color: whitesmoke;");
			// create and style a scene
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// create the stage with the given title and the previously created
			// scene
			primaryStage.setTitle("Object Recognition");
			primaryStage.setScene(scene);
			// show the GUI
			primaryStage.show();
			
			// set the proper behavior on closing the application
			GUIcontroller controller = loader.getController();
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		//load OpenCV
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		launch(args);
	}
}
