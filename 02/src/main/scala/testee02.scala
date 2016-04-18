package gairon.k04.k02
object Main{
// Pair of Symbols
case class SymbolPair(s1:Symbol, s2:Symbol)

def checkColor:
(SymbolPair,SymbolPair)=>Symbol
=
(a,b)=>
{
	a match{
		case SymbolPair(t1,t2)=> b match{
			case SymbolPair(g1,g2)=>if(t1==g1 && t2==g2) 'Perfect
				else if(t1==g1 && t2!=g2) 'OneColorAtCorrectPosition
				else if(t2==g2 && t1!=g1) 'OneColorAtCorrectPosition
				else if(t1==g2 && t2==g1) 'OneColorOccurs
				else 'NothingCorrect
		}
	}
}
}
