// Listing 2-26. Iterating with Ranges

println "Java style for loop"
for(int i=0;i<=9;i++) {
   println i
}

println "Groovy style for loop"
for (i in 0..9) {
   println i
}

println "Groovy range loop"
(0..9).each { i->
   println i
}