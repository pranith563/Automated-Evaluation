import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class RunTimeEvaluator{

	String solutions_path;
	String readInput;
	String readOutput;
	static String memInfo;
	static int TIME_OUT;

	public RunTimeEvaluator(String solutions,String Inputs,String Outputs)
	{
		this.TIME_OUT = 4;
		this.solutions_path = solutions;
		this.readInput = Inputs;
		this.readOutput = Outputs;
	}


public HashMap<String,info> calculateRunTimeAndMemory() throws Exception 
{

		
		File input_folder = new File(readInput);
		File [] inputFiles = input_folder.listFiles();
	

		ArrayList <String> inputs = new ArrayList<String>();
		ArrayList <String> outputs = new ArrayList<String>();

		File solutions_folder = new File(solutions_path);
		File [] solutionFiles = solutions_folder.listFiles();

		ArrayList<String> solutions = new ArrayList<String>();

		for(int i=0;i< solutionFiles.length;i++)
		{
			if(solutionFiles[i].isFile())
			{
				String name = solutionFiles[i].getName();
				if(name.substring(name.length()-4,name.length()).equals("java"))
					solutions.add(name);
			}

		}

		Collections.sort(solutions);

		for(int i=0; i < inputFiles.length; i++)
		{
			if(inputFiles[i].isFile())
			{
				String inFile = inputFiles[i].getName();
				if(inFile.substring(0,5).equals("input"))
				{
					inputs.add(readInput+inFile);
					outputs.add(readOutput+"output"+inFile.substring(5,inFile.length()));
				}
			}
		}

		String testInputs[] = inputs.toArray(new String[inputs.size()]);
		String testOuts[]   = outputs.toArray(new String[outputs.size()]);
	
		HashMap<String,info> information = new HashMap<>();
	
		double runtime[] = new double[testInputs.length];
		double memory[] = new double[testInputs.length];
		Process p,p2;

		String inputFile;
		for(int f=0;f< solutions.size();f++)
		{

			String c_name = solutions.get(f).substring(0,solutions.get(f).length()-5);
			String c_path= solutions_path;

			inputFile = c_path + c_name;
			c_path = c_path.substring(0,c_path.length()-1);

		   
			String temp1="javac -g -d Solutions/bin " + inputFile +".java";
			String temp2="java -cp " + "Solutions/bin" +" " + c_name ;
		
			BufferedReader inStream=null;
			BufferedReader memStream=null;
			double avgtime;
			double avgmemory;
			int count;
			try{

				p = Runtime.getRuntime().exec(temp1);

				InputStream compileError = p.getErrorStream();

				while(true){
						if(p.isAlive()) continue;
						else break;
				}

				File classFile = new File("Solutions/bin/" + c_name + ".class");

				if(classFile.exists() && !classFile.isDirectory()){

					int flag=1;
					count = 0 ;
				
					System.out.println("\n"+c_name);

					long pid;
					//Process p3 = Runtime.getRuntime().exec("./jpsstat.sh");
					for(int i=0;i<testInputs.length;i++) 
					{
			
						FileInputStream inputStream = new FileInputStream(testInputs[i]); 

						long starttime=System.nanoTime();

  						p2 = Runtime.getRuntime().exec(temp2); // running the class file

  						pid=p2.pid();

  						System.out.print("Testcase " + i + " : ");


  						OutputStream proIn =  p2.getOutputStream();
  						
  						InputStream runError = p2.getErrorStream();
						
						boolean timedOut = false;
  						long endtime=0;
  						long totalTime=0;
  						String mem = "0";
  						double mem_d=0;

  						int returnval = giveInput(inputStream,proIn,pid,p2); 
						
  						if(returnval==1)
  						{

  							 endtime=System.nanoTime();
							 totalTime=endtime-starttime;
							String mem_string [] = memInfo.split("\\s+");
							mem_d= (Double.parseDouble(mem_string[3]) + Double.parseDouble(mem_string[4]) + Double.parseDouble(mem_string[6]) + Double.parseDouble(mem_string[8]))/1024;
					
						}
						else
							timedOut = true;

						inStream = new BufferedReader(new InputStreamReader(p2.getInputStream()));						

						//p3 = Runtime.getRuntime().exec("ps -o rss -o vsz -o pid " + pid);
						
						
						
						

						//System.out.println(" mem :" + mem_d);
					

						/*while(true){
							
							if(p2.isAlive()){
								if(!p2.waitFor(TIME_OUT,TimeUnit.SECONDS)){

										System.out.println("Time-Out");
										p2.destroy();
										flag = 0 ;
										runtime[i] = 0;
										memory[i] = 0;
										timedOut = true;
										break;
								}
								else{
									continue;
								}
							}
							else{
								endtime = System.nanoTime();
								totalTime = endtime - starttime;
								break;
							}
						}*/

						if(timedOut) {
							System.out.println("Time-Out");
										p2.destroy();
										flag = 0 ;
										runtime[i] = 0;
										memory[i] = 0;
										continue;
						}
						if(evaluate(inStream,testOuts[i],c_name,p2)==false){
							flag=0;
							runtime[i] = 0;
							memory[i] = 0;
						}

						else{
							runtime[i] = (totalTime/1000000000.0);
							memory[i] = mem_d;
							count++;
						}

						inStream.close();
						proIn.close();
						inputStream.close();
								
					}
					if(Arrays.stream(runtime).sum() == 0 && Arrays.stream(memory).sum()==0)count = 1;
					avgtime= (Arrays.stream(runtime).sum())/count;
					avgmemory = (Arrays.stream(memory).sum())/count;


				}	

				else{

					System.out.println(c_name + " : CompileTimeError");
					avgtime=0;
					avgmemory=0;
					count = 0;
				}

				compileError.close();	

				float ratio = (float)count/testInputs.length;
				info infor = new info(avgmemory,avgtime,ratio);
				information.put(c_name,infor);

		}

		catch(IOException E) {

			E.printStackTrace();

		}

		try{    
       		FileWriter fw=new FileWriter("result.txt");    
        	for(String key : information.keySet()){
        		if((information.get(key).avgmemory!=0) && (information.get(key).avgtime != 0) ){
	        	    fw.write(information.get(key).avgmemory + " " + information.get(key).avgtime);
    	    	    fw.write("\n");    
    			}
     		}
			fw.close();   
        }
        catch(Exception E){
        	E.printStackTrace();
        }

	}
    return information;    
}

public static int giveInput(InputStream input,OutputStream output,long pid,Process p) throws IOException
{
			
	BufferedReader memStream = null;		
	byte buffer[] = new byte[1024];
	int numRead = 0;
	do{
		numRead = input.read(buffer);
		output.write(buffer,0,numRead);
		Process p3 = Runtime.getRuntime().exec("jstat -gc " + pid);
		memStream = new BufferedReader(new InputStreamReader(p3.getInputStream()));
		memInfo = "";
		memInfo = memStream.readLine();
		memInfo = memStream.readLine();
		}
	while(input.available()>0);

	output.flush();

	try{
		 if(!p.waitFor(TIME_OUT,TimeUnit.SECONDS))
		 	return 0;		 
	}
	catch(Exception e){
		e.printStackTrace();
		return 0;
	}
	while(true)
	{
		if(p.isAlive()) continue;
		else return 1;
	}
 }

public boolean evaluate(BufferedReader inStream,String outputFile,String cname,Process p2)
{		
	try
	{
		FileReader fReader = new FileReader(outputFile);
		BufferedReader buffReader = new BufferedReader(fReader);
		String line,answ;
		String [] path = outputFile.split("/");
		String outfile = path[path.length-1];

		while((line=buffReader.readLine())!=null) 
		{
			answ = inStream.readLine();
			if(!(answ.equals(line)))
			{
				System.out.println("Incorrect");
				return false;
			}
		}
		buffReader.close();

		System.out.println("Correct");
		return true;

	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println(e.getMessage() + " Incorrect ");
		return false;
	}
}

}
