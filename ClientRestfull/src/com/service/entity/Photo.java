package com.service.entity;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement()
public class Photo {
	String name;
	String path;
	public Photo(){};
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", path=" + path + "]";
	}
}
