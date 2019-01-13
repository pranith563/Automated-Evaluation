import java.util.*;
import java.io.*;


public class main{


	String solutionDir;
	String testInputDir;
	String testOutputDir;

	public static void main(String args[]) throws Exception
	{
		//Reading the file_path names for solutions and test_cases.
		Scanner scanner=new Scanner(new File("path.txt"));
		main m=new main();
	/*
		System.out.print("File-Path for Solutions: ");
		m.solutionDir = scanner.nextLine();

		System.out.println(m.solutionDir);

		System.out.print("File-Path for TestCases Inputs : ");
		m.testInputDir = scanner.nextLine();
		System.out.println(m.testInputDir);

		System.out.print("File-Path for TestCases Outputs : ");
		m.testOutputDir= scanner.nextLine();
		System.out.println(m.testOutputDir);

	*/

		m.solutionDir = "Solutions/src/";
		m.testInputDir = "TestCases/Inputs/";
		m.testOutputDir = "TestCases/Outputs/";
		String referenceSolutionDir = "Reference/";

		System.out.println("\nGenerating Test Cases.....\n");

		m.generateTestCases(referenceSolutionDir);

		HashMap<String, info> runtimes = new HashMap<String,info>();
		HashMap<String, Integer> unusedvars= new HashMap<String,Integer>();
		HashMap<String, Integer> clusters =  new HashMap<String,Integer>();
		HashMap<String, Float> scores = new HashMap<String,Float>();

		RunTimeEvaluator re = new RunTimeEvaluator(m.solutionDir, m.testInputDir, m.testOutputDir);
		UnusedVariables unused=new UnusedVariables();
        cluster c = new cluster();

        ArrayList<String> errorFiles = new ArrayList<String>();    
		try
		{

			System.out.println("\nTesting the Solutions......\n");

			runtimes   =re.calculateRunTimeAndMemory();

			Iterator it = runtimes.keySet().iterator();
   			while (it.hasNext())
   			{
      			String key = it.next().toString();
      			if(runtimes.get(key).avgtime==0)
				{
					errorFiles.add(key);
      				info value = runtimes.get(key);
					it.remove();

      			}
  			}

            unusedvars = unused.findUnusedVars("Solutions/bin");
            clusters   = c.clusterData(runtimes);
            
            System.out.println("\nDisplaying scores of correct Solutions :\n");
            for(String key : clusters.keySet())
            {
            	int count = unusedvars.get(key);
            	int class_cluster = clusters.get(key);
            	System.out.print(key + " : ");
            	float score = m.getScore(count,class_cluster,runtimes.get(key).num_correct);
            	scores.put(key,score);
            	System.out.println(" Score : " +score);
            }

            if(errorFiles.size() > 0)
	            System.out.println("\nDisplaying Incorrect Solutions :\n");
            for(int i=0;i<errorFiles.size();i++)
            	System.out.println(errorFiles.get(i));
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public float getScore(int unusedvars_count, int cluster,float ratio_of_passed_test)
	{
		float score = 80*ratio_of_passed_test;

		if(cluster==0)
			score=score+15;
		else if(cluster==1)
			score = score + 10;
		else 
			score = score + 5;

		if(unusedvars_count >= 10 )
			score = score + 0;
		else if(unusedvars_count >= 6 && unusedvars_count < 10)
			score = score + 1;
		else if(unusedvars_count >= 2 && unusedvars_count < 6)
			score = score + 3;
		else if(unusedvars_count < 2)
			score = score + 5;

		System.out.print(" UnusedVariables : " + unusedvars_count + " TestCasesPassed : " + ratio_of_passed_test*5 + " Cluster_no : " + cluster );

		return score;
	}

public void generateTestCases(String refDirec){

	try{
		
		File referenceFolder = new File(refDirec);
		File [] ref_solutions = referenceFolder.listFiles();
		String ref_solution = "";
		String ref_sol = ref_solutions[0].getName();
		
		if(ref_sol.substring(ref_sol.length()-4,ref_sol.length()).equals("java"))
			ref_solution = ref_sol;
		

		Process p1 = Runtime.getRuntime().exec("python auto_gen/auto_gen.py " + ref_solution);

		while(true){
					if(p1.isAlive())continue;
					else break;
		} 

		File inputFile = new File("TestCases/Inputs");
		File outputFile = new File("TestCases/Outputs");

		boolean Success = inputFile.mkdirs();
		boolean Sucess2 = outputFile.mkdirs();

		generate();


	}

	catch(Exception e){
		System.out.println(" Exception : " + e.getMessage());
		System.out.println("Couldn't generate testcases");
	}

}

public void generate(){

	try{
		
		FileReader iReader = new FileReader("auto_gen/input.in");
		FileReader oReader = new FileReader("auto_gen/output.out");

		int i=0;
		String input,output="",fn;

		BufferedReader ibuffReader = new BufferedReader(iReader);
		BufferedReader obuffReader = new BufferedReader(oReader);

		while((input=ibuffReader.readLine())!=null)
		{
			output = obuffReader.readLine();

			if(i<10)
				fn = "0" + String.valueOf(i);
            else 
            	fn = String.valueOf(i); 
            
            FileWriter fw1=new FileWriter("TestCases/Inputs/input"+fn+".txt");
            
            fw1.write(input + "\n");
			fw1.close();

			FileWriter fw2 = new FileWriter("TestCases/Outputs/output"+fn+".txt");                
			fw2.write(output + "\n");                
            fw2.close();
            i = i+ 1;
		}

      
    }

	catch(Exception e){

			System.out.println("Exception : "+ e.getMessage());

	}

}

}