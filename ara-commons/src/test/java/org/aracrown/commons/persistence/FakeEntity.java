package org.aracrown.commons.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="FAKE_ENTITY", indexes={@Index(name="NAME_IDX", columnList="NAME_")})
public class FakeEntity {
	/** The primary key. */
	@Id
	@SequenceGenerator(name = "XAL_COUNTRY_ID_GENERATOR", sequenceName = "XAL_COUNTRY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XAL_COUNTRY_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private Long id;

	/** The country name. */
	
	@NotNull(message = "Name is missing")
	@Size(min=3, max = 255)
	@Column(name = "NAME_", nullable = false, unique = true, length = 255)
	private String name;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the primary key for country. Used by persistence engine.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
