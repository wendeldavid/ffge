package ff.grosso.escroto.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Grosseria implements Serializable {

	private static final long serialVersionUID = -3954819000251764966L;

	private long id;
	private LocalDateTime data;
	private String acao;
	private String vitima;
	private String descricao;
	private String replica;
	private boolean hide;
	private String[] likes;

	public Grosseria(long id, LocalDateTime data, String acao, String vitima, String descricao, String replica, boolean hide, String[] likes) {
		super();
		this.setId(id);
		this.data = data;
		this.acao = acao;
		this.vitima = vitima;
		this.descricao = descricao;
		this.replica = replica;
		this.hide = hide;
		this.likes = likes;
		if (this.likes == null) {
			this.likes = new String[0];
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public String getVitima() {
		return vitima;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acao == null) ? 0 : acao.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + (hide ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + Arrays.hashCode(likes);
		result = prime * result + ((replica == null) ? 0 : replica.hashCode());
		result = prime * result + ((vitima == null) ? 0 : vitima.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Grosseria)) {
			return false;
		}
		Grosseria other = (Grosseria) obj;
		if (acao == null) {
			if (other.acao != null) {
				return false;
			}
		} else if (!acao.equals(other.acao)) {
			return false;
		}
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
			return false;
		}
		if (descricao == null) {
			if (other.descricao != null) {
				return false;
			}
		} else if (!descricao.equals(other.descricao)) {
			return false;
		}
		if (hide != other.hide) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (!Arrays.equals(likes, other.likes)) {
			return false;
		}
		if (replica == null) {
			if (other.replica != null) {
				return false;
			}
		} else if (!replica.equals(other.replica)) {
			return false;
		}
		if (vitima == null) {
			if (other.vitima != null) {
				return false;
			}
		} else if (!vitima.equals(other.vitima)) {
			return false;
		}
		return true;
	}

	public void setVitima(String vitima) {
		this.vitima = vitima;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getReplica() {
		return this.replica;
	}

	public void setReplica(String replica) {
		this.replica = replica;
	}

	public boolean isHide() {
		return hide;
	}

	public void setHide(boolean hide) {
		this.hide = hide;
	}

	public String[] getLikes() {
		return likes;
	}

	public void setLikes(String[] likes) {
		this.likes = likes;
		if (this.likes == null) {
			this.likes = new String[0];
		}
	}

}
