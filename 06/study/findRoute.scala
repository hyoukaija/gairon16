case class Conn(node:Symbol,neighbors:List[Symbol])

def A=Conn('A,List('B,'E))
def B=Conn('B,List('E,'F))
def C=Conn('C,List('D))
def D=Conn('D,List())
def E=Conn('E,List('C,'F))
def F=Conn('F,List('D,'G))
def G=Conn('G,List())

//List(Conn('A,List('B,'E)),Conn('B,List('E,'F)),Conn('C,List('D)),Conn('D,List()),Conn('E,List('C,'F)),Conn('F,List('D,'G)),Conn('G,List()))


def neighborsOf:(Symbol,List[Conn])=>List[Symbol]
=
(node,graph)=>
{
	graph match{
		case Nil=>Nil
		case Conn(a,lst)::rst=> if(a==node) lst else neighborsOf(node,rst)
	}
}

def findRoute:(Symbol,Symbol,List[Conn])=>List[Symbol]
=
(f,g,graph)=>
{
	def take:(List[Symbol])=>Symbol = (lst)=>{lst match{
		case Nil=>'False
		case e::rst=> e
		}
	}
	if (f=='False) Nil
	else if (f==g) List(g)
	else f::findRoute(take(neighborsOf(f,graph)),g,graph)
}

