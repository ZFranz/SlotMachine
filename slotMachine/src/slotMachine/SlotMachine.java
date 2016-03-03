package slotMachine;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.sound.sampled.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SlotMachine {

	protected Shell shlZhoujackMachines;
	ArrayList<String> immagini = new ArrayList<String>(){{
		add("crome.jpg");
		add("explorer.png");
		add("nasa.png");
	}};
	private int k = 0;

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
		
		Label lblA = new Label(shlZhoujackMachines, SWT.BORDER | SWT.WRAP);
		lblA.setImage(SWTResourceManager.getImage("crome.jpg"));
		lblA.setBounds(27, 92, 80, 80);
		
		Label lblB = new Label(shlZhoujackMachines, SWT.BORDER | SWT.WRAP);
		lblB.setImage(SWTResourceManager.getImage("explorer.png"));
		lblB.setBounds(172, 92, 80, 80);
		
		Label lblC = new Label(shlZhoujackMachines, SWT.BORDER | SWT.WRAP);
		lblC.setImage(SWTResourceManager.getImage("nasa.png"));
		lblC.setBounds(305, 92, 80, 80);
		
		Label lblTitolo = new Label(shlZhoujackMachines, SWT.NONE);
		lblTitolo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTitolo.setFont(SWTResourceManager.getFont("Trajan Pro", 16, SWT.BOLD));
		lblTitolo.setBounds(53, 10, 332, 34);
		lblTitolo.setText("JACK  and ZHOU Machines");

		Button btnReset = new Button(shlZhoujackMachines, SWT.NONE);
		btnReset.setBounds(10, 302, 75, 50);
		btnReset.setText("RESET");
		
		Button btnSpin = new Button(shlZhoujackMachines, SWT.NONE);
		btnSpin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblA.setImage(SWTResourceManager.getImage(immagini.get(k)));
				k++;
				if(k == 3) {
					k = 0;
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
	}
}
