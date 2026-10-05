public class BloodSupply {
    private String bloodType;
    private int rarityValue;
    private int quantity;

    public BloodSupply(String bloodType, int rarityValue, int quantity) {
        if (bloodType == null || bloodType.trim().isEmpty()) {
            this.bloodType = "O-";
        } else {
            this.bloodType = bloodType;
        }

        if (rarityValue > 0) {
            this.rarityValue = rarityValue;
        } else {
            this.rarityValue = 1;
        }

        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }
    }

    public String getBloodType() {
        return bloodType;
    }

    public int getRarityValue() {
        return rarityValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }
}
