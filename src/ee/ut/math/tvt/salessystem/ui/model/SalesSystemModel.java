package ee.ut.math.tvt.salessystem.ui.model;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;

/**
 * Main model. Holds all the other models.
 */
public class SalesSystemModel {
    
    private static final Logger log = Logger.getLogger(SalesSystemModel.class);

    // Warehouse model
    private StockTableModel warehouseTableModel;
    
    // Current shopping cart model
    private PurchaseInfoTableModel currentPurchaseTableModel;
    
    private OrderTableModel orderTableModel;

    private final SalesDomainController domainController;

    /**
     * Construct application model.
     * @param domainController Sales domain controller.
     */
    public SalesSystemModel(SalesDomainController domainController) {
        this.domainController = domainController;
        
        warehouseTableModel = new StockTableModel();
        currentPurchaseTableModel = new PurchaseInfoTableModel();
        
        
        orderTableModel = new OrderTableModel();

        // populate stock model with data from the warehouse
        warehouseTableModel.populateWithData(domainController.loadWarehouseState());

    }

    public StockTableModel getWarehouseTableModel() {
        return warehouseTableModel;
    }

    public PurchaseInfoTableModel getCurrentPurchaseTableModel() {
        return currentPurchaseTableModel;
    }
    
   
	public OrderTableModel getOrderTableModel() {
		return orderTableModel;
	}

	public void setOrderTableModel(OrderTableModel orderTableModel) {
		this.orderTableModel = orderTableModel;
	}
    
    
    
}