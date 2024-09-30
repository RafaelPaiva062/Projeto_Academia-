package academia;
import java.util.Scanner;

public class PlanoDeAssinatura  {
    private  static Scanner sc = new Scanner(System.in);
    private  int plano;
    private double precoplano ;
    private int diasRegistrados ;
    public PlanoDeAssinatura(int plano, double precoplano,int diasRegistrados)
    {
        this.plano = plano;
        this.precoplano = precoplano;
        this.diasRegistrados = diasRegistrados;

    }
    public int getPlano()
    {
        return plano;
    }
    public void setPlano( int plano)
    {
       this.plano = plano;
    }
    public double getPrecoplano()
    {
        return precoplano;
    }
    public void setPrecoplano(double precoplano)
    {
        this.precoplano = precoplano;
    }
    public int getDiasRegistrados()
    {
        return diasRegistrados;
    }
    public void setDiasRegistrados( int diasRegistrados)
    {
        this.diasRegistrados = diasRegistrados;
    }
}
