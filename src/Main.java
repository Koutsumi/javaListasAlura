import Compra.Compra;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Qual o valor limite do cartão?");
        double limite = leitura.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while(sair != 0){
            System.out.println("Digite sua compra:");
            String descricao = leitura.next();

            System.out.println("Digite o valor da compra:");
            double valor = leitura.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if(compraRealizada){
                System.out.println("Compra realizada com sucesso!");
                System.out.println("Digite 1 para sair ou 0 para continuar:");

                sair = leitura.nextInt();
            }else {
                System.out.println("Saldo insuficiente.");
                sair = 0;
            }

            System.out.println("Compra realizada:");
            Collections.sort(cartao.getCompras());
            for(Compra c : cartao.getCompras()){
                System.out.println(c.getDescricao() + " - " + c.getValor());
            }
            System.out.println("Saldo do cartão:" + cartao.getSaldo());
        }
    }
}