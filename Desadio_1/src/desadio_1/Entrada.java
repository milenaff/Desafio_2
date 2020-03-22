/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desadio_1;
import java.util.Stack;
/**
 *
 * @author miiil
 */

public class Entrada {
    private String dado;
    

    
    public Entrada(String iExpressao){
        this.dado = iExpressao;
    }

    public boolean validarFormacao() {        
        Stack pilha = new Stack();

        for (int i = 0; i < this.dado.length(); i++) {
            if (this.dado.charAt(i) == '{' || this.dado.charAt(i) == '[' || this.dado.charAt(i) == '(') {
                pilha.push(this.dado.charAt(i));
            } else if (this.dado.charAt(i) == ')' || this.dado.charAt(i) == ']' || this.dado.charAt(i) == '}') {
                if (pilha.isEmpty()) {
                    return false;
                } else if (this.dado.charAt(i) == ')' && pilha.peek().equals('(')) {
                    pilha.pop();
                    //calcula
                    continue;
                } else if (this.dado.charAt(i) == ']' && pilha.peek().equals('[')) {
                    pilha.pop();
                    //calcula
                    continue;
                } else if (this.dado.charAt(i) == '}' && pilha.peek().equals('{')) {
                    pilha.pop();
                    //calcular
                    continue;
                }
                return false;
            }
        }
        if(pilha.isEmpty()) return true;
        return false;
    }

    public String getExpressao() {
        return dado;
    }
    
}
