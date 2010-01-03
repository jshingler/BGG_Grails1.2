// Listing 2-30. Using the Match Operator

assert "abc" ==~ 'abc'
assert "abc" ==~ /abc/
assert "abcabc" ==~ /abc/ // Fails – not an exact match
assert "abc" ==~ /^a.c/ // Starts with a, 1 char, ends with c
assert "abc" ==~ /^a../ // Starts with a, 2 chars
assert "abc" ==~ /.*c$/ // One or more chars end with c
assert "abc" ==~ ".*c\$" // Slashy string is better