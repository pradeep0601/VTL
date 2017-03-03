import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class SimpleWebBrowserExample extends Application{
	@Override
	  public void start(final Stage stage) {
	    stage.setWidth(1000);
	    stage.setHeight(700);
	   // stage.setFullScreen(true);
	    Scene scene = new Scene(new Group());

	    final WebView browser = new WebView();
	    final WebEngine webEngine = browser.getEngine();

	    ScrollPane scrollPane = new ScrollPane();
	    scrollPane.setContent(browser);

	    browser.getEngine().setOnAlert((WebEvent<String> wEvent) -> {
	      System.out.println("Alert Event  -  Message:  " + wEvent.getData());
	    });

	    webEngine.load("http://localhost:2727/");

	    
	    final WebHistory history = webEngine.getHistory();
	    history.getEntries().addListener(new 
	        ListChangeListener<WebHistory.Entry>() {
	            @Override
	            public void onChanged(Change<? extends Entry> c) {
	                c.next();
	                for (Entry e : c.getRemoved()) {
	                    System.out.println(e.getUrl());
	                }
	                for (Entry e : c.getAddedSubList()) {
	                    System.out.println(e.getUrl());
	                }
	            }
	        }
	    );
	             
	    history.go(0);
	    scene.setRoot(scrollPane);

	    stage.setScene(scene);
	    stage.show();
	  }

	  public static void main(String[] args) {
	    launch(args);
	  }
	}