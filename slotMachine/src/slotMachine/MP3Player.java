package slotMachine;

import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;

public class MP3Player {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File file = new File("src/audio/coin_insert.mp3");
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			try {
				Player player = new Player(bis);
				player.play();
			} catch (JavaLayerException ex){}
		} catch (IOException e){}
	}

}
