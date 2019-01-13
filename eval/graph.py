import pylab as pl
import numpy as np
x=[]
xticks=[]
y=[]
i=0
f=open("result.txt","r")
for line in f:
	temp=line.split()
	x.append(float(temp[0]))
#xticks.append(temp[0])
	y.append(float(temp[1]))
	i=i+1

#order = np.argsort(y)
#z=np.array(y)[order]
#x=np.array(x)[order]
#print z
#print x
#xticks=np.array(xticks)[order]
#print xticks
#pl.xticks(x,xticks)
#pl.xticks(range(i),xticks,rotation=45)
pl.plot(y,x,'*')
f.close()
pl.show()
