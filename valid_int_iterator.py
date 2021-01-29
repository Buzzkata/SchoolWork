# Task 3:
# The solution has an extra function implemented which checks the lines of strings and makes sure they are
# a valid integer. Invalid integers such as: 00, 012, 024131, 05, -0923, +0215,@@, ##, 5$, ++0, ++25 return
# false. Along with integers that exceed the 1 billion constraint. Valid integers such as: +0,-0, +1244, -124441,
# 9120,   +100 return true. 
# I have also provided the test file that I used to test this solution.

def valid_int(s): #Function that checks to see if a string is a valid integer.
    try:
        int(s)		
        if (len(s.strip()) > 1) and (s.strip()[0] == '0'): #Testing for these cases should return false; 01231,0445,01,06,00
            return False
        elif (len(s.strip())>2) and ((s.strip()[0] == '+' or s.strip()[0] == '-') and s.strip()[1] == '0'): #Testing for these cases should return false; -0124,+01248,-01415134, -04,+07
            return False
        elif len(s) == 2 and ((s[0] == '+' or s[0] == '-') and s[1] == '0'): #The test cases -0,+0 should return true.
            return True
        elif (len(s.strip()) >= 10): #If number exceeds the 1 billion constraint, return false.
            return False
        else:
            return True #All other cases return true.
    except ValueError:	    
        return False
         

def solution(object_file):
    for line in open(object_file):
	    if (len(line.split()) == 1 and valid_int(line)): #Check to see if the line is a valid integer. If the splitted line != 1, then discard it because there are more values in the line.
		    yield(int(line))
		    			
#for i in solution("test_file.txt"):  -  File name for testing is called test_file. 
#	print(i)  -  for testing purposes.
		