def filter[X]:(X=>Boolean)=>List[X]=>List[X] = (f)=>{
	def tran:List[X]=>List[X] = (lst)=>{
		lst match{
			case Nil=>Nil
			case e::rst=>if(f(e)) e::tran(rst) else tran(rst)
		}
	}
	tran
}