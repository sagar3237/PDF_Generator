package com.example.PDF_GENERATOR;

import java.util.List;
 class PdfData {
        private String seller;
        private String sellerGstin;
        private String sellerAddress;
        private String buyer;
        private String buyerGstin;
        private String buyerAddress;
        private List<Item> items;

        // Default constructor
        public PdfData() {
        }

        // Constructor with fields
        public PdfData(String seller, String sellerGstin, String sellerAddress, String buyer, String buyerGstin, String buyerAddress, List<Item> items) {
            this.seller = seller;
            this.sellerGstin = sellerGstin;
            this.sellerAddress = sellerAddress;
            this.buyer = buyer;
            this.buyerGstin = buyerGstin;
            this.buyerAddress = buyerAddress;
            this.items = items;
        }

     public String getSeller() {
         return seller;
     }

     public void setSeller(String seller) {
         this.seller = seller;
     }

     public String getSellerGstin() {
         return sellerGstin;
     }

     public void setSellerGstin(String sellerGstin) {
         this.sellerGstin = sellerGstin;
     }

     public String getSellerAddress() {
         return sellerAddress;
     }

     public void setSellerAddress(String sellerAddress) {
         this.sellerAddress = sellerAddress;
     }

     public String getBuyer() {
         return buyer;
     }

     public void setBuyer(String buyer) {
         this.buyer = buyer;
     }

     public String getBuyerGstin() {
         return buyerGstin;
     }

     public void setBuyerGstin(String buyerGstin) {
         this.buyerGstin = buyerGstin;
     }

     public String getBuyerAddress() {
         return buyerAddress;
     }

     public void setBuyerAddress(String buyerAddress) {
         this.buyerAddress = buyerAddress;
     }

     public List<Item> getItems() {
         return items;
     }

     public void setItems(List<Item> items) {
         this.items = items;
     }

     // Getters and setters

        static class Item {
            private String name;
            private String quantity;
            private double rate;
            private double amount;

            Item(String name, String quantity, double rate, double amount) {
                this.name = name;
                this.quantity = quantity;
                this.rate = rate;
                this.amount = amount;
            }

            public Item() {
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getQuantity() {
                return quantity;
            }

            public void setQuantity(String quantity) {
                this.quantity = quantity;
            }

            public double getRate() {
                return rate;
            }

            public void setRate(double rate) {
                this.rate = rate;
            }

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }
        }
    }



