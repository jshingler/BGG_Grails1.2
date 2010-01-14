class Todo {

	String name 
	String note 
	Date createdDate 
	Date dueDate 
	Date completedDate 
	String priority 
	String status 
	User owner 
	Cat category 
	static belongsTo = [User, Cat] 
	
	static constraints = { 
		name(blank:false) 
		createdDate() 
		priority() 
		status() 
		note(maxSize:1000, nullable:true) 
		completedDate(nullable:true) 
		dueDate(nullable:true) 
	} 
	
	String toString() { 
		name 
	}
}
