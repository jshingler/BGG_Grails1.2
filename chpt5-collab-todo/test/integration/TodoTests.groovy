import grails.test.*

class TodoTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
		Todo.list()*.delete()
    }

    protected void tearDown() {
        super.tearDown()
    }

	void testPersist() { 
		new Todo(name: "1", createdDate:new Date(), priority: "", status:"").save() 
		new Todo(name: "2", createdDate:new Date(), priority: "", status:"").save() 
		new Todo(name: "3", createdDate:new Date(), priority: "", status:"").save() 
		new Todo(name: "4", createdDate:new Date(), priority: "", status:"").save() 
		new Todo(name: "5", createdDate:new Date(), priority: "", status:"").save() 
		
		assert 5 == Todo.count() 
		def actualTodo = Todo.findByName('1') 
		assert actualTodo 
		assert '1' == actualTodo.name 
	} 
	
	void testToString() { 
		def todo = new Todo(name: "Pickup laundry") 
		assertToString(todo, "Pickup laundry") 
	} 
}
