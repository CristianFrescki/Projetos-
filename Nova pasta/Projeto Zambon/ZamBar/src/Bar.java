public class Bar {
    public static void main(String[] args) {
       
        if (args.length < 4) {
            System.out.println("Por favor, forneça os seguintes dados na ordem: ");
            System.out.println("1. Sexo (F ou M)");
            System.out.println("2. Quantidade de cervejas");
            System.out.println("3. Quantidade de refrigerantes");
            System.out.println("4. Quantidade de espetinhos");
            return;
        }

       
        char sexo = args[0].charAt(0);  
        int quantidadeCervejas = Integer.parseInt(args[1]);  
        int quantidadeRefrigerantes = Integer.parseInt(args[2]);  
        int quantidadeEspetinhos = Integer.parseInt(args[3]);  

       
        double precoIngressoHomem = 10.00;
        double precoIngressoMulher = 8.00;
        double precoCerveja = 5.00;
        double precoRefrigerante = 3.00;
        double precoEspetinho = 7.00;
        double couvert = 4.00;

       
        double consumoCerveja = quantidadeCervejas * precoCerveja;
        double consumoRefrigerante = quantidadeRefrigerantes * precoRefrigerante;
        double consumoEspetinho = quantidadeEspetinhos * precoEspetinho;
        double totalConsumo = consumoCerveja + consumoRefrigerante + consumoEspetinho;

        
        double ingresso;
        if (sexo == 'M' || sexo == 'm') {
            ingresso = precoIngressoHomem;
        } else {
            ingresso = precoIngressoMulher;
        }

        
        if (totalConsumo > 30) {
            couvert = 0;  
        }

       
        double valorTotal = totalConsumo + couvert + ingresso;

        
        System.out.println("\nRELATÓRIO:");
        System.out.printf("Consumo = R$ %.2f%n", totalConsumo);
        if (couvert == 0) {
            System.out.println("Isento de Couvert");
        } else {
            System.out.printf("Couvert = R$ %.2f%n", couvert);
        }
        System.out.printf("Ingresso = R$ %.2f%n", ingresso);
        System.out.printf("Valor a pagar = R$ %.2f%n", valorTotal);
    }
}
