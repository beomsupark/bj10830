import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static int[][] matrix;
	static int[][] answer;
	public static void main(String[] args) throws IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		n= Integer.parseInt(s[0]);
		long p= Long.parseLong(s[1]);
		matrix = new int[n][n];
		answer = new int[n][n];
		for(int i=0;i<n;i++)
		{
			s = bf.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				matrix[i][j]=Integer.parseInt(s[j]);
				if(i==j)
				{
					answer[i][j]=1;
				}
			}
		}
		pow(p);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int[][] pow(long p)
	{
		while(p>0)
		{
			if(p%2==1)
			{
				answer = multi(answer,matrix);
			}
			matrix  = multi(matrix,matrix);
			p=p/2;
			
		}
		return answer;
	}
	public static int[][] multi(int[][] a,int[][] b)
	{
		int[][] temp = new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				for(int m=0;m<n;m++)
				{
					temp[i][j]+=(a[i][m]*b[m][j])%1000;
				}
				temp[i][j] %=1000;
			}
		}
			
		return temp;
		
	}
}

