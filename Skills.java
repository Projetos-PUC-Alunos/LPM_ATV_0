import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Skills{ 
    public static ArrayList<String> listarHabilidades(){
        String path = "Skill.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
			
			String line;
			while ((line = br.readLine()) != null) {
                String prod = line;
                System.out.print(line);
                list.add(prod);
            }
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
        
        return list;
    }

    public static String candidato(int op) {
        int count = 0;
        String name = null;
        int maior  = 0;
        ArrayList<String> CandidateList = Candidate.listarCandidatos();

                while(count < CandidateList.size()){
                    String[] vect = CandidateList.get(count).split(";");
                    
                    if (Integer.parseInt(vect[op]) > maior) {
                        maior = Integer.parseInt(vect[op]);
                        name = vect[0];
                    }
                    count++;
                }
        return name;
    }; 

}