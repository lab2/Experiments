package ch.codespin.java.umock

class Mock {
	Map props=[:]
	public Mock(){
	}
	
	public Mock(Map attr){
		attr.each { key, value ->
			this.setProperty(key, value)
		} 
	} 
	def getProperty(String property){
		props[property];
	}
	void setProperty(String property, Object newValue){
		props[property] = newValue; 
	}
	
	def propertyMissing(String name, Object value) {
		return this.setProperty(name, value)
	}
	 
	def methodMissing(String name, args) {
		
	}
}








