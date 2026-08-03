public enum Major {
    COMPUTER_SCIENCE(1, "Computer Science"),
    SOFTWARE_ENGINEERING(2, "Software Engineering"),
    INFORMATION_TECHNOLOGY(3, "Information Technology"),
    MATHEMATICS(4, "Mathematics"),
    PHYSICS(5, "Physics"),
    ELECTRICAL_ENGINEERING(6, "Electrical Engineering"),
    MECHANICAL_ENGINEERING(7, "Mechanical Engineering"),
    BUSINESS_ADMINISTRATION(8, "Business Administration");

    private final int majorId;
    private final String label;

    Major(int majorId, String label) {
        this.majorId = majorId;
        this.label = label;
    }

    public int getMajorId() {
        return majorId;
    }

    public String getLabel() {
        return label;
    }

    public static Major findMajor(int majorId) {
        for (Major m : values()) {
            if (m.majorId == majorId) {
                return m;
            }
        }
        return null;
    }
}
