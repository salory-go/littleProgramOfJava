package pairwork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws Exception {
        Eval eval = new Eval();
        caculate ca =new caculate();
        ArrayList<String> str = new ArrayList<>();
        String[] strs = new String[]{"ssss","aaaaaa"};

        str.add("$");
        int repeat = 0;
        repeatTest re1 = new repeatTest();
        PrintWriter fw = new PrintWriter("exercise.txt");
        PrintWriter wd = new PrintWriter("answers.txt");
        for (int i = 0; i < 999 ; i++) {
            StringBuffer sb =new StringBuffer();
            String gen1 = ca.generate(100, 5, true);
            sb.append(gen1);
            sb.append(" ");
            sb.append(eval.eval(gen1));
            String gen =sb.toString();
            if(!re1.Test(gen,str)){
                str.add(gen);
                fw.println(i + 1 + ": " + gen1);
                String[] str0 =gen.split(" ");
                wd.println(i + 1 +": " +str0[str0.length-1]);
            }
            else{
                repeat++;
            }
        }
        fw.close();
        wd.close();

//        BufferedReader reader1 = new BufferedReader(new FileReader("givenExercise.txt"));
//        BufferedReader reader2 = new BufferedReader(new FileReader("givenAnswer.txt"));
//
//        String a = reader1.readLine();
//        String b = reader2.readLine();
//
//
//        String[] exercise ;
//        String[] answer ;
//
//
//        ArrayList<String> correct = new ArrayList<>();
//        ArrayList<String> wrong = new ArrayList<>();
//        ArrayList<String> exercises = new ArrayList<>();
//        exercises.add("$");
//
//        ArrayList<String> repeats = new ArrayList<>();
//        while(a!=null){
//            double v = 0.0;
//            exercise = a.split(":");
//            answer = b.split(":");
//            if(eval.eval(exercise[1])!=Double.parseDouble(answer[1])){
//                wrong.add(exercise[0]);
//            }else{
//                correct.add(exercise[0]);
//            }
//            System.out.println(exercise[1]);
//            System.out.println(exercises);
//            if(re1.Test(exercise[1],exercises)){
//                String c = re1.repeat(exercise[1],exercises);
//                repeats.add(exercise[1]+" Repeat "+c);
//            }
//            exercises.add(exercise[1]);
//
//            a = reader1.readLine();
//            b = reader2.readLine();
//
//        }
//        System.out.println("Correct:"+correct.size()+correct);
//        System.out.println("Wrong:"+wrong.size()+wrong);
//        System.out.println("Repeat:"+repeats.size());
//        System.out.println("RepeatDetail:");
//        for (int i=0;i<repeats.size();i++){
//            System.out.println(i+1+")"+repeats.get(i));
//        }
    }
}
