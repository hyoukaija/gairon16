case class Conn(node:Symbol,neighbors:List[Symbol])
def findRoute
def findRouteL

def findRouteL:(List[Symbol],Symbol,List[Conn])=>List[Symbol]
=(originations,destination,graph)=>originations match{
	case Nil=>Nil
	case hd::tl=>findRoute(hd,destination,graph) match{
		case Nil=>findRouteL(tl,destination,graph)
		case ans=>ans
	}
}

def find[X]:((X)=>Boolean,List[X])=>Option[X]
=(p,lst)=>lst match{
	case Nil=>None
	case hd::tl=>if(q(hd)) Some(hd) else find(p,tl)
}

def neighborsOf(Symbol,List[Conn])=>List[Symbol]
=(node,graph)=>{
	def eqNode:Conn=>Boolean
	=(c)=>c match{case Conn(n,_)=>node == n}

	find(eqNode,graph) match{
		case None=>Nil
		case Some(c)=>c match{case Conn(_,n)=>n}
	}
}
def findRoute:(Symbol,Symbol,List[Conn])=>List[Symbol]
=
(originations,destination,graph)=>{
	if(originations==destination) List(destination)
	else findRouteL(neighbors(originations,graph),destination,graph) match{
		case Nil=>Nil
		case ans=>originations::ans
	}
}