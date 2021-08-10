package com.senpiper.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="center")
public class Center {
	//center model class
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@NotEmpty
	@Column(length=42)
	@Size(max=40,message = "less than 40")
    private String centerName;
	@Column(length=15)
	@NotEmpty
	@Pattern(regexp = "{A-Za-z0-9}*",message = "must be alphanumeric and exact 12")
	@Size(min=12, max=12)
    private String centerCode;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private CenterAddress address;
    @Column(length=5)
    private Integer studentCapacity;
    @ElementCollection
    @CollectionTable(name = "courses_Offered")
    @Column(name = "course")
    private List<String> coursesOffered;
    @Column(name = "createdOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @NotEmpty
    @Email(message = "invalid email address")
    private String contactEmail;
    @NotEmpty
    @Pattern(regexp="(^$|[0-9]{10})",message = "invalid mobile number")
    private String contactPhone;
    
}
