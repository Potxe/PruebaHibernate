package jose.aos.entitis;
// Generated 27-jun-2017 12:19:59 by Hibernate Tools 5.2.3.Final

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Reguistro generated by hbm2java
 */
@Entity
@Table(name = "REGUISTRO", schema = "HR")
public class Reguistro implements java.io.Serializable {

	private UUID id;

	public Reguistro() {
	}

	public Reguistro(UUID id) {
		this.id = id;
	}

	@Id

	@Column(name = "ID", length = 36)
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}