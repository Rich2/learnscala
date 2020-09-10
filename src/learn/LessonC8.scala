/* Copyright 2018-20 Richard Oliver. Licensed under Apache Licence version 2.0. */
package learn
import ostrat._, geom._, pCanv._, Colour._

/** This lesson displays an interactive Bezier curve whose points can be dragged and also displays the syntax required to draw it */
case class LessonC8(canv: CanvasPlatform) extends CanvasNoPanels("Lesson C8: More shape dragging.")
{ /** defines the size of the circles that represent the points of the bezier */
  val circleRadius = 15
  case class Drag(var v: Vec2, c: Colour)
  
  /** start point bezier. */
  val p1 = Drag(-100 vv 0, Gray)
  /** End point of bezier curve. */
  val p2 = Drag(100 vv  0, Gray)
  /** control point for start point */
  val c1 = Drag(-100 vv -250, Red)
  /** control point for end point */
  val c2 = Drag(100 vv 50, Red) 
  
  val cCen = Drag(0 vv 150, Violet)
  val cRad = Drag(-70 vv 150, Orange)
  
  val pts = Arr(p1, p2, c1, c2, cCen, cRad)

  /** when one of the bezier points is being dragged, this will indicate which */
  var theDragee: Option[Drag] = None 
  
  drawStuff()

  def drawStuff():Unit = 
  { val cds = pts.map(dr => Circle(circleRadius, dr.v).fillOld(dr.c))
    
    val cl1 = LineDraw(p1.v, c1.v, 1, Grey)    /** line between the start point and its control point */
    val cl2 = LineDraw(p2.v, c2.v, 1, Grey)    /** line between the end point and its control point */

    /** this holds the syntax required to draw the current bezier (bez) (NB: replace ; with , ) */
    //val txt = TextGraphic("BezierDraw(" + p1.v + ", " + c1.v + ", " + c2.v + ", " + p2.v + ", 2, Green)", 18, 0 vv 300)
    val circ = Circle((cCen.v - cRad.v).magnitude, cCen.v).drawOld(2.0, Blue)
    val ell = Ellipse(200, 100).fillOld(SeaGreen)

    val elementsToPaint = cds ++ Arr(cl1, cl2, ell, circ, ell)

    repaint(elementsToPaint)
  }

  /* test to see if drag operation has started. if the mouseDown is on one of the represented bezier points then set theDragee to its corresponding
   option */
  canv.mouseDown = (position, _) => theDragee = pts.find(i => (i.v - position).magnitude <= circleRadius)

  // When a point is being dragged update the correspondin bezier point with its new position and then redraw the screen. */
  canv.mouseDragged = (position, button) => theDragee match
  { case Some(drag) => drag.v = position; drawStuff()
    case _ => theDragee = None
  }

  /** dragging has finished so reset theDragee */
  mouseUp = (button, clickList, position) => theDragee = None 
}