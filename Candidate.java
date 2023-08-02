import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Candidate{ 
    public static ArrayList<String> listarCandidatos(){
        String path = "person.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
			
			String line;
			while ((line = br.readLine()) != null) {
                String prod = line;
                list.add(prod);
            }
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
        
        return list;
    }

    public static String CandidateIdeal(){
        int count = 0;
        int maior = 0;
        String Name = null;
        ArrayList<String> CandidateList = Candidate.listarCandidatos();
        while(count < CandidateList.size()){
            String[] vect = CandidateList.get(count).split(";");
            
            int soma = 0;
            for(int i = 1; i < vect.length; i++){
                soma += Integer.parseInt(vect[i]);
            }
            if (soma > maior) {
                maior = soma;
                Name = vect[0];
            }
            count++;
        }
        return Name;
    }

    public static String CandidatePS(int principal, int secundaria){
        int count = 0;
        int maiorMedia = 0;
        int media = 0;
        String name = null;
        ArrayList<String> CandidateList = Candidate.listarCandidatos();
        while(count < CandidateList.size()){
            String[] vect = CandidateList.get(count).split(";");
            
            int soma = 0;
            for(int i = 1; i < vect.length; i++){
                if(i == principal || i == secundaria)
                soma += Integer.parseInt(vect[i]);
            }
            media = soma/2;
            
            if (media > maiorMedia) {
                maiorMedia = media;
                name = vect[0];
            }
            count++;
        }
        return name;
    }
}