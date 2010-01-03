// Listing 2-22. Binding Values to Closures

def startTimer() {
def initialDate = new java.util.Date()
return { println "${initialDate} - ${new java.util.Date()} : Elapsed time ${System.currentTimeMillis() - initialDate.time}" }
}

def timer = startTimer()
// Simulate some work
sleep 30000
timer()
// Simulate some more work
sleep 30000
timer()

// Reset the timer
println "Reset the Timer"
timer = startTimer()
timer()
sleep 30000
timer()