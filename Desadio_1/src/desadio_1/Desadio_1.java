/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desadio_1;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 *
 * @author miiil
 */
public class Desadio_1 {


    public static ArrayList <String> GetArrayList (String nome) 
    {
        ArrayList<String> lista  = new ArrayList<String>();
        try
        {                    
                           
		InputStream is = new FileInputStream(nome);                        
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		while (line != null) {
                          
			line = br.readLine();
                        lista.add(line);			
		}                        
		br.close(); 
        }
        catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
        }
        return lista;
    }
    public static void main(String[] args) {          
                
        System.out.println("Digite o caminho do arquivo: ");
        Scanner sc = new Scanner(System.in);
        String caminho = sc.nextLine();
        String respostaLinha="";
                
        ArrayList<String> lista= new ArrayList<String>();
        lista= GetArrayList(caminho);
        for(int i=0;i<lista.size();i++)
        { 
            Entrada entrada = new Entrada(lista.get(i));        
        if(lista.get(i)!=null)
        {
           respostaLinha=lista.get(i);
            if(entrada.validarFormacao()) {
                respostaLinha+=(" Ok");
            } else { 
                respostaLinha+=(" Inválido");
                } 
            EscreveResposta (respostaLinha,"Output.txt"); // Escreve resposta no arquivo texto chamado Output, na ppasta Default do projeto
            } 
                 
        }
        
       
        
       
    }
    
    public static void EscreveResposta (String resp, String file)
    {
        try {
        
            FileWriter fileWriter =
                new FileWriter(file, true);            
          
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
        
            bufferedWriter.append(resp+"\n"); 

            bufferedWriter.close();
            }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + file + "'");
        }
    
    }
}
