
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Graph {


	private vertex [] ListOfVertexes;
	private int NumOfEdges;
	private int NumOfVertexes;

	public Graph(String address){

		File file = new File(address);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		

		try {
			fis = new FileInputStream(file);

			// Here BufferedInputStream is added for fast reading.
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);

			// dis.available() returns 0 if the file does not have more lines.
			if(dis.available() != 0){
				
				String line;
				line=dis.readLine();
				NumOfVertexes=Integer.parseInt(line);

				line=dis.readLine();
				NumOfEdges=Integer.parseInt(line);
				ListOfVertexes=new vertex[NumOfVertexes];
				for(int i=0;i<NumOfVertexes;i++){
					ListOfVertexes[i]= new vertex(i, Double.POSITIVE_INFINITY);	
				}

				String[] arr=new String[3];

				for(int i=0;i<NumOfEdges;i++) {
					
					line=dis.readLine();
					arr=line.split(" ");
					ListOfVertexes[Integer.parseInt(arr[0])].edges.add(new edge(Integer.parseInt(arr[1]),Double.parseDouble(arr[2])));
					ListOfVertexes[Integer.parseInt(arr[1])].edges.add(new edge(Integer.parseInt(arr[0]),Double.parseDouble(arr[2])));




				}
			}
			
			// dispose all the resources after using them.
			fis.close();
			bis.close();
			dis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	public vertex[] getListOfVertexes() {
		return ListOfVertexes;
	}



//	public void setListOfVertexes(vertex[] listOfVertexes) {
//		ListOfVertexes=new vertex[listOfVertexes.length];
//		for (int i = 0; i < listOfVertexes.length; i++) {
//			ListOfVertexes[i]=new vertex(listOfVertexes[i]);
//		}
//		NumOfVertexes=listOfVertexes.length;
//	}



	public int getNumOfEdges() {
		return NumOfEdges;
	}



	public void setNumOfEdges(int numOfEdges) {
		NumOfEdges = numOfEdges;
	}



	public int getNumOfVertexes() {
		return NumOfVertexes;
	}



	public void setNumOfVertexes(int numOfVertexes) {
		NumOfVertexes = numOfVertexes;
	}

}
