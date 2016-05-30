//n進数から１０進数へ

def to10:(Int)=>(List[Int])=>Int
=
(n)=>(lst)=>{
	type Accumulator=Int
	def keisann:(Accumulator)=>(List[Int])=>Int
		=(acc)=>(lstkei)=>{
			lstkei match{
				case Nil=>acc
				case e::rst=>keisann(acc*n+e)(rst)
			}
		}
	keisann(0)(lst)
}