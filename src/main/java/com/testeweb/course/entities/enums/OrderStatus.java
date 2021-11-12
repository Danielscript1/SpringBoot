package com.testeweb.course.entities.enums;

public enum OrderStatus {
	//ATRIBUIR NUMERO IDENTIFICADOR PARA ASSOCIAR CADA ENUMS
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	//logica de atribição
	private int code;
	
	private  OrderStatus(int code) {
		this.code = code;
	}
	
	//retorna meu code
	public int getCode() {
		return code;
	}
	
	//metodo static converte o valor numerico para um tipo enumerado
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("codigo invalido!");
		
	}
	
}
