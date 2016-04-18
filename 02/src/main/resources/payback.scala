def payBack:
(Double)=>(Double)
=
(n)=>
{if(n<=500){pay500(n)}
else if(n<=1500){pay1500(n)}
else if(n<=2500){pay2500(n)}
else {pay000(n)}
}


def pay500:
(Double)=>(Double)
=
(n)=>
{n*0.0025}

def pay1500:
(Double)=>(Double)
=
(n)=>
{(n-500)*0.005+pay500(500)}

def pay2500:
(Double)=>(Double)
=
(n)=>
{(n-1500)*0.0075+pay1500(1500)}

def pay000:
(Double)=>(Double)
=
(n)=>
{(n-2500)*0.01+pay2500(2500)}