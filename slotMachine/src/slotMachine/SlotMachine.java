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
import org.eclipse.swt.widgets.Composite;

public class SlotMachine {

	protected Shell shlZhoujackMachines;
	ArrayList<String> immagini = new ArrayList<String>(){{
		add("crome.jpg");
		add("explorer.png");
		add("nasa.png");
	}};
	private int j = 0;
	private int k = 1;
	private int l = 2;
	private final static int giri = 20;

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
		shlZhoujackMachines.setBackground(SWTResourceManager.getColor(255, 255, 204));
		shlZhoujackMachines.setImage(SWTResourceManager.getImage("icon.png"));
		shlZhoujackMachines.setSize(290, 381);
		shlZhoujackMachines.setText("ZHOU&JACK MACHINES");
		
		Label lblA = new Label(shlZhoujackMachines, SWT.BORDER | SWT.WRAP);
		lblA.setImage(SWTResourceManager.getImage("crome.jpg"));
		lblA.setBounds(10, 63, 80, 80);
		
		Label lblB = new Label(shlZhoujackMachines, SWT.BORDER | SWT.WRAP);
		lblB.setImage(SWTResourceManager.getImage("explorer.png"));
		lblB.setBounds(96, 63, 80, 80);
		
		Label lblC = new Label(shlZhoujackMachines, SWT.BORDER | SWT.WRAP);
		lblC.setImage(SWTResourceManager.getImage("nasa.png"));
		lblC.setBounds(182, 63, 80, 80);
		
		Label lblTitolo = new Label(shlZhoujackMachines, SWT.NONE);
		lblTitolo.setBackground(SWTResourceManager.getColor(255, 255, 204));
		lblTitolo.setFont(SWTResourceManager.getFont("Segoe UI Light", 15, SWT.BOLD));
		lblTitolo.setBounds(71, 23, 128, 34);
		lblTitolo.setText("CHINA SLOTS");
		
		Composite composite = new Composite(shlZhoujackMachines, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(255, 204, 102));
		composite.setBounds(10, 149, 252, 64);
		
		Label lblSaldonumero = new Label(composite, SWT.NONE);
		lblSaldonumero.setBounds(187, 10, 55, 15);
		lblSaldonumero.setBackground(SWTResourceManager.getColor(255, 204, 102));
		lblSaldonumero.setText("0.0");
		
		Label lblSaldo = new Label(composite, SWT.NONE);
		lblSaldo.setBounds(187, 39, 55, 15);
		lblSaldo.setBackground(SWTResourceManager.getColor(255, 204, 102));
		lblSaldo.setText("SALDO");
		
		Label lblPuntata = new Label(composite, SWT.NONE);
		lblPuntata.setBounds(71, 39, 55, 15);
		lblPuntata.setBackground(SWTResourceManager.getColor(255, 204, 102));
		lblPuntata.setText("PUNTATA");
		
		Label lblPuntatanumero = new Label(composite, SWT.NONE);
		lblPuntatanumero.setBounds(71, 10, 55, 15);
		lblPuntatanumero.setBackground(SWTResourceManager.getColor(255, 204, 102));
		lblPuntatanumero.setText("0.0");
		
		Label lblVincita = new Label(composite, SWT.NONE);
		lblVincita.setBounds(10, 39, 55, 15);
		lblVincita.setBackground(SWTResourceManager.getColor(255, 204, 102));
		lblVincita.setText("VINCITA");
		
		Label lblVincitanumero = new Label(composite, SWT.NONE);
		lblVincitanumero.setBounds(10, 10, 55, 15);
		lblVincitanumero.setBackground(SWTResourceManager.getColor(255, 204, 102));
		lblVincitanumero.setText("0.0");
		
		Button btnReset = new Button(shlZhoujackMachines, SWT.BORDER | SWT.FLAT);
		btnReset.setBounds(10, 219, 75, 50);
		btnReset.setText("RESET");
		
		Button btnSpin = new Button(shlZhoujackMachines, SWT.BORDER | SWT.FLAT);
		btnSpin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnSpin.setEnabled(false);
				Thread thread1 = new Thread() {
					@Override
					public void run() {
						j = 0;
						for (int i = 0; i < giri; i++) {
							j++;
							if(j == 3) {
								j = 0;
							}
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									lblA.setImage(SWTResourceManager.getImage(immagini.get(j)));
								}
							});
							try {
								Thread.sleep(250);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						j = (int)(Math.random() * 3);
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								lblA.setImage(SWTResourceManager.getImage(immagini.get(j)));
							}
						});
					}

				};
				thread1.start();
				
				Thread thread2 = new Thread() {
					@Override
					public void run() {
						k = 1;
						for (int i = 0; i < giri; i++) {
							k++;
							if(k == 3) {
								k = 0;
							}
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									lblB.setImage(SWTResourceManager.getImage(immagini.get(k)));
								}
							});
							try {
								Thread.sleep(250);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						k = (int)(Math.random() * 3);
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								lblB.setImage(SWTResourceManager.getImage(immagini.get(k)));
							}
						});
					}

				};
				thread2.start();
				
				Thread thread3 = new Thread() {
					@Override
					public void run() {
						l = 2;
						for (int i = 0; i < giri; i++) {
							l++;
							if(l == 3) {
								l = 0;
							}
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									lblC.setImage(SWTResourceManager.getImage(immagini.get(l)));
								}
							});
							try {
								Thread.sleep(250);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						l = (int)(Math.random() * 3);
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								lblC.setImage(SWTResourceManager.getImage(immagini.get(l)));
								btnSpin.setEnabled(true);
							}
						});
					}

				};
				thread3.start();
			}
		});
		btnSpin.setBounds(71, 275, 126, 50);
		btnSpin.setText("SPIN");
		
		Button btnBet = new Button(shlZhoujackMachines, SWT.BORDER | SWT.FLAT);
		btnBet.setBounds(96, 219, 75, 50);
		btnBet.setText("BET");
		
		Button btnBetAll = new Button(shlZhoujackMachines, SWT.BORDER | SWT.FLAT);
		btnBetAll.setBounds(182, 219, 75, 50);
		btnBetAll.setText("BET ALL");
	}
}
