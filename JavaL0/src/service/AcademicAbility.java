package service;

public enum AcademicAbility {
    KEM("Kém"),
    YEU("Yếu"),
    TRUNG_BINH("Trung Bình"),
    KHA("Khá"),
    GIOI("Giỏi"),
    XUAT_SAC("Xuất Sắc");

    private String description;

    AcademicAbility(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
