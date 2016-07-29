package ff.grosso.escroto.data;

import java.util.Collection;

public class FF {
	private long dias;
	private long recorde;
	private Collection<Grosseria> grosserias;

	public FF(long dias, long recorde, String lastOffence, Collection<Grosseria> grosserias) {
		super();
		this.dias = dias;
		this.recorde = recorde;
		this.grosserias = grosserias;
	}

	public long getDias() {
		return dias;
	}

	public void setDias(long dias) {
		this.dias = dias;
	}

	public long getRecorde() {
		return recorde;
	}

	public void setRecorde(long recorde) {
		this.recorde = recorde;
	}

	public Collection<Grosseria> getGrosserias() {
		return grosserias;
	}

	public void setGrosserias(Collection<Grosseria> grosserias) {
		this.grosserias = grosserias;
	}
}
