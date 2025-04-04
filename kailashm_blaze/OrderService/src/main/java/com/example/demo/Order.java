package com.example.demo;

public class Order {
	  private String orderId;
	    private String productId;
	    private int quantity;
	    
	    @Override
		public String toString() {
			return "Order [orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + "]";
		}

		public String getOrderId() {
			return orderId;
		}

		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}

		public String getProductId() {
			return productId;
		}

		public void setProductId(String productId) {
			this.productId = productId;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public Order(String orderId, String productId, int quantity) {
	        this.orderId = orderId;
	        this.productId = productId;
	        this.quantity = quantity;
	    }
}
