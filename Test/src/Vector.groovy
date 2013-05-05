

class Vector {
	private Number[] values
	public Number x
	public Number y
	public Number z
		
	/* CONSTRUCTORS */
	public Vector(Number[] values) {
		super();
		this.values = values;
		this.setCoordinates()
	}
	Vector(Vector source){
		this.values = source.values
		this.setCoordinates()
	}
	Vector(){
		this.values = []
		this.setCoordinates()
	}
	
	/* SETTERS AND GETTERS */
	public getValues(){
		return this.values
	}
	public setValues(Number[] values){
		this.values = values
		this.setCoordinates()
	}
	public setX(Number value){
		this.x = value
		if (values.size() > 0) values[0] = value
		else values.add(value)
	}
	public setY(Number value){
		this.y = value
		if (values.size() > 1) values[1] = value
		else if (values.size() > 0) values.add(value)
		else { values.add(0); values.add(value) }
	}
	private setCoordinates(){
		x = (values.size() > 0)? values[0] : null
		y = (values.size() > 1)? values[1] : null
		z = (values.size() > 2)? values[2] : null
	}
	
	/* METHODS */
	@Override
	public String toString() {
		return "Vector " + values;
	}
	
	// length
	def length(){
		return length(this)
	}
	
	static def length(Vector v){
		def sumSquares = v.getValues().sum{x -> x*x}
		return Math.sqrt(sumSquares)
	}
	
	// normalization
	def normalize(){
		return normalize(this)
	}
	
	static def normalize(Vector v){
		def l = v.length()
		if (! l) return v
		def resultVal = v.getValues().collect{x -> x/l}
		return new Vector(resultVal as Number[])
	}
	
	// addition
	@Override
	def plus(Vector vector1){
		return plus(this, vector1)
	}
	@Override
	def plus(Number x){
		return plus(this, x)
	}
	@Override
	static def plus(Vector v1, Vector v2){
		def resultVal = [], v1Val = v1.getValues(), v2Val = v2.getValues()
		for (def i=0; i<v1Val.size() && i<v2Val.size(); i++)
			resultVal.add(v1Val[i] + v2Val[i])
		return new Vector(resultVal as Number[])
	}
	@Override
	static def plus(Vector v1, Number x){
		def resultVal = [], v1Val = v1.getValues()
		for (def i=0; i<v1Val.size(); i++)
			resultVal.add(v1Val[i] + x)
		return new Vector(resultVal  as Number [])
	}
	
	// subtraction
	@Override
	def minus(Vector vector1){
		return minus(this, vector1)
	}
	@Override
	def minus(Number x){
		return minus(this, x)
	}
	@Override
	static def minus(Vector v1, Vector v2){
		def resultVal = [], v1Val = v1.getValues(), v2Val = v2.getValues()
		for (def i=0; i<v1Val.size() && i<v2Val.size(); i++)
			resultVal.add(v1Val[i] - v2Val[i])
		return new Vector(resultVal as Number[])
	}
	@Override
	static def minus(Vector v1, Number x){
		def resultVal = [], v1Val = v1.getValues()
		for (def i=0; i<v1Val.size(); i++)
			resultVal.add(v1Val[i] - x)
		return new Vector(resultVal  as Number [])
	}
	
	// multiplication
	@Override
	def multiply(Vector vector1){
		return multiply(this, vector1)
	}
	@Override
	def multiply(Number x){
		return multiply(this, x)
	}
	@Override
	static def multiply(Vector v1, Vector v2){
		def resultVal = [], v1Val = v1.getValues(), v2Val = v2.getValues()
		for (def i=0; i<v1Val.size() && i<v2Val.size(); i++)
			resultVal.add(v1Val[i] * v2Val[i])
		return new Vector(resultVal as Number[])
	}
	@Override
	static def multiply(Vector v1, Number x){
		def resultVal = [], v1Val = v1.getValues()
		for (def i=0; i<v1Val.size(); i++)
			resultVal.add(v1Val[i] * x)
		return new Vector(resultVal  as Number [])
	}

	// division
	@Override
	def div(Vector vector1){
		return div(this, vector1)
	}
	@Override
	def div(Number x){
		return div(this, x)
	}
	@Override
	static def div(Vector v1, Vector v2){
		def resultVal = [], v1Val = v1.getValues(), v2Val = v2.getValues()
		for (def i=0; i<v1Val.size() && i<v2Val.size(); i++)
			resultVal.add(v1Val[i] / v2Val[i])
		return new Vector(resultVal as Number[])
	}
	@Override
	static def div(Vector v1, Number x){
		def resultVal = [], v1Val = v1.getValues()
		for (def i=0; i<v1Val.size(); i++)
			resultVal.add(v1Val[i] / x)
		return new Vector(resultVal  as Number [])
	}
	
	
	public static void main(String[] args){
		def v1 = new Vector()
		def v2 = new Vector(3, 2, 1)
		def v3 = new Vector(v2)
		println v1
		println v2
		println v3
		println v3 + v2
		println v3 += 2
		println v3 - 3
		println v2 -= 5
		println v1 / 5
		println v3 /= 12
		println v3.x
		println v3 = v2
		println v2.x
		println v3.x
		println "v3 = $v3"
		println "length v3 = ${v3.length()}"
		println normalize(v3)
		println "length v3 = ${v3.length()}"
		v3.setX(10)
		v3.setY(2)
		println "x = ${v3.x} and y = ${v3.y} in $v3"
	}
}