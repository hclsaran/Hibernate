package com.saran;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//POJO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	private int prdId;
	private String prdName;
	private int prdPrice;

}
