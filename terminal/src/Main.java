import java.util.Scanner;
import java.util.ArrayList;


public class Main {
public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Personagem heroi = null;
        boolean FimLoop = true;
        Personagem monstro = null;
        int rodada = 0;
        int valorIniciativaHeroi = 0;
        int valorIniciativaMonstro = 0;
        int danoTotalHeroi = 0;
        int ataqueHeroi = 0;
        int ataqueMonstro = 0;
        int danoTotalMonstro = 0;
        int defesaHeroi = 0;
        int defesaMonstro = 0;
        int vidaHeroi = 0;
        int vidaMonstro = 0;
        String vencedor = null;
        
        

        System.out.println("Iniciando a Batalha...");
        System.out.println("Digite o nome do seu herói: ");
        String nomePersonagem = scan.nextLine();
        System.out.println("Bem vindo ao jogo " + nomePersonagem);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Escolha a classe que mais se adequa ao seu estilo de jogo: ");
        System.out.println("1. Guerreiro : HP= 12 | For= 4 | Def= 3 | Agl= 3 | FDano= 2D4");
        System.out.println("2. Bárbaro : HP= 13 | For= 6 | Def= 1 | Agl= 3 | FDano= 2D6");
        System.out.println("3. Paladino : HP= 15 | For= 2 | Def= 5 | Agl= 1 | FDano= 2D4");
        System.out.println("Escreva o número da classe: ");
        System.out.println("--------------------------------------------------------------------------");
        int classeHeroi = scan.nextInt();
        
        
        if(classeHeroi == 1){
            System.out.println("classe escolhida: Guerreiro");
            heroi = new Heroi(nomePersonagem, "Guerreiro", 12, 4, 3, 3 ,"2D4" );
            valorIniciativaHeroi = new Dados().Dado1D10()+3; 
            ataqueHeroi = new Dados().Dado1D10()+3+4;
            defesaHeroi = new Dados().Dado1D10()+3+3;
            danoTotalHeroi = new Dados().Dado2D6()+4;
            vidaHeroi = 12;
            System.out.println("------------------------------------------------------------------------");
        } else if(classeHeroi == 2){
            System.out.println("classe escolhida: Bárbaro");
            heroi = new Heroi(nomePersonagem, "Bárbaro", 13, 6, 1, 3 ,"2D6" );
            valorIniciativaHeroi = new Dados().Dado1D10()+3;
            ataqueHeroi = new Dados().Dado1D10()+3+6;
            defesaHeroi = new Dados().Dado1D10()+3+1;
            danoTotalHeroi = new Dados().Dado2D6()+6;
            vidaHeroi = 13;
            System.out.println("------------------------------------------------------------------------");
        } else if(classeHeroi == 3){
            System.out.println("classe escolhida: Paladino");
            heroi = new Heroi(nomePersonagem, "Paladino", 15, 2, 5, 1 ,"2D4" );
            valorIniciativaHeroi = new Dados().Dado1D10()+1;
            ataqueHeroi = new Dados().Dado1D10()+1+2;
            defesaHeroi = new Dados().Dado1D10()+1+5;
            danoTotalHeroi = new Dados().Dado2D4()+2;
            vidaHeroi = 15;
            System.out.println("-----------------------------------------------------------------------");
        } else{
        System.out.println("classe escolhida é inválida");
        return;
        }
        
