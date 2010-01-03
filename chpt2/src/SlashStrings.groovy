// Listing 2-16. Using Slashy Strings

def winpathQuoted='C:\\windows\\system32'
def winpathSlashy=/C:\windows\system32/
println winpathSlashy // C:\windows\system32
assert winpathSlashy ==~ '\\w{1}:\\\\.+\\\\.+'
assert winpathSlashy ==~ /\w{1}:\\.+\\.+/