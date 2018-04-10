package somethingfunctional;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Principal {

    public static void main(String[] args) {
        
        final long tamanho = 200;
        Random r = new Random();
        IntStream listaGerada = IntStream.generate(() -> r.nextInt());
        
        //Lista com 1000 números primos!
        Set<Integer> listaDeNumerosPrimos = listaGerada.filter(n -> isPrime(n) && n > 0).limit(tamanho)
                .boxed().collect(Collectors.toCollection(HashSet::new));
        //Lista com 1000 numeros aleatorios
        listaGerada = IntStream.generate(() -> r.nextInt());
        Set<Integer> listaDeNumerosAleatorios = listaGerada.filter(n -> n > 0).boxed().limit(tamanho)
                                                .collect(Collectors.toCollection(HashSet::new));
        
        
        long quantidadeDeNumerosAleatoriosPrimos = listaDeNumerosAleatorios.stream().filter(n -> isPrime(n)).count();
        long quantidadeDeNumerosAleatoriosPares = listaDeNumerosAleatorios.stream().filter(n -> n % 2 == 0).count();
        
        long quantidadeDeNumerosAleatoriosCompostos = tamanho - quantidadeDeNumerosAleatoriosPrimos;
        long quantidadeDeNumerosAleatoriosImpares = tamanho - quantidadeDeNumerosAleatoriosPares;
        
        double porcentagemDeNumerosAleatoriosPares = (quantidadeDeNumerosAleatoriosPares*100)/(double)tamanho;
        double porcentagemDeNumerosAleatoriosImpares = (quantidadeDeNumerosAleatoriosImpares*100)/(double)tamanho;
        double porcentagemDeNumerosAleatoriosPrimos = (quantidadeDeNumerosAleatoriosPrimos*100)/(double)tamanho;
        double porcentagemDeNumerosAleatoriosCompostos = (quantidadeDeNumerosAleatoriosCompostos*100)/(double)tamanho;
        
        System.out.println("Quantidade de números compostos: "+quantidadeDeNumerosAleatoriosCompostos);
        System.out.println("Quantidade de números primos: "+quantidadeDeNumerosAleatoriosPrimos);
        System.out.println("Quantidade de números pares: "+quantidadeDeNumerosAleatoriosPares);
        System.out.println("Quantidade de números ímpares: "+quantidadeDeNumerosAleatoriosImpares);
        System.out.println("Quantidade total de números: "+tamanho);
        System.out.println();
        System.out.println("Porcentagem de números pares: "+porcentagemDeNumerosAleatoriosPares+"%");
        System.out.println("Porcentagem de números ímpares: "+porcentagemDeNumerosAleatoriosImpares+"%");
        System.out.println("Porcentagem de números primos: "+porcentagemDeNumerosAleatoriosPrimos+"%");
        System.out.println("Porcentagem de números compostos: "+porcentagemDeNumerosAleatoriosCompostos+"%");
        
    }

    private static boolean isPrime(int numero) {
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
