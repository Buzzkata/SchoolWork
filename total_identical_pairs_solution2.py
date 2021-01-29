# Task 2, Solution 2.
# This solution converts the entire argument array into a dictionary and only then proceeds to calculate the number
# of identical pairs. Running time for this algorithm is O(n), since O(2n) = O(n). This solution performs better
# than solution 1, even when the array is filled with 100,000 repeating integers.
# The average elapsed time for this solution with 100,000 repeating integers is: 0.015045456999999998 seconds.
# Making it on average 0.01 seconds faster than solution 1. 

#import time
an_array = [4] * 10000
#t = time.process_time()
def solution(A):
    shallow_array = A #Create shallow copy of array A.
    size = len(A) 
    total_amount_pairs = 0 #Stores the total amount of all identical pairs.
    dictionary = {} #Inserting array into dictionary; O(n)
    for i in range(size): #Transforms the array into a dictionary.
        if shallow_array[i] in dictionary:
            dictionary[shallow_array[i]] += 1 #Increment every pair of identical integers.
        else:
            dictionary[shallow_array[i]] = 1 #Else if number does not exist in the dictionary, add it to the dictionary and assign 1 (first instance).
        
    for key, value in dictionary.items():  #After array is converted to dictionary, we start traversing through the dictionary and calculating the total amount of all identical pairs.
        if value > 1:
            total_amount_pairs += (value*(value-1)/2) #Formula for calculating identical pairs.     
            if total_amount_pairs > 1000000000:
                return 1000000000
    return  int(total_amount_pairs)              
        
#print(solution(an_array))  -  for testing purposes.
#print("Elapsed time is: ", time.process_time() - t) - obtain running time for the solution.