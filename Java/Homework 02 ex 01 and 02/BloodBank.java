public class BloodBank {
    private BloodSupply[] supplies;

    public BloodBank() {
        this.supplies = new BloodSupply[0];
    }

    public BloodSupply[] getSupplies() {
        return supplies;
    }

    public BloodSupply findBloodSupply(String bloodType) {
        if (bloodType == null) {
            return null;
        }

        for (BloodSupply supply : supplies) {
            if (supply != null && supply.getBloodType().equalsIgnoreCase(bloodType)) {
                return supply;
            }
        }
        return null;
    }

    public void receiveBloodSupply(String bloodType, int rarityValue, int quantity) {
        BloodSupply existing = findBloodSupply(bloodType);

        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + quantity);
            return;
        }

        addToBloodSupplies(new BloodSupply(bloodType, rarityValue, quantity));
    }

    public void addToBloodSupplies(BloodSupply newSupply) {
        if (newSupply == null) {
            return;
        }

        BloodSupply[] expanded = new BloodSupply[supplies.length + 1];
        for (int i = 0; i < supplies.length; i++) {
            expanded[i] = supplies[i];
        }
        expanded[supplies.length] = newSupply;
        supplies = expanded;
    }

    public boolean take(String bloodType, int amount) {
        BloodSupply supply = findBloodSupply(bloodType);
        if (supply == null || supply.getQuantity() < amount) {
            return false;
        }

        supply.setQuantity(supply.getQuantity() - amount);
        return true;
    }
}

