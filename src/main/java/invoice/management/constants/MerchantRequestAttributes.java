package invoice.management.constants;

public enum MerchantRequestAttributes {
    FIRST_NAME("firstname"),
    LAST_NAME("lastname"),
    STREET("street"),
    PHONE("phone"),
    DATE("date"),
    TIME("time"),
    FIRST("first"),
    LAST("last"),
    COUNTRY("country"),
    NAME("name"),
    ID("id");



    public final String label;

    private MerchantRequestAttributes(String label){
        this.label=label;
    }
}
