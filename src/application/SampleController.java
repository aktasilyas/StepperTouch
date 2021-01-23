package application;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label numberLabel;

    @FXML
    private JFXButton eksibuton;

    @FXML
    private JFXButton artibuton;

    int number=0;
    
    @FXML
    void initialize() {
      
    	artibuton.setOnAction(e->{
    		numberLabel.setText((++number)+"");
    		TranslateTransition transition=transition(.1, numberLabel, 120, 0);
    		
    		transition.setOnFinished(e2->{
    			transition(.1, numberLabel, 0, 0);
    		});
    		
    	});
    	
    	eksibuton.setOnAction(e->{
    		numberLabel.setText((--number)+"");
          TranslateTransition transition=transition(.1, numberLabel, -120, 0);
    		
    		transition.setOnFinished(e2->{
    			transition(.1, numberLabel, 0, 0);
    		});
    	});
    	
    	
    }
    public TranslateTransition transition(double duration,Node node,double byX,double byY) {
    	TranslateTransition transition=new TranslateTransition(Duration.seconds(duration),node);
    	transition.setToX(byX);
    	transition.setToY(byY);
    	transition.play();
    	return transition;
    }
    
    
}
