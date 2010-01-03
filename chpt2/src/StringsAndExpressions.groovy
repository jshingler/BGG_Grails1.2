// Listing 2-13
def name = "Jim"
def helloName = "Hello, ${name}"
println helloName // Hello, Jim
println helloName.class.name // org.codehaus.groovy.runtime.GStringImpl

def helloNoName = 'Hello, ${name}'
println helloNoName // Hello, ${name}
println helloNoName.class.name // java.lang.String

def helloSlashyName = /Hello, ${name}/
println helloSlashyName // Hello, Jim
println helloSlashyName.class.name // org.codehaus.groovy.runtime.GStringImpl