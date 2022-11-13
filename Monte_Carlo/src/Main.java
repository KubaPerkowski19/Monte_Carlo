import java.util.Random;

class Carlo extends Thread
{
    int position;
    Carlo(int position){
        this.position = position;
    }
    double rx;
    double ry;
    double pi=0;
    int hit = 0;
    int total = 0;
    Random rand = new Random();
    public void run ()
    {
        for (int i = 0; i < position; i++) {
            rx = rand.nextDouble();
            ry = rand.nextDouble();
            if (Math.pow(rx,2)+Math.pow(ry,2)<=1){
                hit++;
            }
            total++;
            pi = (double)(4 * hit) / total;
        }
        System.out.println("END/"+ position +"\n");
    }
}
public class Main
{
    public static void main (String [] args)
    {
        Carlo crl = new Carlo(1000000);
        Carlo crl2 = new Carlo(10000000);
        Carlo crl3 = new Carlo(100000000);
        crl.start ();
        crl2.start ();
        crl3.start ();
        try
        {
            crl.join ();
            crl2.join ();
            crl3.join ();
        }
        catch (InterruptedException e)
        {
        }
        System.out.println ("\n"+crl.position +"/PI=" + crl.pi);
        System.out.println (crl2.position +"/PI=" + crl2.pi);
        System.out.println (crl3.position +"/PI=" + crl3.pi);
    }
}
