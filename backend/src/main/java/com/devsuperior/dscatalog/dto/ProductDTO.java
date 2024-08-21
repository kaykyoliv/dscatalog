package com.devsuperior.dscatalog.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {
	
    private Long id;
    
    @Size(min = 5, max = 60, message = "Nome deve ter entre 5 e 60 caracteres")
    @NotBlank(message = "Campo Requerido")
    private String name;
    
    @PastOrPresent(message = "A data do produto não pode ser futura")
    private Instant date;
    @NotBlank(message = "Campo Requerido")
    private String description;
    
    @Positive(message = "O preço deve ser um valor positivo")
    private Double price;
    private String imgUrl;
    
    private List<CategoryDTO> categories = new ArrayList<>();

	public ProductDTO(Long id, String name, Instant date, String description, Double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		date = entity.getDate();
		description = entity.getDescription();
		price = entity.getPrice();
		imgUrl = entity.getImgUrl();
		for(Category cat : entity.getCategories()) {
			categories.add(new CategoryDTO(cat));
		}
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Instant getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}  
}
