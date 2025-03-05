import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {

    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");



    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      // Validate user-entered transaction amount
      try {
        InputValidation.validateAmount(view.getAmountField());
      } catch (IllegalArgumentException ex) {
        view.alert("Invalid amount entered.");
        return;
      }

      // Validate user-entered transaction category
      try {
        InputValidation.validateCategory(view.getCategoryField());
      } catch (IllegalArgumentException ex) {
        view.alert("Invalid category entered.");
        return;
      }

      Transaction t = new Transaction(view.getAmountField(), view.getCategoryField());

      // Call controller to add transaction
      view.addTransaction(t);
    });

  }

}