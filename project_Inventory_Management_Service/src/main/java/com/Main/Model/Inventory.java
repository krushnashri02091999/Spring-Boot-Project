package com.Main.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inventory {
	@Id
	private Long id;

	private String name;

	private int quantity;

	public Long getId() {
		return id;
	}

	public void setId(long i) {
		this.id = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", name=" + name + ", quantity=" + quantity + "]";
	}
	public Inventory(Long id, String name, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}
	public Inventory() {
	}
}