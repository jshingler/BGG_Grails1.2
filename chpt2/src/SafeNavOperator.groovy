// Listing 2-37. Using the Safe Navigation/Dereference Operator

User user
println user.firstName // Throws NullPointerException

// Adding a null check, the Java way
if (user != null) {
   println "Java FirstName = ${user.firstName}"
}

// Null check the Groovy way
println "Groovy FirstName = ${user?.firstName}"