def PI = 3.14

// Position(x,y) represents a position in XY-plane, where x is the
// X-coordinate and y is the Y-coordinate
case class Position(x:Int,y:Int)


// Shape is a type for all shapes.
abstract class Shape

// Circle(p,r) represents a circle, where p is the center position and
// r is the radius.
case class Circle(center:Position, radius:Double) extends Shape

// Square(p,l) represents a square, where p is the center position and
// l is the length of each edge.
case class Square(center:Position, length:Double) extends Shape

def perimeter:
(Shape)=>(Double)
=
(n)=>
{n match{
	case Circle(Position(x,y),z)=>2*z*PI
	case Square(Position(a,b),c)=>4*c
	}
}
