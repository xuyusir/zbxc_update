package com.jy.entiy.function.marketingFunction.lotteryManagement;

import java.util.Date;
import java.util.List;

public class Drawlotteryconfig {
	//抽奖活动表主键id
    private Integer drawlotteryconfigid;
    //标题
    private String drawlotterytitle;
    //活动说明
    private String drawlotterycontent;
    //二维码地址
    private String twodimensionpath;
    //抽奖地址
    private String drawlotterypageurl;

    private String twodimensionname;

    private Date createtime;

    private String ceateby;

    private Long createpersonid;

    private Date updatetime;

    private String updateby;

    private Long updatepersonid;
    //可抽奖次数
    private Integer drawlotteryno;
    //可中奖次数
    private Integer getlotteryno;
    //状态id
    private Integer votestatusid;
    //参与人群id(1所有用户2会员)
    private Integer voteparticipanttypeid;
    //奖项列表
    private List<Drawlotteryitem> drawlotteryitems;

    /**
	 * @return the drawlotteryitems
	 */
	public List<Drawlotteryitem> getDrawlotteryitems() {
		return drawlotteryitems;
	}

	/**
	 * @param drawlotteryitems the drawlotteryitems to set
	 */
	public void setDrawlotteryitems(List<Drawlotteryitem> drawlotteryitems) {
		this.drawlotteryitems = drawlotteryitems;
	}

	public Integer getDrawlotteryconfigid() {
        return drawlotteryconfigid;
    }

    public void setDrawlotteryconfigid(Integer drawlotteryconfigid) {
        this.drawlotteryconfigid = drawlotteryconfigid;
    }

    public String getDrawlotterytitle() {
        return drawlotterytitle;
    }

    public void setDrawlotterytitle(String drawlotterytitle) {
        this.drawlotterytitle = drawlotterytitle == null ? null : drawlotterytitle.trim();
    }

    public String getDrawlotterycontent() {
        return drawlotterycontent;
    }

    public void setDrawlotterycontent(String drawlotterycontent) {
        this.drawlotterycontent = drawlotterycontent == null ? null : drawlotterycontent.trim();
    }

    public String getTwodimensionpath() {
        return twodimensionpath;
    }

    public void setTwodimensionpath(String twodimensionpath) {
        this.twodimensionpath = twodimensionpath == null ? null : twodimensionpath.trim();
    }

    public String getDrawlotterypageurl() {
        return drawlotterypageurl;
    }

    public void setDrawlotterypageurl(String drawlotterypageurl) {
        this.drawlotterypageurl = drawlotterypageurl == null ? null : drawlotterypageurl.trim();
    }

    public String getTwodimensionname() {
        return twodimensionname;
    }

    public void setTwodimensionname(String twodimensionname) {
        this.twodimensionname = twodimensionname == null ? null : twodimensionname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCeateby() {
        return ceateby;
    }

    public void setCeateby(String ceateby) {
        this.ceateby = ceateby == null ? null : ceateby.trim();
    }

    public Long getCreatepersonid() {
        return createpersonid;
    }

    public void setCreatepersonid(Long createpersonid) {
        this.createpersonid = createpersonid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
    }

    public Long getUpdatepersonid() {
        return updatepersonid;
    }

    public void setUpdatepersonid(Long updatepersonid) {
        this.updatepersonid = updatepersonid;
    }

    public Integer getDrawlotteryno() {
        return drawlotteryno;
    }

    public void setDrawlotteryno(Integer drawlotteryno) {
        this.drawlotteryno = drawlotteryno;
    }

    public Integer getGetlotteryno() {
        return getlotteryno;
    }

    public void setGetlotteryno(Integer getlotteryno) {
        this.getlotteryno = getlotteryno;
    }

    public Integer getVotestatusid() {
        return votestatusid;
    }

    public void setVotestatusid(Integer votestatusid) {
        this.votestatusid = votestatusid;
    }

    public Integer getVoteparticipanttypeid() {
        return voteparticipanttypeid;
    }

    public void setVoteparticipanttypeid(Integer voteparticipanttypeid) {
        this.voteparticipanttypeid = voteparticipanttypeid;
    }
}