package learn
import javafx.application.Application, javafx.scene.Scene, javafx.stage.Stage
import ostrat.pFx._

object MyApp 
{
  def main(args: Array[String]): Unit = javafx.application.Application.launch(classOf[AppStart], args: _*)
}

class AppStart extends Application
{
  override def start(primaryStage: Stage): Unit = 
  {
    val bounds = javafx.stage.Screen.getPrimary.getVisualBounds
    val canvasCanvas: javafx.scene.canvas.Canvas = new javafx.scene.canvas.Canvas(bounds.getWidth - 8, bounds.getHeight - 40) 
    val root = new javafx.scene.Group()
    root.getChildren.add(canvasCanvas)        
    primaryStage.setX(0)    
    val jScene = new Scene(root, bounds.getWidth - 8, bounds.getHeight - 40)     
    
    val newAlt = CanvasFx(canvasCanvas)
    LessonA1(newAlt)
    primaryStage.setTitle("")
    primaryStage.setScene(jScene)
    primaryStage.show
  }
}