// Listing 2-35. Using the Spread Operator
class User {
   String firstName
   String lastName
   
   def printFullName = {
      println "${firstName} ${lastName}"
   }
}

// Instantiate a User using the named parameters constructor
User chris = new User(firstName:"Chris", lastName: "Judd")
User joseph = new User(firstName:"Joseph", lastName: "Nusairat")
User jim = new User(firstName:"Jim", lastName: "Shingler")

def list = [chris,joseph,jim]

println "Using collect closure"
list.collect { println it.printFullName() }

println "\n\nUsing Spread Operator:"
list*.printFullName()