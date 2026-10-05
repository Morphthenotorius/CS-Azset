public class CastleDracula {
    private BloodBank bloodBank;
    private BloodOrder[] pendingOrders;

    public CastleDracula(BloodBank bloodBank) {
        if (bloodBank != null) {
            this.bloodBank = bloodBank;
        } else {
            this.bloodBank = new BloodBank();
        }
        this.pendingOrders = new BloodOrder[0];
    }

    public BloodBank getBloodBank() {
        return bloodBank;
    }

    public BloodOrder[] getPendingOrders() {
        return pendingOrders;
    }

    public void placeOrder(BloodOrder order) {
        if (order == null) {
            return;
        }

        BloodOrder[] expanded = new BloodOrder[pendingOrders.length + 1];
        for (int i = 0; i < pendingOrders.length; i++) {
            expanded[i] = pendingOrders[i];
        }
        expanded[pendingOrders.length] = order;
        pendingOrders = expanded;
    }

    public int calculateOrderValue(BloodOrder order) {
        if (order == null || order.getBloodTypes() == null) {
            return 0;
        }

        int totalValue = 0;
        for (String type : order.getBloodTypes()) {
            BloodSupply supply = bloodBank.findBloodSupply(type);
            if (supply != null) {
                totalValue += supply.getRarityValue();
            }
        }
        return totalValue;
    }

    public void fulfillOrders() {
        if (pendingOrders.length == 0) {
            return;
        }

        BloodOrder currentOrder = pendingOrders[0];

        for (String type : currentOrder.getBloodTypes()) {
            BloodSupply supply = bloodBank.findBloodSupply(type);
            if (supply == null || supply.getQuantity() < 1) {
                return;
            }
        }

        for (String type : currentOrder.getBloodTypes()) {
            bloodBank.take(type, 1);
        }

        BloodOrder[] shrunk = new BloodOrder[pendingOrders.length - 1];
        for (int i = 0; i < shrunk.length; i++) {
            shrunk[i] = pendingOrders[i + 1];
        }
        pendingOrders = shrunk;
    }
}
