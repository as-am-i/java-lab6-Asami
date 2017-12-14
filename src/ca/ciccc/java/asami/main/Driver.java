package ca.ciccc.java.asami.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import ca.ciccc.java.asami.model.Date;
import ca.ciccc.java.asami.model.MainFrame;

// to initialize JFrame
public class Driver {
	public static void main(String[] args) {
		new Driver().createUI();

	}

	private void createUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}

					MainFrame frame = new MainFrame();
					frame.setVisible(true);

					frame.setOkButtonListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							String input = frame.getInputValue();

							if (!input.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
								frame.setResult("It is NOT a valid date - type properly");
								return;
							}

							String[] parts = input.split("-");

							int year = Integer.parseInt(parts[0]);
							int month = Integer.parseInt(parts[1]);
							int day = Integer.parseInt(parts[2]);
							// System.out.println(day);
							// System.out.println(parts[2]);

							Date date1 = new Date(day, month, year);

							frame.setResult(date1.getDayOfTheWeek());
						}
					});

				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		});
	}

}
