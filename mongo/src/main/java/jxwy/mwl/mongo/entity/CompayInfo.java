package jxwy.mwl.mongo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("SSZT_JBXX110497")
@ToString
@Data
@EqualsAndHashCode(callSuper = false)
public class CompayInfo implements Serializable{
	 private static final long serialVersionUID = 1L;  
	 private String id;  
	 private String JYFW;  //经营范围
	 private String ZCZB;  //注册资本
	 private String RECORDID;  //唯一编码
	 private String QYMC;  //企业名称
	 private String HYML;  //行业门类
	 private String LSQYMC;  //隶属企业名称
	 private String LSQYZCH;  //隶属企业注册号
	 private String FDDBR;  //法人
	 private String SWZH;  //身份证号
	 private String SBSSZB;  //申报实收资本
	 private String TYSHXYDM;  //统一社会信用代码
	 private String JYQXZ;  //经营期限止
	 private String JYQXQ;  //经营期限起
	 private String HZRQ;  //核证日期
	 private String HYDM;  //行业代码
	 private String BIZHONG;  //币种
	 private String ZZJGDM;   //组织机构代码
	 private String JYCS;  		//经营场所
	 private String NJQK;  		//年检情况
	 private String CLRQ;  //成立日期
	 private String ZCH;   //注册号
	 private String BZ;   //备注
	 private String NDBGXX;   //年度报告信息
	 private String SSZTLX;  //商事主体类型
	 private String YYZT;   // 企业状态
	 private String INS;  //
	 private String SEQ;  
	 private String UPDATESTATUS;  
	 private String UPDATETIME;  //推送时间
	
	
	@Override
	public String toString() {
		return "CompayInfo [id=" + id + ", JYFW=" + JYFW + ", ZCZB=" + ZCZB + ", RECORDID=" + RECORDID + ", QYMC="
				+ QYMC + ", HYML=" + HYML + ", LSQYMC=" + LSQYMC + ", LSQYZCH=" + LSQYZCH + ", FDDBR=" + FDDBR
				+ ", SWZH=" + SWZH + ", SBSSZB=" + SBSSZB + ", TYSHXYDM=" + TYSHXYDM + ", JYQXZ=" + JYQXZ + ", JYQXQ="
				+ JYQXQ + ", HZRQ=" + HZRQ + ", HYDM=" + HYDM + ", BIZHONG=" + BIZHONG + ", ZZJGDM=" + ZZJGDM
				+ ", JYCS=" + JYCS + ", NJQK=" + NJQK + ", CLRQ=" + CLRQ + ", ZCH=" + ZCH + ", BZ=" + BZ + ", NDBGXX="
				+ NDBGXX + ", SSZTLX=" + SSZTLX + ", YYZT=" + YYZT + ", INS=" + INS + ", SEQ=" + SEQ + ", UPDATESTATUS="
				+ UPDATESTATUS + ", UPDATETIME=" + UPDATETIME + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BIZHONG == null) ? 0 : BIZHONG.hashCode());
		result = prime * result + ((BZ == null) ? 0 : BZ.hashCode());
		result = prime * result + ((CLRQ == null) ? 0 : CLRQ.hashCode());
		result = prime * result + ((FDDBR == null) ? 0 : FDDBR.hashCode());
		result = prime * result + ((HYDM == null) ? 0 : HYDM.hashCode());
		result = prime * result + ((HYML == null) ? 0 : HYML.hashCode());
		result = prime * result + ((HZRQ == null) ? 0 : HZRQ.hashCode());
		result = prime * result + ((INS == null) ? 0 : INS.hashCode());
		result = prime * result + ((JYCS == null) ? 0 : JYCS.hashCode());
		result = prime * result + ((JYFW == null) ? 0 : JYFW.hashCode());
		result = prime * result + ((JYQXQ == null) ? 0 : JYQXQ.hashCode());
		result = prime * result + ((JYQXZ == null) ? 0 : JYQXZ.hashCode());
		result = prime * result + ((LSQYMC == null) ? 0 : LSQYMC.hashCode());
		result = prime * result + ((LSQYZCH == null) ? 0 : LSQYZCH.hashCode());
		result = prime * result + ((NDBGXX == null) ? 0 : NDBGXX.hashCode());
		result = prime * result + ((NJQK == null) ? 0 : NJQK.hashCode());
		result = prime * result + ((QYMC == null) ? 0 : QYMC.hashCode());
		result = prime * result + ((RECORDID == null) ? 0 : RECORDID.hashCode());
		result = prime * result + ((SBSSZB == null) ? 0 : SBSSZB.hashCode());
		result = prime * result + ((SEQ == null) ? 0 : SEQ.hashCode());
		result = prime * result + ((SSZTLX == null) ? 0 : SSZTLX.hashCode());
		result = prime * result + ((SWZH == null) ? 0 : SWZH.hashCode());
		result = prime * result + ((TYSHXYDM == null) ? 0 : TYSHXYDM.hashCode());
		result = prime * result + ((UPDATESTATUS == null) ? 0 : UPDATESTATUS.hashCode());
		result = prime * result + ((UPDATETIME == null) ? 0 : UPDATETIME.hashCode());
		result = prime * result + ((YYZT == null) ? 0 : YYZT.hashCode());
		result = prime * result + ((ZCH == null) ? 0 : ZCH.hashCode());
		result = prime * result + ((ZCZB == null) ? 0 : ZCZB.hashCode());
		result = prime * result + ((ZZJGDM == null) ? 0 : ZZJGDM.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompayInfo other = (CompayInfo) obj;
		if (BIZHONG == null) {
			if (other.BIZHONG != null)
				return false;
		} else if (!BIZHONG.equals(other.BIZHONG))
			return false;
		if (BZ == null) {
			if (other.BZ != null)
				return false;
		} else if (!BZ.equals(other.BZ))
			return false;
		if (CLRQ == null) {
			if (other.CLRQ != null)
				return false;
		} else if (!CLRQ.equals(other.CLRQ))
			return false;
		if (FDDBR == null) {
			if (other.FDDBR != null)
				return false;
		} else if (!FDDBR.equals(other.FDDBR))
			return false;
		if (HYDM == null) {
			if (other.HYDM != null)
				return false;
		} else if (!HYDM.equals(other.HYDM))
			return false;
		if (HYML == null) {
			if (other.HYML != null)
				return false;
		} else if (!HYML.equals(other.HYML))
			return false;
		if (HZRQ == null) {
			if (other.HZRQ != null)
				return false;
		} else if (!HZRQ.equals(other.HZRQ))
			return false;
		if (INS == null) {
			if (other.INS != null)
				return false;
		} else if (!INS.equals(other.INS))
			return false;
		if (JYCS == null) {
			if (other.JYCS != null)
				return false;
		} else if (!JYCS.equals(other.JYCS))
			return false;
		if (JYFW == null) {
			if (other.JYFW != null)
				return false;
		} else if (!JYFW.equals(other.JYFW))
			return false;
		if (JYQXQ == null) {
			if (other.JYQXQ != null)
				return false;
		} else if (!JYQXQ.equals(other.JYQXQ))
			return false;
		if (JYQXZ == null) {
			if (other.JYQXZ != null)
				return false;
		} else if (!JYQXZ.equals(other.JYQXZ))
			return false;
		if (LSQYMC == null) {
			if (other.LSQYMC != null)
				return false;
		} else if (!LSQYMC.equals(other.LSQYMC))
			return false;
		if (LSQYZCH == null) {
			if (other.LSQYZCH != null)
				return false;
		} else if (!LSQYZCH.equals(other.LSQYZCH))
			return false;
		if (NDBGXX == null) {
			if (other.NDBGXX != null)
				return false;
		} else if (!NDBGXX.equals(other.NDBGXX))
			return false;
		if (NJQK == null) {
			if (other.NJQK != null)
				return false;
		} else if (!NJQK.equals(other.NJQK))
			return false;
		if (QYMC == null) {
			if (other.QYMC != null)
				return false;
		} else if (!QYMC.equals(other.QYMC))
			return false;
		if (RECORDID == null) {
			if (other.RECORDID != null)
				return false;
		} else if (!RECORDID.equals(other.RECORDID))
			return false;
		if (SBSSZB == null) {
			if (other.SBSSZB != null)
				return false;
		} else if (!SBSSZB.equals(other.SBSSZB))
			return false;
		if (SEQ == null) {
			if (other.SEQ != null)
				return false;
		} else if (!SEQ.equals(other.SEQ))
			return false;
		if (SSZTLX == null) {
			if (other.SSZTLX != null)
				return false;
		} else if (!SSZTLX.equals(other.SSZTLX))
			return false;
		if (SWZH == null) {
			if (other.SWZH != null)
				return false;
		} else if (!SWZH.equals(other.SWZH))
			return false;
		if (TYSHXYDM == null) {
			if (other.TYSHXYDM != null)
				return false;
		} else if (!TYSHXYDM.equals(other.TYSHXYDM))
			return false;
		if (UPDATESTATUS == null) {
			if (other.UPDATESTATUS != null)
				return false;
		} else if (!UPDATESTATUS.equals(other.UPDATESTATUS))
			return false;
		if (UPDATETIME == null) {
			if (other.UPDATETIME != null)
				return false;
		} else if (!UPDATETIME.equals(other.UPDATETIME))
			return false;
		if (YYZT == null) {
			if (other.YYZT != null)
				return false;
		} else if (!YYZT.equals(other.YYZT))
			return false;
		if (ZCH == null) {
			if (other.ZCH != null)
				return false;
		} else if (!ZCH.equals(other.ZCH))
			return false;
		if (ZCZB == null) {
			if (other.ZCZB != null)
				return false;
		} else if (!ZCZB.equals(other.ZCZB))
			return false;
		if (ZZJGDM == null) {
			if (other.ZZJGDM != null)
				return false;
		} else if (!ZZJGDM.equals(other.ZZJGDM))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJYFW() {
		return JYFW;
	}
	public void setJYFW(String jYFW) {
		JYFW = jYFW;
	}
	public String getZCZB() {
		return ZCZB;
	}
	public void setZCZB(String zCZB) {
		ZCZB = zCZB;
	}
	public String getRECORDID() {
		return RECORDID;
	}
	public void setRECORDID(String rECORDID) {
		RECORDID = rECORDID;
	}
	public String getQYMC() {
		return QYMC;
	}
	public void setQYMC(String qYMC) {
		QYMC = qYMC;
	}
	public String getHYML() {
		return HYML;
	}
	public void setHYML(String hYML) {
		HYML = hYML;
	}
	public String getLSQYMC() {
		return LSQYMC;
	}
	public void setLSQYMC(String lSQYMC) {
		LSQYMC = lSQYMC;
	}
	public String getLSQYZCH() {
		return LSQYZCH;
	}
	public void setLSQYZCH(String lSQYZCH) {
		LSQYZCH = lSQYZCH;
	}
	public String getFDDBR() {
		return FDDBR;
	}
	public void setFDDBR(String fDDBR) {
		FDDBR = fDDBR;
	}
	public String getSWZH() {
		return SWZH;
	}
	public void setSWZH(String sWZH) {
		SWZH = sWZH;
	}
	public String getSBSSZB() {
		return SBSSZB;
	}
	public void setSBSSZB(String sBSSZB) {
		SBSSZB = sBSSZB;
	}
	public String getTYSHXYDM() {
		return TYSHXYDM;
	}
	public void setTYSHXYDM(String tYSHXYDM) {
		TYSHXYDM = tYSHXYDM;
	}
	public String getJYQXZ() {
		return JYQXZ;
	}
	public void setJYQXZ(String jYQXZ) {
		JYQXZ = jYQXZ;
	}
	public String getJYQXQ() {
		return JYQXQ;
	}
	public void setJYQXQ(String jYQXQ) {
		JYQXQ = jYQXQ;
	}
	public String getHZRQ() {
		return HZRQ;
	}
	public void setHZRQ(String hZRQ) {
		HZRQ = hZRQ;
	}
	public String getHYDM() {
		return HYDM;
	}
	public void setHYDM(String hYDM) {
		HYDM = hYDM;
	}
	public String getBIZHONG() {
		return BIZHONG;
	}
	public void setBIZHONG(String bIZHONG) {
		BIZHONG = bIZHONG;
	}
	public String getZZJGDM() {
		return ZZJGDM;
	}
	public void setZZJGDM(String zZJGDM) {
		ZZJGDM = zZJGDM;
	}
	public String getJYCS() {
		return JYCS;
	}
	public void setJYCS(String jYCS) {
		JYCS = jYCS;
	}
	public String getNJQK() {
		return NJQK;
	}
	public void setNJQK(String nJQK) {
		NJQK = nJQK;
	}
	public String getCLRQ() {
		return CLRQ;
	}
	public void setCLRQ(String cLRQ) {
		CLRQ = cLRQ;
	}
	public String getZCH() {
		return ZCH;
	}
	public void setZCH(String zCH) {
		ZCH = zCH;
	}
	public String getBZ() {
		return BZ;
	}
	public void setBZ(String bZ) {
		BZ = bZ;
	}
	public String getNDBGXX() {
		return NDBGXX;
	}
	public void setNDBGXX(String nDBGXX) {
		NDBGXX = nDBGXX;
	}
	public String getSSZTLX() {
		return SSZTLX;
	}
	public void setSSZTLX(String sSZTLX) {
		SSZTLX = sSZTLX;
	}
	public String getYYZT() {
		return YYZT;
	}
	public void setYYZT(String yYZT) {
		YYZT = yYZT;
	}
	public String getINS() {
		return INS;
	}
	public void setINS(String iNS) {
		INS = iNS;
	}
	public String getSEQ() {
		return SEQ;
	}
	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}
	public String getUPDATESTATUS() {
		return UPDATESTATUS;
	}
	public void setUPDATESTATUS(String uPDATESTATUS) {
		UPDATESTATUS = uPDATESTATUS;
	}
	public String getUPDATETIME() {
		return UPDATETIME;
	}
	public void setUPDATETIME(String uPDATETIME) {
		UPDATETIME = uPDATETIME;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
