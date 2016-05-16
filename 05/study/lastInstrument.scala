case class Player(name:Symbol,instrument:Symbol,year:Int)

def head[X]:(List[X])=>X
=
(lst)=>
{
	lst match{
		case e::rst=>e
	}
}

def filter[X]:(((X)=>Boolean),List[X])=>List[X]
=
(p,lst)=>
{
	lst match{
		case Nil=>Nil
		case e::rst=>if(p(e)) e::filter(p,rst) else filter(p,rst)
	}
}

def lastInstrument:(List[Player],Symbol)=>Symbol
=
(lst,n)=>
{
	def eqP:(Player)=>Boolean =
	(p)=> p match{
		case Player(name,instr,year)=> n == name
	}
	def gtP:(Player,Player)=>Boolean=
	(p1,p2)=>(p1,p2) match{
		case (Player(n1,i1,y1),Player(n2,i2,y2)) =>y1>y2
	}
	//自分で書く
	head(sort(gtP,filter(eqP,lst))) match{
		case Player(name,instrument,year) => instrument
	}
}