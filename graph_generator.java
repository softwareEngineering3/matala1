

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class graph_generator {
	public static void main(String[] args) {
		System.out.println("hello from lior");
		Scanner in = new Scanner(System.in);
		System.out.println("how much files do you want??");
		int num=in.nextInt();
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("creating into "+s);
		for(int i=0;i<num;i++){
			try{
				PrintWriter writer = new PrintWriter("graph"+i+".txt", "UTF-8");
				int vertexes=(int) (Math.random() * (2000 - 1) + 1);
				writer.println(vertexes  );// num of vertexes
				int maxV=(vertexes)*(vertexes-1)/2;
				int edges=(int) (Math.random() * ( vertexes- maxV)) + maxV;
				writer.println(edges );
				for(int j=0;j< edges;j++){
					writer.println((int) (Math.random() * (vertexes - 1)) +1 +" "+(int) (Math.random() * (vertexes - 1)) +1
							+" "+ (float)(Math.random() * 200) +1);
				}
				writer.close();
			} catch (Exception e) {
				System.out.println("error");
			}
		}	
	}		
}
