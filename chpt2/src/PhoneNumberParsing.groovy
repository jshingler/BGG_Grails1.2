// Listing 2-34. Parsing the Phone Number

class Phone {
   String areaCode
   String exchange
   String local
}
def phoneStr = '(800)555-1212'
def phoneRegex = ~/^[01]?\s*[\(\.-]?(\d{3})[\)\.-]?\s*(\d{3})[\.-](\d{4})$/
def matcher = phonePattern.matcher(phoneStr)
def phone = new Phone(
   areaCode: matcher[0][1],
   exchange: matcher[0][2],
   local: matcher[0][3])
println "Original Phone Number: ${phoneStr}"
println """Parsed Phone Number\
   \n\tArea Code = ${phone.areaCode}\
   \n\tExchange = ${phone.exchange}\
   \n\tLocal = ${phone.local}"""