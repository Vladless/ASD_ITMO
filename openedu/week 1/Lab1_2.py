input_file = open('input.txt', 'r')
params = input_file.read().split(" ")
sum = int(params[0]) + int(params[1])**2
output_file = open('output.txt','w')
output_file.write(str(sum))