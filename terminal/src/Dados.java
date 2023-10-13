
public class Dados {
    public int Dado1D10(){
        return (int)Math.floor(Math.random() *(10 - 1 + 1) + 1);
    }
    public int Dado1D8(){
        return (int)Math.floor(Math.random() *(8 - 1 + 1) + 1);
    }
    public int Dado2D4(){
        int dado1 = (int)Math.floor(Math.random() *(4 - 1 + 1) + 1);
        int dado2 = (int)Math.floor(Math.random() *(4 - 1 + 1) + 1);
        return dado1+dado2;
    }
    public int Dado2D6(){
        int dado1 = (int)Math.floor(Math.random() *(6 - 1 + 1) + 1);
        int dado2 = (int)Math.floor(Math.random() *(6 - 1 + 1) + 1);
        return dado1+dado2;
    }
    
    public int Dado3D2(){
        int dado1 = (int)Math.floor(Math.random() *(2 - 1 + 1) + 1);
        int dado2 = (int)Math.floor(Math.random() *(2 - 1 + 1) + 1);
        int dado3 = (int)Math.floor(Math.random() *(2 - 1 + 1) + 1);
        return dado1+dado2+dado3;
    }

    public int Dado1D3(){
        return (int)Math.floor(Math.random() *(3 - 1 + 1) + 1);
    }
}


