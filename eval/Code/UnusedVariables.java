import org.apache.bcel.Repository;
import org.apache.bcel.classfile.*;
import org.apache.bcel.generic.*;
import java.util.*;
import java.io.*;

public class UnusedVariables
{

    public HashMap<String,Integer> class_vars;

    public int getUnusedLocalVariables(Method m,String classname,ConstantPoolGen cpg, ConstantPool cp)
    {
        HashMap<String,Integer> vars_count= new HashMap<>();
        int count=0;
        String mName=m.toString();
        String[] args1 = mName.split("\\(");
        String[] args = args1[1].split("\\)");
        String [] arguments;
        if(args.length > 0 )
           arguments=args[0].split(",");
        else{
           arguments = new String[0];
        }

        for(int i=0;i<arguments.length;i++)
        {
            String[] arg=arguments[i].split(" ");
            String arg_name=arg[arg.length-1];
        //    if(i==arguments.length-1)
        //        arg_name=arg_name.substring(0, arg_name.length() - 1);
//            System.out.println(arg_name);
            vars_count.put(arg_name,1);
        }

        LocalVariableTable lvt = m.getLocalVariableTable();
        MethodGen mg = new MethodGen(m, classname, cpg);
        InstructionList il = mg.getInstructionList();
        InstructionHandle[] ihs = il.getInstructionHandles();
        for(int i=0; i < ihs.length; i++) 
        {
            InstructionHandle ih = ihs[i];
            Instruction instruction = ih.getInstruction();
            if(instruction instanceof LocalVariableInstruction)
            {
                LocalVariableInstruction lvi = (LocalVariableInstruction)instruction;
                if(lvt!=null)
                {
                    int index = lvi.getIndex();
                    LocalVariable lv = lvt.getLocalVariable(index);
                    if(lv!=null)
                    {
                        String var=lv.getName();
                        if(!var.equals("this"))
                        {
                            if(vars_count.containsKey(var))
                                vars_count.put(var,vars_count.get(var)+1);
                            else
                                vars_count.put(var,1);
                        }
                    }
                }    
            }
            else if (instruction instanceof GETFIELD)
            {
                GETFIELD getfield = (GETFIELD)instruction;
                int index = getfield.getIndex();
                Constant constant = cp.getConstant(index);
                if (constant instanceof ConstantFieldref)
                {
                    ConstantFieldref cfr = (ConstantFieldref)constant;
                    Constant constant2 = cp.getConstant(cfr.getNameAndTypeIndex());
                    if (constant2 instanceof ConstantNameAndType)
                    {
                        ConstantNameAndType cnat = (ConstantNameAndType)constant2;
                        if(class_vars.containsKey(cnat.getName(cp)))
                            class_vars.put(cnat.getName(cp),class_vars.get(cnat.getName(cp))+1);
                    }
                }
            }
        }
        for(String varName:vars_count.keySet())
        {
            if(vars_count.get(varName)==1)
            {
                count++;
            }
        }
        return count;
    }


    public int countUnusedVariables(String className) throws ClassNotFoundException
    {
        JavaClass c = Repository.lookupClass(className);
        ConstantPool cp = c.getConstantPool();
        ConstantPoolGen cpg = new ConstantPoolGen(cp);
        int num=0;
        int count=0,sum=0;
        class_vars = new HashMap<>();
        Field[] f = c.getFields();
        for(int i=0;i<f.length;i++)
            class_vars.put(f[i].getName(),1);

        for (Method m : c.getMethods())
        {
            if(num>0)
            {
                count=getUnusedLocalVariables(m,className,cpg,cp);
                sum=sum+count;
            }
            num++;
        }

        for(String varName:class_vars.keySet())
            if(class_vars.get(varName)==1)
                sum++;
        return sum;
    }

    public HashMap<String, Integer> findUnusedVars(String classDir)
    {
        HashMap<String,Integer> unused_count = new HashMap<>();
        File class_folder = new File(classDir);
        File [] classFiles = class_folder.listFiles();

        ArrayList<String> solutions = new ArrayList<String>();

        for(int i=0;i< classFiles.length;i++)
        {

                if(classFiles[i].isFile()){
                        String filename = classFiles[i].getName();
                        String name;
                        if(filename.substring(filename.length()-5,filename.length()).equals("class"))
                        {
                            name = filename.substring(0,filename.length()-6);
                            solutions.add(name);
                        }
                }
        }

        Collections.sort(solutions);
        
        try
        {
            for(int i=0;i<solutions.size();i++)
            {
                String c_name = solutions.get(i);
                int count=countUnusedVariables("Solutions.bin."+c_name);
                unused_count.put(c_name,count);
                //System.out.println(c_name + " : " + count);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }    

        return unused_count;

    }

}
