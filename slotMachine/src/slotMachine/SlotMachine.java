package slotMachine;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SlotMachine {

	protected Shell shlZhoujackMachines;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SlotMachine window = new SlotMachine();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlZhoujackMachines.open();
		shlZhoujackMachines.layout();
		while (!shlZhoujackMachines.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlZhoujackMachines = new Shell();
		shlZhoujackMachines.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shlZhoujackMachines.setImage(SWTResourceManager.getImage("icon.png"));
		shlZhoujackMachines.setSize(450, 400);
		shlZhoujackMachines.setText("ZHOU&JACK MACHINES");
		
		Button btnReset = new Button(shlZhoujackMachines, SWT.NONE);
		btnReset.setBounds(10, 302, 75, 50);
		btnReset.setText("RESET");
		
		Button btnSpin = new Button(shlZhoujackMachines, SWT.NONE);
		btnSpin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
			         // Open an audio input stream.           
			          File soundFile = new File("sound.mp3"); //you could also get the sound file with an URL
			          AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
			         // Get a sound clip resource.
			         Clip clip = AudioSystem.getClip();
			         // Open audio clip and load samples from the audio input stream.
			         clip.open(audioIn);
			         clip.start();
			      } catch (UnsupportedAudioFileException e1) {
			         e1.printStackTrace();
			      } catch (IOException e1) {
			         e1.printStackTrace();
			      } catch (LineUnavailableException e1) {
			         e1.printStackTrace();
			      }
			}
		});
		btnSpin.setBounds(349, 302, 75, 50);
		btnSpin.setText("SPIN");
		
		Button btnBet = new Button(shlZhoujackMachines, SWT.NONE);
		btnBet.setBounds(91, 302, 75, 50);
		btnBet.setText("BET");
		
		Button btnBetAll = new Button(shlZhoujackMachines, SWT.NONE);
		btnBetAll.setBounds(172, 302, 75, 50);
		btnBetAll.setText("BET ALL");
		
		Label lblSaldo = new Label(shlZhoujackMachines, SWT.NONE);
		lblSaldo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSaldo.setBounds(10, 255, 55, 15);
		lblSaldo.setText("SALDO");
		
		Label lblPuntata = new Label(shlZhoujackMachines, SWT.NONE);
		lblPuntata.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblPuntata.setBounds(192, 255, 55, 15);
		lblPuntata.setText("PUNTATA");
		
		Label lblVincita = new Label(shlZhoujackMachines, SWT.NONE);
		lblVincita.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblVincita.setBounds(349, 255, 55, 15);
		lblVincita.setText("VINCITA");
		
		Label lblSaldonumero = new Label(shlZhoujackMachines, SWT.NONE);
		lblSaldonumero.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSaldonumero.setBounds(10, 234, 55, 15);
		lblSaldonumero.setText("0.0");
		
		Label lblPuntatanumero = new Label(shlZhoujackMachines, SWT.NONE);
		lblPuntatanumero.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblPuntatanumero.setBounds(192, 234, 55, 15);
		lblPuntatanumero.setText("0.0");
		
		Label lblVincitanumero = new Label(shlZhoujackMachines, SWT.NONE);
		lblVincitanumero.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblVincitanumero.setBounds(349, 234, 55, 15);
		lblVincitanumero.setText("0.0");
		
		Label lblA = new Label(shlZhoujackMachines, SWT.NONE);
		lblA.setImage(SWTResourceManager.getImage("crome.jpg"));
		lblA.setBounds(27, 92, 80, 80);
		
		Label lblB = new Label(shlZhoujackMachines, SWT.NONE);
		lblB.setImage(SWTResourceManager.getImage("explorer.png"));
		lblB.setBounds(172, 92, 80, 80);
		
		Label lblC = new Label(shlZhoujackMachines, SWT.NONE);
		lblC.setImage(SWTResourceManager.getImage("nasa.png"));
		lblC.setBounds(305, 92, 80, 80);
		
		Label lblTitolo = new Label(shlZhoujackMachines, SWT.NONE);
		lblTitolo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTitolo.setFont(SWTResourceManager.getFont("Trajan Pro", 16, SWT.BOLD));
		lblTitolo.setBounds(53, 10, 332, 34);
		lblTitolo.setText("JACK  and ZHOU Machines");

	}
}
