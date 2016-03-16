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
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class SlotMachine {

	protected Shell shlZhoujackMachines;
	ArrayList<String> immagini = new ArrayList<String>(){{
		add("img/crome.jpg");
		add("img/explorer.png");
		add("img/nasa.png");
		add("img/twitter.png");
		add("img/xbox.png");
	}};
	private int j = 0;
	private int k = 1;
	private int l = 2;
	private final static int giri = 15;
	private int saldo = 10;
	public int puntata = 0;
	private int vincita = 0;
	private int temp = 0;
	private int a = 1;
	private int b = 0;
	private int c = 0;
	private int x = 0;

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
	
	public void premi(int e){
		System.out.println("tasto premuto");
		if(e == 119){
			if(this.saldo > 0){
				System.out.println("hai premuto w");
				this.saldo = this.saldo-1;
				this.puntata = this.puntata + 1;
			}
		}
		if(e == 115){
			if (this.puntata > 0) {
				this.puntata = this.puntata - 1;
				this.saldo = this.saldo + 1;
			}
		}
		if(e == 114){
			this.saldo = 15;
			this.vincita = 0;
			this.puntata = 0;
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlZhoujackMachines = new Shell();
		shlZhoujackMachines.setBackground(SWTResourceManager.getColor(102, 51, 255));
		shlZhoujackMachines.setImage(SWTResourceManager.getImage("img/icon.png"));
		shlZhoujackMachines.setSize(290, 405);
		shlZhoujackMachines.setText("CHINA SLOTS");
		shlZhoujackMachines.setBackgroundImage(SWTResourceManager.getImage("img/background.jpg"));

		Label lblA = new Label(shlZhoujackMachines, SWT.BORDER | SWT.WRAP);
		lblA.setImage(SWTResourceManager.getImage("img/crome.jpg"));
		lblA.setBounds(10, 88, 80, 80);

		Label lblB = new Label(shlZhoujackMachines, SWT.BORDER | SWT.WRAP);
		lblB.setImage(SWTResourceManager.getImage("img/explorer.png"));
		lblB.setBounds(96, 88, 80, 80);

		Label lblC = new Label(shlZhoujackMachines, SWT.BORDER | SWT.WRAP);
		lblC.setImage(SWTResourceManager.getImage("img/nasa.png"));
		lblC.setBounds(182, 88, 80, 80);

		Label lblTitolo = new Label(shlZhoujackMachines, SWT.WRAP);
		lblTitolo.setImage(SWTResourceManager.getImage("img/titolo.jpg"));
		lblTitolo.setFont(SWTResourceManager.getFont("Gill Sans Ultra Bold Condensed", 17, SWT.NORMAL));
		lblTitolo.setBounds(0, 0, 274, 82);

		Composite composite = new Composite(shlZhoujackMachines, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(204, 0, 51));
		composite.setBounds(0, 174, 274, 64);

		Label lblSaldonumero = new Label(composite, SWT.NONE);
		lblSaldonumero.setFont(SWTResourceManager.getFont("Gill Sans Ultra Bold Condensed", 20, SWT.NORMAL));
		lblSaldonumero.setBounds(205, 0, 55, 33);
		lblSaldonumero.setBackground(SWTResourceManager.getColor(204, 0, 51));
		lblSaldonumero.setText("0.0");

		Label lblSaldo = new Label(composite, SWT.NONE);
		lblSaldo.setFont(SWTResourceManager.getFont("Gill Sans Ultra Bold", 9, SWT.NORMAL));
		lblSaldo.setBounds(205, 39, 55, 15);
		lblSaldo.setBackground(SWTResourceManager.getColor(204, 0, 51));
		lblSaldo.setText("SALDO");

		Label lblPuntata = new Label(composite, SWT.NONE);
		lblPuntata.setFont(SWTResourceManager.getFont("Gill Sans Ultra Bold", 9, SWT.NORMAL));
		lblPuntata.setBounds(86, 39, 80, 15);
		lblPuntata.setBackground(SWTResourceManager.getColor(204, 0, 51));
		lblPuntata.setText("PUNTATA");

		Label lblPuntatanumero = new Label(composite, SWT.NONE);
		lblPuntatanumero.setFont(SWTResourceManager.getFont("Gill Sans Ultra Bold Condensed", 20, SWT.NORMAL));
		lblPuntatanumero.setBounds(86, 0, 55, 33);
		lblPuntatanumero.setBackground(SWTResourceManager.getColor(204, 0, 51));
		lblPuntatanumero.setText("0.0");

		Label lblVincita = new Label(composite, SWT.NONE);
		lblVincita.setFont(SWTResourceManager.getFont("Gill Sans Ultra Bold", 9, SWT.NORMAL));
		lblVincita.setBounds(10, 39, 70, 15);
		lblVincita.setBackground(SWTResourceManager.getColor(204, 0, 51));
		lblVincita.setText("VINCITA");

		Label lblVincitanumero = new Label(composite, SWT.NONE);
		lblVincitanumero.setFont(SWTResourceManager.getFont("Gill Sans Ultra Bold Condensed", 20, SWT.NORMAL));
		lblVincitanumero.setBounds(10, 0, 55, 33);
		lblVincitanumero.setBackground(SWTResourceManager.getColor(204, 0, 51));
		lblVincitanumero.setText("0.0");

		Button btnReset = new Button(shlZhoujackMachines, SWT.FLAT);
		btnReset.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				x = e.keyCode;
				premi(x);
				lblVincitanumero.setText(String.valueOf(vincita));
				lblSaldonumero.setText(String.valueOf(saldo));
				lblPuntatanumero.setText(String.valueOf(puntata));
			}
		});
		btnReset.setForeground(SWTResourceManager.getColor(0, 255, 0));
		btnReset.setFont(SWTResourceManager.getFont("Gill Sans Ultra Bold Condensed", 9, SWT.NORMAL));
		btnReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				saldo = 10;
				vincita = 0;
				puntata = 0;
				
				lblVincitanumero.setText(String.valueOf(vincita));
				lblSaldonumero.setText(String.valueOf(saldo));
				lblPuntatanumero.setText(String.valueOf(puntata));
			}
		});
		btnReset.setBounds(10, 250, 75, 50);
		btnReset.setText("RESET");
		
		//inizalizzazione schermata
		lblVincitanumero.setText(String.valueOf(vincita));
		lblSaldonumero.setText(String.valueOf(saldo));
		lblPuntatanumero.setText(String.valueOf(puntata));
		
		//dichiarazione tasti
		Button btnSpin = new Button(shlZhoujackMachines, SWT.BORDER | SWT.FLAT | SWT.CENTER);
		btnSpin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				x = e.keyCode;
				premi(x);
				lblVincitanumero.setText(String.valueOf(vincita));
				lblSaldonumero.setText(String.valueOf(saldo));
				lblPuntatanumero.setText(String.valueOf(puntata));
			}
		});
		Button btnBet = new Button(shlZhoujackMachines, SWT.FLAT);
		Button btnBetAll = new Button(shlZhoujackMachines, SWT.FLAT);
		btnBetAll.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				x = e.keyCode;
				premi(x);
				lblVincitanumero.setText(String.valueOf(vincita));
				lblSaldonumero.setText(String.valueOf(saldo));
				lblPuntatanumero.setText(String.valueOf(puntata));
			}
		});
		Button btnOops = new Button(shlZhoujackMachines, SWT.FLAT);
		btnOops.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				x = e.keyCode;
				premi(x);
				lblVincitanumero.setText(String.valueOf(vincita));
				lblSaldonumero.setText(String.valueOf(saldo));
				lblPuntatanumero.setText(String.valueOf(puntata));
			}
		});
		
		
		btnSpin.setFont(SWTResourceManager.getFont("Gill Sans Ultra Bold Condensed", 9, SWT.NORMAL));
		btnSpin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnSpin.setEnabled(false);
				btnReset.setEnabled(false);
				btnBet.setEnabled(false);
				btnBetAll.setEnabled(false);
				btnOops.setEnabled(false);
				
				Thread thread1 = new Thread() {
					@Override
					public void run() {
						j = 0;
						for (int i = 0; i < giri; i++) {
							//j++;
							j = (int)(Math.random() * 5);
							for(j = a; j == a;){
								j = (int)(Math.random() * 5);
							}
							a = j;
							/*if(j == 5) {
								j = 0;
							}*/
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									lblA.setImage(SWTResourceManager.getImage(immagini.get(j)));
								}
							
							});
							try {
								Thread.sleep(200);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						j = (int)(Math.random() * 5);
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
						for (int i = 0; i < giri+7; i++) {
							k = (int)(Math.random() * 5);
							for(k = b; k == b;){
								k = (int)(Math.random() * 5);
							}
							b = k;
							
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									lblB.setImage(SWTResourceManager.getImage(immagini.get(k)));
								}
							});
							try {
								Thread.sleep(200);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						k = (int)(Math.random() * 5);
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
						for (int i = 0; i < giri+14; i++) {
							l = (int)(Math.random() * 5);
							for(l = c; l == c;){
								l = (int)(Math.random() * 5);
							}
							c = l;
	
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									lblC.setImage(SWTResourceManager.getImage(immagini.get(l)));
								}
							});
							try {
								Thread.sleep(200);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						l = (int)(Math.random() * 5);
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								lblC.setImage(SWTResourceManager.getImage(immagini.get(l)));
								btnSpin.setEnabled(true);
								btnReset.setEnabled(true);
								btnBet.setEnabled(true);
								btnBetAll.setEnabled(true);
								btnOops.setEnabled(true);
								
								
								//vinto o perso
								if (l==k && k==j) {
									vincita = puntata *2;
									saldo = saldo + vincita;
									puntata = 0;
									lblPuntatanumero.setText(String.valueOf(puntata));
									lblVincitanumero.setText(String.valueOf(vincita));
									lblSaldonumero.setText(String.valueOf(saldo));
									System.out.println("hai vinto");
								} else {
									puntata = 0;
									lblPuntatanumero.setText(String.valueOf(puntata));
									lblSaldonumero.setText(String.valueOf(saldo));
									System.out.println("hai perso");
								}
							}
						});
					}

				};
				thread3.start();
				
			}
		});
		btnSpin.setBounds(74, 307, 128, 50);
		btnSpin.setText("SPIN");


		btnBet.setSelection(true);
		btnBet.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				x = e.keyCode;
				premi(x);
				lblVincitanumero.setText(String.valueOf(vincita));
				lblSaldonumero.setText(String.valueOf(saldo));
				lblPuntatanumero.setText(String.valueOf(puntata));
			}
		});
		btnBet.setFont(SWTResourceManager.getFont("Gill Sans Ultra Bold Condensed", 9, SWT.NORMAL));
		btnBet.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(saldo>0){
					saldo = saldo-1;
					lblSaldonumero.setText(String.valueOf(saldo));

					puntata=puntata + 1;
					lblPuntatanumero.setText(String.valueOf(puntata));
				}

			}
		});
		btnBet.setBounds(96, 244, 80, 25);
		btnBet.setText("BET");

		
		btnBetAll.setFont(SWTResourceManager.getFont("Gill Sans Ultra Bold Condensed", 9, SWT.NORMAL));
		btnBetAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				puntata = puntata + saldo;
				saldo = 0;
				System.out.println("ALL IN!!");
				
				lblVincitanumero.setText(String.valueOf(vincita));
				lblSaldonumero.setText(String.valueOf(saldo));
				lblPuntatanumero.setText(String.valueOf(puntata));
				
			}
		});
		btnBetAll.setBounds(187, 250, 75, 50);
		btnBetAll.setText("BET ALL");
		
		
		btnOops.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (puntata > 0) {
					puntata = puntata - 1;
					saldo = saldo + 1;
					lblSaldonumero.setText(String.valueOf(saldo));
					lblPuntatanumero.setText(String.valueOf(puntata));
				}
			}
		});
		btnOops.setFont(SWTResourceManager.getFont("Gill Sans Ultra Bold Condensed", 9, SWT.NORMAL));
		btnOops.setBounds(96, 275, 80, 25);
		btnOops.setText("OOPS");
	}
}
