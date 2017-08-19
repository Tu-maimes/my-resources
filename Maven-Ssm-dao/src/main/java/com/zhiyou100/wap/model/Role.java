package com.zhiyou100.wap.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Role {
    private Integer rId;

    private String rName;

    private String rDesc;
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date rUpdatetime;

    private String rPic;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public String getrDesc() {
        return rDesc;
    }

    public void setrDesc(String rDesc) {
        this.rDesc = rDesc == null ? null : rDesc.trim();
    }

    public Date getrUpdatetime() {
        return rUpdatetime;
    }

    public void setrUpdatetime(Date rUpdatetime) {
        this.rUpdatetime = rUpdatetime;
    }

    public String getrPic() {
        return rPic;
    }

    public void setrPic(String rPic) {
        this.rPic = rPic == null ? null : rPic.trim();
    }

	@Override
	public String toString() {
		return "Role [rId=" + rId + ", rName=" + rName + ", rDesc=" + rDesc + ", rUpdatetime=" + rUpdatetime + ", rPic="
				+ rPic + "]";
	}
    
}