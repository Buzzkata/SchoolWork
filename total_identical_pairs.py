# Task 2, Solution 1: I made 2 solutions for task 2 in order to compare which one is
# the optimal one. This solution performs slower compared to the second one.
# I believe the overhead is due to memory/calculating the identical pairs dynamically. 
# In this algorithm the identical pairs are calculated dynamically as the array is being
# transformed into a dictionary (hash table). This way we can return 1 billion as soon
# as that threshold is reached. I though this solution might perform better in the following
# scenario: When an array of 100,000 repeating integers is passed through our function,
# the algorithm will return 1 billion once the 44,722 slot of the array is reached. (Because 
# 44,722 repeating integers results in 1 billion identical pairs). This way the algorithm will
# not continue to run for the remaining slots of the array, which would ultimatelly save time. 
# Seems as the memory/dynamic calculation overhead is too expensive as my second solution performs
# better with an array of 100,000 repeating integers.
# The average elapsed time for this solution with 100,000 repeating integers is: 0.025841017999999993 seconds.


#import time
an_array = [4] * 31000
#t = time.process_time()
def solution(A):
    previous_total_per_pair = [0] * len(A)
    total_per_pair = 0
    total_all_pairs = 0
    shallow_array = A  #Create a shallow copy of our array
    size = len(A) 
    total_amount_pairs = 0 #Stores the total amount of identical pairs.
    dictionary = {} #Inserting an array into dictionary. O(n)
    for i in range(size):       
        if shallow_array[i] in dictionary:
            dictionary[shallow_array[i]] += 1 #Increment every pair of identical integers.
            #Next 3 lines of code store the number of identical pairs per int, adds them to the total amount of 
            #identical pairs and subtracts the previous amount of identical pairs for that particular int. Then the
            #current amount of identical pairs for that int is stored in an array so that it can be subtracted afterwards from the total amount of all pairs.
            total_per_pair = (dictionary[shallow_array[i]]*(dictionary[shallow_array[i]]-1))/2 
            total_all_pairs += total_per_pair - previous_total_per_pair[shallow_array[i]]
            previous_total_per_pair[shallow_array[i]] = total_per_pair
            if int(total_all_pairs) > 1000000000:
                return 1000000000
                
        else:
            dictionary[shallow_array[i]] = 1 #Else if number does not exist in the dict add it to the dict and assign 1 (first instance).
        
    return int(total_all_pairs)
       
#print(solution(an_array))  -  for testing purposes.
#print("Elapsed time is: ", time.process_time() - t)  -  obtain running time for the solution.