/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomressigngenerator;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author gersh
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        beginField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        goButton = new javax.swing.JButton();
        exLabel = new javax.swing.JLabel();
        doneLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        beginField.setText(" ");
        beginField.setToolTipText("");

        jLabel1.setText("Start Date:");

        jLabel3.setText("Please enter start date for table in yyyy-mm-dd format and hit \"Go\"");

        jLabel4.setText("Be sure to include leading zeroes, e.g. 2012-09-09");

        goButton.setText("Go");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        exLabel.setVisible(false);
        exLabel.setText("An exception has occured.");

        doneLabel.setVisible(false);
        doneLabel.setText("Done!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exLabel)
                            .addComponent(beginField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(goButton)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(doneLabel)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addComponent(goButton)
                .addGap(28, 28, 28)
                .addComponent(doneLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exLabel)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        exLabel.setVisible(false);
        doneLabel.setVisible(false);
        try {
            
            routine(beginField.getText().trim(), endOfWeek(beginField.getText().trim()));
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_goButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    public void routine(String beginDate, String endDate) throws Exception {
        
        try {
        	String caboose = "?alt=jsonc&start-min=" + beginDate + "T00:00:00&start-max=" + endDate + "T23:59:59&orderby=starttime&sortorder=ascending";
		
		//one = 4019
		//two = 4103b
		//three = 4018
		//four = 4016
		EventListMaker oneMaker = new EventListMaker();
		CalendarEvent[] oneEvents = oneMaker.compileList("https://www.google.com/calendar/feeds/gau4uas92k6pk87l0n619torf0@group.calendar.google.com/private-fb3b49638e512f8f2869f177edf52219/full" + caboose);
		EventListMaker twoMaker = new EventListMaker();
		CalendarEvent[] twoEvents = twoMaker.compileList("https://www.google.com/calendar/feeds/d7vnhh7e2khtqbnssjfbpaaqdg@group.calendar.google.com/private-cc020b0b9f261d89ac1ddeca29ed0a15/full" + caboose);
		EventListMaker threeMaker = new EventListMaker();
		CalendarEvent[] threeEvents = threeMaker.compileList("https://www.google.com/calendar/feeds/i9rkpij2kcpekc9br17mfcu8jc@group.calendar.google.com/private-7c52bd73fc1433feda64f0f688009b7d/full" + caboose);
		EventListMaker fourMaker = new EventListMaker();
		//maker.printEvents("https://www.google.com/calendar/feeds/i9rkpij2kcpekc9br17mfcu8jc@group.calendar.google.com/private-7c52bd73fc1433feda64f0f688009b7d/full" + caboose);
		CalendarEvent[] fourEvents = fourMaker.compileList("https://www.google.com/calendar/feeds/itmqe3hm6cnodv7tr8d0mp2buc@group.calendar.google.com/private-41dcfcea52c60edebaccdb8145ea4c09/full" + caboose);
		
		RoomResTable oneTable = new RoomResTable("4019 Room Reservation Calendar");
		for(CalendarEvent event : oneEvents) {
			TableRow row = event.toRow();
			oneTable.addRow(row);
		}
		oneTable.fileRows();
		oneTable.toHtml("S:\\Across_Studies\\Procedures\\Room Reservation Scheduling\\4019RoomReservationCalendar.html");
		
		RoomResTable twoTable = new RoomResTable("4103b Room Reservation Calendar");
		for(CalendarEvent event : twoEvents) {
			TableRow row = event.toRow();
			twoTable.addRow(row);
		}
		twoTable.fileRows();
		twoTable.toHtml("S:\\Across_Studies\\Procedures\\Room Reservation Scheduling\\4103bRoomReservationCalendar.html");
		
		RoomResTable threeTable = new RoomResTable("4018 Room Reservation Calendar");
		for(CalendarEvent event : threeEvents) {
			TableRow row = event.toRow();
			threeTable.addRow(row);
		}
		threeTable.fileRows();
		threeTable.toHtml("S:\\Across_Studies\\Procedures\\Room Reservation Scheduling\\4018RoomReservationCalendar.html");
		
		RoomResTable fourTable = new RoomResTable("4016 Room Reservation Calendar");
		for(CalendarEvent event : fourEvents) {
			TableRow row = event.toRow();
			fourTable.addRow(row);
		}
		fourTable.fileRows();
		fourTable.toHtml("S:\\Across_Studies\\Procedures\\Room Reservation Scheduling\\4016RoomReservationCalendar.html");
                
                System.out.println("Done!");
                doneLabel.setVisible(true);
        }
        catch(Exception e) {
            exLabel.setVisible(true);
        }
        
    }
    public String endOfWeek(String beginString) {
	try {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = formatter.parse(beginString);
		Calendar cal = Calendar.getInstance();
		cal.setTime(beginDate);
		cal.add(Calendar.DATE, 4);
		String endString = formatter.format(cal.getTime());
		return endString;
	}
	catch(Exception e) {
		exLabel.setVisible(true);
		return "";
	}
		
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField beginField;
    private javax.swing.JLabel doneLabel;
    private javax.swing.JLabel exLabel;
    private javax.swing.JButton goButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