    while(FimLoop){
        System.out.println("monstro será escolhido aleatoriamente: Morto-vivo, Ork, Kobold");
        System.out.println("----------------------------------------------------------------");
            
        int monstroAleatorio = new Dados().Dado1D3();

        if(monstroAleatorio == 1) {
        
                System.out.println("Monstro que voçê enfretara sera o Morto-vivo.");
                monstro = new Monstro("monstro", "Morto-vivo", 25, 4, 0, 1 ,"2D4" );
                valorIniciativaMonstro = new Dados().Dado1D10()+1;
                ataqueMonstro = new Dados().Dado1D10()+1+4;
                defesaMonstro = new Dados().Dado1D10()+1+0;
                danoTotalMonstro = new Dados().Dado2D4()+4;
                vidaMonstro = 25;
        } else if(monstroAleatorio == 2){
                System.out.println("Monstro que voçê enfretara sera o Ork.");
                monstro = new Monstro("monstro", "Ork", 20, 6, 2, 2 ,"1D8" );
                valorIniciativaMonstro = new Dados().Dado1D10()+2;
                ataqueMonstro = new Dados().Dado1D10()+2+6;
                defesaMonstro = new Dados().Dado1D10()+2+2;
                danoTotalMonstro = new Dados().Dado1D8()+6;
                vidaMonstro = 20;
        }else if(monstroAleatorio == 3){
                System.out.println("Monstro que voçê enfretara sera o Kobold.");
                monstro= new Monstro("monstro", "Kobold", 20, 4, 2, 4 ,"3D2" );
                valorIniciativaMonstro = new Dados().Dado1D10()+4;
                ataqueMonstro = new Dados().Dado1D10()+4+4;
                defesaMonstro = new Dados().Dado1D10()+4+2;
                danoTotalMonstro = new Dados().Dado3D2()+4;
                vidaMonstro = 20;
         } else {
                System.out.println("Algum erro ocorreu.");
                return;
         }
       
        while(vidaHeroi >=  0 && FimLoop || vidaMonstro >= 0 && FimLoop){
            rodada++;
            System.out.println("Rodada numero" + rodada + ":");

            System.out.println("Iniciativa do Herói: " + valorIniciativaHeroi);
            System.out.println("Iniciativa do Monstro: " + valorIniciativaMonstro);

            if(valorIniciativaHeroi < valorIniciativaMonstro){
                System.out.println("Monstro ataca primeiro!");
                    if (ataqueMonstro > defesaHeroi) {
                        vidaHeroi -= danoTotalMonstro;
                        System.out.println("Monstro causou " + danoTotalMonstro + " pontos de dano a voçê.");
                    } else {
                        System.out.println("Monstro errou o ataque.");
                    }

                    if (vidaHeroi <= 0) {
                        System.out.println("Monstro venceu a batalha!");
                        FimLoop = false;
                        vencedor = "Monstro";
                    } else {
                        System.out.println("voçê ataca!");
                        if (ataqueHeroi > defesaMonstro) {
                            vidaMonstro -= danoTotalHeroi;
                            System.out.println("Voçê causou " + danoTotalHeroi + " pontos de dano ao Monstro.");
                        } else {
                            System.out.println("Voçê errou o ataque.");
                        }

                        if (vidaMonstro <= 0) {
                            System.out.println("Voçê venceu a batalha!");
                            FimLoop = false;
                            vencedor = "Heroi";
                        }
                    }
            } else if (valorIniciativaHeroi > valorIniciativaMonstro) {
                System.out.println("Voçê ataca primeiro!");

                if (ataqueHeroi > defesaMonstro) {
                    vidaMonstro -= danoTotalHeroi;
                    System.out.println("Voçê causou " + danoTotalHeroi + " pontos de dano ao Monstro.");
                } else {
                    System.out.println("Voçê errou o ataque.");
                }

                if (vidaMonstro <= 0) {
                    System.out.println("Voçê venceu a batalha!");
                    FimLoop = false;
                    vencedor = "Heroi";
                } else {
                    System.out.println("Monstro ataca!");

                    if (ataqueMonstro > defesaHeroi) {
                        vidaHeroi -= danoTotalMonstro;
                        System.out.println("Monstro causou " + danoTotalMonstro + " pontos de dano a voçê.");
                    } else {
                        System.out.println("Monstro errou o ataque.");
                    }

                    if (vidaHeroi <= 0) {
                        System.out.println("Monstro venceu a batalha!");
                        FimLoop = false;
                        vencedor = "Monstro";
                    }
                }
            } else {
                System.out.println("Empate na iniciativa, repetindo o teste.");
            }
        }

        if (vidaHeroi <= 0) {
            System.out.println("Voçê foi derrotado!");
            FimLoop = false;
            vencedor = "Monstro";
        }
        return;
    }
    Relatorio relatorio = new Relatorio();
    relatorio.Log(nomePersonagem, heroi, vencedor ,monstro, rodada);
    }
}



