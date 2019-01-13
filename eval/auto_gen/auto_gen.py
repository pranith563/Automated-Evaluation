#For one scanf line
import sys
import random
import os
import string

ASSERT_FAIL = "Assertion Failed"

if(len(sys.argv)!=2):
	print("\n\nUsage python "+sys.argv[0]+" <reference solution>")
	sys.exit(0)

REF_PATH = sys.argv[1]
INPUT_TESTSET_FILE_PATH = "auto_gen/input.in"
OUTPUT_TESTSET_FILE_PATH = "auto_gen/output.out"
MAX_NUM_TESTS = 100

scanner_functions = ['{VarName}.nextInt()','{VarName}.nextLong()','{VarName}.nextFloat()','{VarName}.nextDouble()', '{VarName}.nextShort()', '{VarName}.nextLine()']

def random_short_generator():
	return random.randint(0, 1000)			#Should be 2^-15 to 2^15
	
def random_int_generator():
	return random.randint(0, 2**15 - 1)		#Should be 2^-31 to 2^31
			
def random_long_generator():
	return random.randint(0, 2**31 - 1)		#Should be 2^-63 to 2^63
	
def random_float_generator():
	return round(random.uniform(0, 2**31 - 1),6) 	#Should be 2^-31 to 2^31
		
def random_double_generator():
	return round(random.uniform(0, 2**31 - 1),15)	#Should be 2^-31 to 2^31

def random_string_generator(size=6, chars=string.ascii_uppercase + string.digits):
    return ''.join(random.choice(chars) for x in range(size))

def gen_inputs(input_list):
	test_vals = []
	for func in input_list:
		if("Int" in func):
			test_vals.append(random_int_generator())
		elif("Long" in func):
			test_vals.append(random_long_generator())
		elif("Float" in func):
			test_vals.append(random_float_generator())
		elif("Double" in func):
			test_vals.append(random_double_generator())
		elif("Short" in func):
			test_vals.append(random_short_generator())
		elif("Line" in func):
			test_vals.append(random_string_generator())
	return test_vals
			
test_set = []			
input_list = []

#Create test-set from reference solution

var_name = ""

with open("Reference/"+REF_PATH,'r') as fin:
	lines = fin.readlines()
	for line in lines:
		if('new Scanner(System.in);' in line):
			split_vals = line.split()			### Eg: Scanner sc = new Scanner(System.in);
			var_name = split_vals[1] 			### Eg: sc
			try:
				var_name = var_name.split('=')[0]
			except:
				pass	
			continue
		if(var_name!=""):
			for func_id in range(len(scanner_functions)):
				scanner_functions[func_id] = scanner_functions[func_id].format(VarName=var_name)
				
			for func in scanner_functions:	
				if(func in line):
					input_list.append(func)		### Get all inputs for a program (Eg: int int int)			
	for num_tests in range(MAX_NUM_TESTS):
		test_set.append(gen_inputs(input_list))
				
#Get output for each input		

count = 0
outputs = []
set_test = test_set[:]
os.system("javac " + "Reference/"+REF_PATH)

for test_case in test_set:
	val = " ".join(map(str,test_case))
	os.system("echo " + val + " > auto_gen/test.test")
	os.system("java -ea -cp Reference " + REF_PATH[:len(REF_PATH)-5] + " < auto_gen/test.test > auto_gen/result.result")	# -ea option enables assertions
	with open("auto_gen/result.result",'r') as fout:
		result = fout.readline()
		print(result)
		if(result!=''):
			outputs.append(result)
			count = count + 1
			if(count == 5):
				break
		else:	
			outputs.append(ASSERT_FAIL)		#If file is empty probably assertion failed. Becareful if output is actually empty string, it still comes here.	
	os.system("rm -rf auto_gen/test.test auto_gen/result.result")	

for i in range(len(outputs)):
	if(outputs[i]==ASSERT_FAIL):
		test_set[i] = ASSERT_FAIL

#Store generated input in input_automated.in file
with open(INPUT_TESTSET_FILE_PATH,'w') as fin:
	for i in range(len(outputs)):
		if(test_set[i]!=ASSERT_FAIL):
			fin.write("%s\n"%(" ".join(map(str,test_set[i]))))			
		
#Store generated output in output_automated.out file		
with open(OUTPUT_TESTSET_FILE_PATH,'w') as fin:
	for output in outputs:
		if(output!=ASSERT_FAIL):
			fin.write("%s"%output)				
