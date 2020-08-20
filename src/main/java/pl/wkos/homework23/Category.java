package pl.wkos.homework23;

public enum Category {
    CROCERIES("Art. spożywcze"),
    HOUSEHOLD("Art. gosp. domowego"),
    OTHER("Inne");

    private final String category;

    Category(String category) {
        this.category = category;
    }


    public String getName() {
        return category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category='" + category + '\'' +
                '}';
    }
}
