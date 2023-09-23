package iuh.vn.edu.fit.enums;

public enum ProductStatus {
    //Một product có nhiều image, một image thuộc về
    // một product. Status chỉ  trạng thái kinh
    //doanh của sản phẩm: 1- đang kinh doanh, 0 - tạm ngưng,
    // -1 - không kinh doanh nữa.

    ACTIVE(1),
    IN_ACTIVE(0),
    TERMINATED(-1);

    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
