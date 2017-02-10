package ff.grosso.escroto.data;

import java.time.LocalDateTime;

public class Grosseria {
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
