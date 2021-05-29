package karmanchik.demoexam.uijfx.view;

public enum SortView {
    NONE("Без сортировки"),
    ASC("По возрастанию"),
    DESC("По убыванию");

    private final String val;

    SortView(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
