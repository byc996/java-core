package com.byc.pattern.builder;


interface ProductBuilder {
    void buildProductName(String productName);
    void buildCompanyName(String companyName);
    void buildPart1(String part1);
    void buildPart2(String part2);
    void buildPart3(String part3);
    void buildPart4(String part4);

    Product build();
}

class DefaultConcreteProductBuilder implements ProductBuilder{
    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    @Override
    public void buildProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void buildCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void buildPart1(String part1) {
        this.part1 = part1;
    }

    @Override
    public void buildPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public void buildPart3(String part3) {
        this.part3 = part3;
    }

    @Override
    public void buildPart4(String part4) {
        this.part4 = part4;
    }

    @Override
    public Product build() {
        return new Product(productName, companyName, part1, part2, part3, part4);
    }
}

class Director {
    private ProductBuilder builder;

    public Director(ProductBuilder builder) {
        this.builder = builder;
    }

    public Product makeProduct (String productName, String companyName, String part1, String part2, String part3, String part4) {
        builder.buildProductName(productName);
        builder.buildCompanyName(companyName);
        builder.buildPart1(part1);
        builder.buildPart2(part2);
        builder.buildPart3(part3);
        builder.buildPart4(part4);
        Product product = builder.build();
        return product;
    }
}

class Product {
    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    public Product(String productName, String companyName, String part1, String part2, String part3, String part4) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public String getPart3() {
        return part3;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }

    public String getPart4() {
        return part4;
    }

    public void setPart4(String part4) {
        this.part4 = part4;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                '}';
    }
}

public class BuilderDemo {
    public static void main(String[] args) {
        ProductBuilder builder = new DefaultConcreteProductBuilder();
        Director director = new Director(builder);
        Product product = director.makeProduct("pn", "cn", "p1", "p2", "p3", "p4");
        System.out.println(product);
    }
}
