import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Main {

	static int member = 4;
	static Agent agents[];
	static double H[][];

	public static void main(String[] args) {

		int i,j,k;
		Random rnd = new Random();
		double r;
		agents = new Agent[member];
		H = new double[member][member];
		double total=0;

		// 二重確率行列
		H[0][0] = 2; H[0][1] = 1; H[0][2] = 1; H[0][3] = 0;
		H[1][0] = 1; H[1][1] = 2; H[1][2] = 0; H[1][3] = 1;
		H[2][0] = 1; H[2][1] = 0; H[2][2] = 2; H[2][3] = 1;
		H[3][0] = 0; H[3][1] = 1; H[3][2] = 1; H[3][3] = 2;

		for(i=0;i<member;i++)
			agents[i] = new Agent();

		for(i=0;i<member;i++)
			for(j=0;j<member;j++)
				H[i][j] /= member;

		// 2次関数およびその微分の係数
		agents[0].setA(1);
		agents[0].setB(5);
		agents[0].setC(3);
		agents[0].setAd(2);
		agents[0].setBd(5);

		agents[1].setA(2);
		agents[1].setB(7);
		agents[1].setC(-2);
		agents[1].setAd(4);
		agents[1].setBd(7);

		agents[2].setA(3);
		agents[2].setB(-8);
		agents[2].setC(6);
		agents[2].setAd(6);
		agents[2].setBd(-8);

		agents[3].setA(4);
		agents[3].setB(-4);
		agents[3].setC(-7);
		agents[3].setAd(8);
		agents[3].setBd(-4);

		// 初期値：-9~9
		for(i=0;i<member;i++) {
			r = (double)rnd.nextInt(19)-9;
			agents[i].setX(r);
		}

		try {
			FileWriter fw = new FileWriter("DO.csv",false);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

			for(i=0; i<member; i++) {
				pw.print(agents[i].getX()+",");
				agents[i].setF();
				total += agents[i].getF();
			}
			pw.println(total);

			for(i=1;i<100;i++) {

				total = 0;

				// step3
				for(j=0;j<member;j++) {
					agents[j].setY(0);
					for(k=0;k<member;k++)
						agents[j].addY(agents[k].getX()*H[j][k]);
				}

				// step4
				for(j=0;j<member;j++) {
					agents[j].setX(agents[j].getY() - (agents[j].getAd() * agents[j].getY() + agents[j].getBd())/i);
					agents[j].setF();
					total += agents[j].getF();
				}

				for(j=0; j<member; j++) {
					pw.print(agents[j].getX()+",");
				}
				pw.println(total);
			}
			pw.close();
		} catch(IOException e) {
			System.out.println("File write error : " + e);
		}
	}
}
