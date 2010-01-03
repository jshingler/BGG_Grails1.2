// Listing 2-33. Validating a Phone Number

def phoneValidation = /^[01]?\s*[\(\.-]?(\d{3})[\)\.-]?\s*(\d{3})[\.-](\d{4})$/
assert '(800)555-1212' ==~ phoneValidation
assert '1(800) 555-1212' ==~ phoneValidation
assert '1-800-555-1212' ==~ phoneValidation
assert '1.800.555.1212' ==~ phoneValidation