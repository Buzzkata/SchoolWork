#Resubmitting Task n.1 with renamed variables to make the solution more descriptive and clear.
import re
def solution(S):
    substitued_array = re.sub(r'([?!,.]+)',r' \1 ',S)
    split_array = re.split('[.?!]',substitued_array)
    longest_sentence_num = 0
    arr = [len(split_array)]
    x = len(split_array)
    for i in range (x):
        word_list = split_array[i].split()
        if (longest_sentence_num < len(word_list)):
            longest_sentence_num = len(word_list)
    return (longest_sentence_num)


#print(solution("Lets try this. I figure this string should be long enough!"))
#Commented it out, but I used it for testing purposes.
