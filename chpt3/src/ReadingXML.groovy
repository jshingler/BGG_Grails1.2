/*
 * Example of using Groovy's XmlSlurper and XPath notation
 * to read and proces XML.
 */
 
def todos = new XmlSlurper().parse('todos.xml')
assert 3 == todos.todo.size()
assert "Buy Beginning Groovy and Grails" == todos.todo[0].name.text()
assert "1" == todos.todo[0].@id.text()