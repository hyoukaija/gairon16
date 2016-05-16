def add:(Int)=>(Int)=>Int
=
(x)=>{
	def xaddr:(Int)=>Int = (y)=>{x+y}
	xaddr
}