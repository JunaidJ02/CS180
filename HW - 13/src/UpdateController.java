import javax.swing.*;

/**
 * An update controller of a product inventory application.
 *
 * <p>CS18000 -- Summer 2019 -- Complex GUIs -- Homework</p>
 */
public final class UpdateController {
    /**
     * The inventory model of this update controller.
     */
    private InventoryModel inventoryModel;

    /**
     * The update view of this update controller.
     */
    private UpdateView updateView;

    /**
     * Constructs a newly allocated {@code UpdateController} object with the specified inventory model and update view.
     *
     * @param inventoryModel the inventory model of this update controller
     * @param updateView the update view of this update controller
     * @throws IllegalArgumentException if the {@code inventoryModel} argument or {@code updateView} argument is
     * {@code null}
     */
    public UpdateController(InventoryModel inventoryModel, UpdateView updateView) throws IllegalArgumentException {
        if (inventoryModel == null) {
            throw new IllegalArgumentException("inventoryModel argument is null");
        } else if (updateView == null) {
            throw new IllegalArgumentException("updateView argument is null");
        } else {
            this.inventoryModel = inventoryModel;
            this.updateView = updateView;

            this.updateView.getUpdateButton().addActionListener(e -> this.getUpdateButtonSemantics());

            this.updateView.getClearButton().addActionListener(e -> this.getClearButtonSemantics());
        } //end if
    } //UpdateController

    /**
     * Gets the semantics of an update view's update button.
     */
    private void getUpdateButtonSemantics() {
        boolean works = true;
        if (inventoryModel.searchBySku(updateView.getSkuTextField().getText()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "A product with the specified SKU does not exist in this inventory!\n",
                    "Product Inventory", JOptionPane.ERROR_MESSAGE);
            updateView.getSkuTextField().requestFocus();
        } else if (updateView.getFieldComboBox().getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "A field option was not selected!\n",
                    "Product Inventory", JOptionPane.ERROR_MESSAGE);
            updateView.getFieldComboBox().requestFocus();
        } else if (updateView.getFieldComboBox().getSelectedIndex() == 0) {
            if (inventoryModel.searchBySku(updateView.getSkuTextField().getText()).isPresent()) {
                JOptionPane.showMessageDialog(null, "This product could not be updated!\n" +
                        "A product with the specified SKU already exists!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                updateView.getNewFieldValueTextField().requestFocus();
            }
        } else if (updateView.getFieldComboBox().getSelectedIndex() > 1) {

             switch (updateView.getFieldComboBox().getSelectedIndex()) {
                    case 2:
                        if (!updateView.getNewFieldValueTextField().getText().matches("^[0-9.]+$")) {
                            JOptionPane.showMessageDialog(null, "The specified wholesale price is not a valid number!",
                                    "Product Inventory", JOptionPane.ERROR_MESSAGE);
                            updateView.getNewFieldValueTextField().requestFocus();
                        }
                        works = false;
                        break;
                    case 3:
                        if (!updateView.getNewFieldValueTextField().getText().matches("^[0-9.]+$")) {
                            JOptionPane.showMessageDialog(null, "The specified retail price is not a valid number!",
                                    "Product Inventory", JOptionPane.ERROR_MESSAGE);
                            updateView.getNewFieldValueTextField().requestFocus();
                        }
                        works = false;
                        break;
                    case 4:
                        if (!updateView.getNewFieldValueTextField().getText().matches("^[0-9]+$")) {
                            JOptionPane.showMessageDialog(null, "The specified quantity is not a valid number!",
                                    "Product Inventory", JOptionPane.ERROR_MESSAGE);
                            updateView.getNewFieldValueTextField().requestFocus();
                        }
                        works = false;
                        break;
                }
            } if (works) {
                int change = updateView.getFieldComboBox().getSelectedIndex();
                Product currentProduct = inventoryModel.searchBySku(updateView.getSkuTextField().getText()).get();
                String newFieldValue = updateView.getNewFieldValueTextField().getText();
                String changing = "";
                if (change == 0) {
                    currentProduct.setSku(newFieldValue);
                    changing = "SKU";
                } else if (change == 1) {
                    currentProduct.setName(newFieldValue);
                    changing = "name";
                } else if (change == 2) {
                    currentProduct.setWholesalePrice(Double.parseDouble(newFieldValue));
                    changing = "wholesale price";
                } else if (change == 3) {
                    currentProduct.setRetailPrice(Double.parseDouble(newFieldValue));
                    changing = "retail price";
                } else if (change == 4) {
                    currentProduct.setQuantity(Integer.parseInt(newFieldValue));
                    changing = "quantity";
                }
                JOptionPane.showMessageDialog(null, "This product's " + changing + " has been changed.",
                        "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
                updateView.getSkuTextField().requestFocus();
            }
        }//getUpdateButtonSemantics

    /**
     * Gets the semantics of an update view's clear button.
     */
    private void getClearButtonSemantics() {
        updateView.getFieldComboBox().setSelectedIndex(-1);
        updateView.getNewFieldValueTextField().setText("");
        updateView.getSkuTextField().setText("");
        updateView.getSkuTextField().requestFocus();
    } //getClearButtonSemantics

    /**
     * Gets the hash code of this update controller.
     *
     * @return the hash code of this update controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.inventoryModel == null ? 0 : this.inventoryModel.hashCode());

        result = 19 * result + (this.updateView == null ? 0 : this.updateView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this update controller is equal to the specified object. {@code true} is returned if
     * and only if the specified object is an instance of {@code UpdateController}, and its field values are equal to
     * this update controller's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this update controller is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof UpdateController)
                && (this.inventoryModel == null ? ((UpdateController) anObject).inventoryModel ==  null : this.inventoryModel.equals(((UpdateController) anObject).inventoryModel))
                && (this.updateView == null ? ((UpdateController) anObject).updateView ==  null : this.updateView.equals(((UpdateController) anObject).updateView));
    } //equals

    /**
     * Gets a {@code String} representation of this update controller.
     *
     * @return a {@code String} representation of this update controller
     */
    @Override
    public String toString() {
        return String.format("UpdateController[%s, %s]", this.inventoryModel, this.updateView);
    } //toString
}