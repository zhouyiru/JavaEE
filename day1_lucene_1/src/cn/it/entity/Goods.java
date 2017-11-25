package cn.it.entity;

import java.io.Serializable;

public class Goods implements Serializable {

	private static final long serialVersionUID = 6341267507850856097L;
	
	private Integer goodsId;
	private String goodsName;
	private Double goodsPrice;
	private String goodsRemark;
	
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName
				+ ", goodsPrice=" + goodsPrice + ", goodsRemark=" + goodsRemark
				+ "]";
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsRemark() {
		return goodsRemark;
	}
	public void setGoodsRemark(String goodsRemark) {
		this.goodsRemark = goodsRemark;
	}

}
