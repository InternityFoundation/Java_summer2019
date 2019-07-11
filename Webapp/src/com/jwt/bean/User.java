package com.jwt.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class User {
			
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name = "id")
			private int id;
			
			@Column(name = "name")
			private String name;
			
			@Column(name = "address")
			private String address;
			
			@Column(name = "phone_no")
			private String phoneNo;
			
			@Column(name = "email")
			private String email;
			
			@Column(name = "experience")
			private String exp;
			
			public User() {
				
			}

			public User(String name, String address, String phoneNo, String email, String exp) {
				this.name = name;
				this.address = address;
				this.phoneNo = phoneNo;
				this.email = email;
				this.exp = exp;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getAddress() {
				return address;
			}

			public void setAddress(String address) {
				this.address = address;
			}

			public String getPhoneNo() {
				return phoneNo;
			}

			public void setPhoneNo(String phoneNo) {
				this.phoneNo = phoneNo;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public String getExp() {
				return exp;
			}

			public void setExp(String exp) {
				this.exp = exp;
			}

			@Override
			public String toString() {
				return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", phoneNo=" + phoneNo + ", email="
						+ email + ", exp=" + exp + "]";
			}
			
			

}
