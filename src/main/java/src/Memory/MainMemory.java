package src.main.java.src.Memory;

import java.io.FileNotFoundException;
import src.main.java.src.Archives.ReadArchieve;
import src.main.java.src.Archives.SaveArchieve;

public class MainMemory{
	private static final int MEMORY_SIZE = 4096;
	static MemoryLine[] memory_line;
	
	static ReadArchieve read;
	static SaveArchieve save;

	public MainMemory() throws FileNotFoundException{
		read = new ReadArchieve("memory.out");
		save = new SaveArchieve("memory.out");
		MainMemoryInit();
	}
	
	
	public static void startMemory() throws FileNotFoundException{
		MemoryLine aux;
		memory_line = new MemoryLine[MEMORY_SIZE];

		String[] buffer = read.getFileInArrayFormat();
		String[] pieces;

		for(int i = 0; i < MEMORY_SIZE; i++){
			pieces = buffer[i].split(" ", -1);
			aux = new MemoryLine(pieces[0], pieces[1]);

			memory_line[i] = aux;
		} 
	}

	public static void MainMemoryInit(){
		int linha1 = 0;
		String linha = "";
		
		for(int i = 0; i < MEMORY_SIZE; i++){
			if(i <= 15){
				linha = "0x0" + Integer.toHexString(linha1) + " " + "0x" + "00000000";
			} else {
				linha = "0x" + Integer.toHexString(linha1)  + " " + "0x" + "00000000"; 
			}

		save.write(linha);
			linha1 += 16;
		}
		
		save.ArchiveClose();
	}

	public static void MainMemorySave(){
		String linha = "";
		save = new SaveArchieve("memory.out");

		for(int i = 0; i < MEMORY_SIZE; i++){
			linha = memory_line[i].getAddress() + " " + memory_line[i].getContent();
			save.write(linha);
		}

		save.ArchiveClose();
	}
	
	public static void setMemorySlot(int NumberSlot, String data){
		memory_line[indexMemoryArray(NumberSlot)].setContent(data);		
	}	
	
	public static MemoryLine getMemorySlot(int NumberDecimal){
		return memory_line[indexMemoryArray(NumberDecimal)];
	}

	public static int indexMemoryArray(int MemoryAddress){
		return (MemoryAddress/16);
	}
}
