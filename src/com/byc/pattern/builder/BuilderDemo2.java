package com.byc.pattern.builder;


class Product2 {
    private final String productName;
    private final String companyName;
    private final String part1;

    public Product2(String productName, String companyName, String part1) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
    }

    static class Builder {
        private String productName;
        private String companyName;
        private String part1;

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder setPart1(String part1) {
            this.part1 = part1;
            return this;
        }

        public Product2 build() {
            return new Product2(productName, companyName, part1);
        }
    }

    @Override
    public String toString() {
        return "Product2{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", part1='" + part1 + '\'' +
                '}';
    }
}

public class BuilderDemo2 {

    public static void main(String[] args) {
        Product2.Builder builder = new Product2.Builder();
        builder.setProductName("pn").setCompanyName("cn").setPart1("p1");
        Product2 product2 = builder.build();
        System.out.println(product2);
    }
}
