import java.util.*;
import java.io.*;
import java.lang.Math;
public class cluster{
		
		info min,max;

		public cluster(){

				min = new info(0,0,0);
				max = new info(0,0,0);

		}


	public HashMap<String, Integer> clusterData(HashMap<String,info> data)
	{

		HashMap<String,Integer> clusteredData= new HashMap<String,Integer>();		
		try{	

			ArrayList <String> names = new ArrayList<String>(); 
			ArrayList <info> Info = new ArrayList<info>();

			for(String key : data.keySet())
			{
				Info.add(data.get(key));
				names.add(key);
			}

			findMinMax(Info,2);

			info[] means = {min,new info((min.avgmemory+max.avgmemory)/2,(min.avgtime+max.avgtime)/2,0),max};
			System.out.println(min.avgtime);
			boolean noChange;

			int clusterSize[] = {0,0,0};

			int belongsTo [] = new int[Info.size()];

			for (int ik=0;ik<belongsTo.length;ik++) {
				belongsTo[ik] = -1;
			}

			//Executing k-means
			for(int it=0;it<100000;it++){

				noChange = true;
				for(int item=0;item<Info.size();item++){

						info itemT = Info.get(item);

						int index = classify(means,itemT);
						clusterSize[index] += 1;

						int cSize = clusterSize[index];

						means[index] = Updatemean(cSize,means[index],itemT);

						if(index != belongsTo[item])
							noChange = false;

						belongsTo[item] = index;
				}

				 if(noChange)break;

			}

			for(int i=0; i < names.size();i++){

					clusteredData.put(names.get(i),belongsTo[i]);

			}
	

		}

		catch(Exception e){

			e.printStackTrace();

		}
		return clusteredData;

	}

	public void findMinMax(ArrayList<info> items,int nf)
	{

		info minima = new info(Integer.MAX_VALUE,Integer.MAX_VALUE,0); 
		info maxima = new info(-1,-1,0);

		for (info item :  items){
				if(item.avgtime < minima.avgtime)
					minima.avgtime = item.avgtime;

				if(item.avgtime > maxima.avgtime)
					maxima.avgtime = item.avgtime;

				if(item.avgmemory < minima.avgmemory)
					minima.avgmemory = item.avgmemory;

				if(item.avgmemory > maxima.avgmemory)
					maxima.avgmemory = item.avgmemory;
		} 

//		System.out.println("Min memory,run : " + minima.avgtime + " " + minima.avgmemory);

		min = minima;
		max = maxima;
	}


	public info Updatemean(int n,info mean,info item){
			
			mean.avgtime = (mean.avgtime*(n-1) + item.avgtime)/n;
			mean.avgmemory = (mean.avgmemory*(n-1) + item.avgmemory)/n;

			return mean;
	}

	public double distance(info x, info y){

			return Math.sqrt(Math.pow(x.avgtime - y.avgtime,2.0)+Math.pow(x.avgmemory - y.avgmemory,2.0));

	}

	public int classify(info[] means,info item){

			
			double minima = distance(item,means[0]);
			int index = 0;

			for(int i=1;i<means.length;i++){

					double dis = distance(item,means[i]);

					if(dis < minima){
						minima = dis;
						index = i;
					}

			}
			return index;
	}

}
