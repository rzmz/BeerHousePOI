package ee.ut.math.tvt.salessystem.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.Logger;

import com.jgoodies.looks.windows.WindowsLookAndFeel;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import ee.ut.math.tvt.salessystem.ui.tabs.ClientTab;
import ee.ut.math.tvt.salessystem.ui.tabs.HistoryTab;
import ee.ut.math.tvt.salessystem.ui.tabs.PurchaseTab;
import ee.ut.math.tvt.salessystem.ui.tabs.Refreshable;
import ee.ut.math.tvt.salessystem.ui.tabs.StockTab;

/**
 * Graphical user interface of the sales system.
 */
public class SalesSystemUI extends JFrame {

  private static final long serialVersionUID = 1L;

  private static final Logger log = Logger.getLogger(SalesSystemUI.class);

  // Warehouse model
  private SalesSystemModel model;

  private SalesDomainController domainController;

  private Refreshable[] tabs = new Refreshable[4];
  
  /**
   * Constructs sales system GUI.
   * @param domainController Sales domain controller.
   */
  public SalesSystemUI(SalesDomainController domainController) {
      this.domainController = domainController;
    this.model = new SalesSystemModel(domainController);
    domainController.setModel(model);

    // Create singleton instances of the tab classes and add them to our new tabs list for later use
    tabs[0] = new PurchaseTab(domainController, model, this);
    tabs[1] = new StockTab(model, domainController);
    tabs[2] = new HistoryTab(model);
    tabs[3] = new ClientTab(model);

    setTitle("Sales system");

    // set L&F to the nice Windows style
    try {
        UIManager.setLookAndFeel(new WindowsLookAndFeel());
    } catch (UnsupportedLookAndFeelException e1) {
        log.warn(e1.getMessage());
    }

    drawWidgets();

    // size & location
    int width = 600;
    int height = 400;
    setSize(width, height);
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation((screen.width - width) / 2, (screen.height - height) / 2);

    addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            SalesSystemUI.this.domainController.endSession();
            log.info("SalesSystem closed");
            System.exit(0);
        }
    });
  }

  private void drawWidgets() {
    final JTabbedPane tabbedPane = new JTabbedPane();
    
    tabbedPane.add("Point-of-sale", tabs[0].draw());
    tabbedPane.add("Warehouse", tabs[1].draw());
    tabbedPane.add("History", tabs[2].draw());
    tabbedPane.add("Clients", tabs[3].draw());

    // add change listener to the tabbed pane so we can call their refresh method every time a tab is selected
    tabbedPane.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
        	log.debug("Tab selected: " + tabbedPane.getSelectedIndex());
        	tabs[tabbedPane.getSelectedIndex()].refresh(domainController);
        }
    });
    
    getContentPane().add(tabbedPane);
  }

}


