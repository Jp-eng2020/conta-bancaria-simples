/**
 * @author bruno
 *
 */
import java.util.ArrayList;
import java.util.List;

public class Conta{
    private int cont = 0;
    private int numero;
    private double saldo;
    private double limite = 100;
    private List<Double> extrato = new ArrayList();
    
    

    public Conta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    
    
    public int getNumero() {
        return numero;
       
    }
    
    public double getSaldo() {
    
        
        return saldo + limite;
    }

    
    public double getLimite() {
        return limite;
    }
    
    public boolean sacar(double valor) {
        if (valor<=0) {
            return false;
            
        }
        if (valor > saldo + limite) {
            return false;
            
        }
        if (valor< saldo + limite) {
            if (valor>saldo) {
               
                valor = valor - saldo;
                saldo = 0;
                limite =  limite - valor;
                valor = 0;
               
                return true;
               
                
            }
            saldo -= valor;
            return true;
        }
     return false;
    }

   
    public boolean depositar(double valor) {
       if (valor<=0){
           return false;
       }
     if (limite < 100) {
         double difereca = 100 - limite;
         if (difereca > valor) {
             limite += valor;
         }
        limite = 100;
        valor -= difereca;
        saldo = valor;
        

     }
     saldo += valor;
       
       return true;
    }

    
    public boolean transferir(Conta destino, double valor) {
       if (valor<=0) {

            return false;    

        
       }
       if (valor <= limite) {
           limite -= valor;
           return true;
           
       }
       if (valor < saldo + limite) {
                     
       if (valor < saldo) {
            saldo -= valor;
        return true;      
    }
        valor -= saldo;
        saldo =0;
        limite -= valor;
        return true;

    }
   return false;
    }

    public double[] verExtrato() {
        //extrato.add(saldo);
        
        return null;
    }
}
