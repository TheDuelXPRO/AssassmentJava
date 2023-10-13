abstract class Personagem {
    private String nome;
    private int pdv; // ponto de vida
    private int forca;
    private int defesa;
    private int agilidade;
    private String fdp;  // fdp fator de dano
    private String classe; 

    public Personagem(String nome, String classe, int pdv, int forca, int defesa, int agilidade, String fdp) {
        this.nome = nome;
        this.pdv = pdv;
        this.forca = forca;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.fdp = fdp;
        this.classe = classe;
    }
}
