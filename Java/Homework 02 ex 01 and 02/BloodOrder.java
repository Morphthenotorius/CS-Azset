public class BloodOrder {
    private String vampireName;
    private String[] bloodTypes;

    public BloodOrder(String vampireName, String[] bloodTypes) {
        if (vampireName != null) {
            this.vampireName = vampireName;
        } else {
            this.vampireName = "Unknown";
        }

        if (bloodTypes != null) {
            this.bloodTypes = bloodTypes;
        } else {
            this.bloodTypes = new String[0];
        }
    }

    public String getVampireName() {
        return vampireName;
    }

    public String[] getBloodTypes() {
        return bloodTypes;
    }
}
