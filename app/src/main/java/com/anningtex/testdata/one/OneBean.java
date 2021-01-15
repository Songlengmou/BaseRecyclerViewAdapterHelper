package com.anningtex.testdata.one;

import java.util.List;

/**
 * @Author Song
 */
public class OneBean {

    /**
     * code : 1
     * msg : Success
     * data : {"ID":"171","PIID":"171","BvCode":"BV2019264083","LoadDate":"2020-09-23","FromPort":"Kampala","ToCountryID":"1","ToPort":"Ishasha","ClearBorder":"Ishasha","DeliveryNo":"AOCG20191102-2","PlateNo":"123456","Driver":"three","PhoneNo":"123456789","Notes":"","VolumeTotal":"1.3316","WeightTotal":"602.6","QBalesTotal":"11","GoodsList":[{"TexType":"IsFlower","Container":[{"ContainerNo":"PCIU1766670","ContainerList":[{"PIGLID":4127,"PIID":"171","BGLID":"1530","QBales":1,"InDate":"2020-09-02","BLNo":"NGNT01718100","ContainerNo":"PCIU1766670","OrderNo":"SF191206A","VolumeUnit":"0.1000","WeightUnit":"72.0000","MetersPerBale":"600.0000","MetersPerBaleUnitID":"1","TexID_01":"479","TexType":"IsFlower","TexName_Show":"SF","UnitName":"码","UnitNameEN":"y"},{"PIGLID":4124,"PIID":"171","BGLID":"1531","QBales":2,"InDate":"2020-09-02","BLNo":"NGNT01718100","ContainerNo":"PCIU1766670","OrderNo":"SF191207A","VolumeUnit":"0.1000","WeightUnit":"73.0000","MetersPerBale":"600.0000","MetersPerBaleUnitID":"1","TexID_01":"479","TexType":"IsFlower","TexName_Show":"SF","UnitName":"码","UnitNameEN":"y"}]}]},{"TexType":"IsColor","Container":[{"ContainerNo":"PCIU9266352","ContainerList":[{"PIGLID":4125,"PIID":"171","BGLID":"1355","QBales":2,"InDate":"2020-07-15","BLNo":"NGNT01710900","ContainerNo":"PCIU9266352","OrderNo":"FX200224A","VolumeUnit":"0.0563","WeightUnit":"14.8000","MetersPerBale":"120.0000","MetersPerBaleUnitID":"5","TexID_01":"446","TexType":"IsColor","TexName_Show":"Thread 3000y","UnitName":"个","UnitNameEN":"pcs"},{"PIGLID":4126,"PIID":"171","BGLID":"1353","QBales":2,"InDate":"2020-07-15","BLNo":"NGNT01710900","ContainerNo":"PCIU9266352","OrderNo":"TC200108K","VolumeUnit":"0.1275","WeightUnit":"64.0000","MetersPerBale":"600.0000","MetersPerBaleUnitID":"1","TexID_01":"8","TexType":"IsColor","TexName_Show":"TC45","UnitName":"码","UnitNameEN":"y"}]},{"ContainerNo":"PCIU0120897","ContainerList":[{"PIGLID":4122,"PIID":"171","BGLID":"1339","QBales":2,"InDate":"2020-07-13","BLNo":"NGNT01710600","ContainerNo":"PCIU0120897","OrderNo":"TR200211Z","VolumeUnit":"0.1120","WeightUnit":"80.0000","MetersPerBale":"300.0000","MetersPerBaleUnitID":"1","TexID_01":"4","TexType":"IsColor","TexName_Show":"TR","UnitName":"码","UnitNameEN":"y","spec":[{"color_name":"G30","bales":1,"meters_per_bale":300,"qsum":300}]}]}]},{"TexType":"IsItem","Container":[{"ContainerNo":"PCIU9266352","ContainerList":[{"PIGLID":4123,"PIID":"171","BGLID":"1356","QBales":2,"InDate":"2020-07-15","BLNo":"NGNT01710900","ContainerNo":"PCIU9266352","OrderNo":"BG200309A","VolumeUnit":"0.2200","WeightUnit":"33.5000","MetersPerBale":"30.0000","MetersPerBaleUnitID":"5","TexID_01":"505","TexType":"IsItem","TexName_Show":"BG","UnitName":"个","UnitNameEN":"pcs","spec":[{"brand_name":"AnningTex","color_name":"123colo","item_name":"G20","bales":2,"meters_per_bale":30,"qsum":60}]}]}]}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * ID : 171
         * PIID : 171
         * BvCode : BV2019264083
         * LoadDate : 2020-09-23
         * FromPort : Kampala
         * ToCountryID : 1
         * ToPort : Ishasha
         * ClearBorder : Ishasha
         * DeliveryNo : AOCG20191102-2
         * PlateNo : 123456
         * Driver : three
         * PhoneNo : 123456789
         * Notes :
         * VolumeTotal : 1.3316
         * WeightTotal : 602.6
         * QBalesTotal : 11
         * GoodsList : [{"TexType":"IsFlower","Container":[{"ContainerNo":"PCIU1766670","ContainerList":[{"PIGLID":4127,"PIID":"171","BGLID":"1530","QBales":1,"InDate":"2020-09-02","BLNo":"NGNT01718100","ContainerNo":"PCIU1766670","OrderNo":"SF191206A","VolumeUnit":"0.1000","WeightUnit":"72.0000","MetersPerBale":"600.0000","MetersPerBaleUnitID":"1","TexID_01":"479","TexType":"IsFlower","TexName_Show":"SF","UnitName":"码","UnitNameEN":"y"},{"PIGLID":4124,"PIID":"171","BGLID":"1531","QBales":2,"InDate":"2020-09-02","BLNo":"NGNT01718100","ContainerNo":"PCIU1766670","OrderNo":"SF191207A","VolumeUnit":"0.1000","WeightUnit":"73.0000","MetersPerBale":"600.0000","MetersPerBaleUnitID":"1","TexID_01":"479","TexType":"IsFlower","TexName_Show":"SF","UnitName":"码","UnitNameEN":"y"}]}]},{"TexType":"IsColor","Container":[{"ContainerNo":"PCIU9266352","ContainerList":[{"PIGLID":4125,"PIID":"171","BGLID":"1355","QBales":2,"InDate":"2020-07-15","BLNo":"NGNT01710900","ContainerNo":"PCIU9266352","OrderNo":"FX200224A","VolumeUnit":"0.0563","WeightUnit":"14.8000","MetersPerBale":"120.0000","MetersPerBaleUnitID":"5","TexID_01":"446","TexType":"IsColor","TexName_Show":"Thread 3000y","UnitName":"个","UnitNameEN":"pcs"},{"PIGLID":4126,"PIID":"171","BGLID":"1353","QBales":2,"InDate":"2020-07-15","BLNo":"NGNT01710900","ContainerNo":"PCIU9266352","OrderNo":"TC200108K","VolumeUnit":"0.1275","WeightUnit":"64.0000","MetersPerBale":"600.0000","MetersPerBaleUnitID":"1","TexID_01":"8","TexType":"IsColor","TexName_Show":"TC45","UnitName":"码","UnitNameEN":"y"}]},{"ContainerNo":"PCIU0120897","ContainerList":[{"PIGLID":4122,"PIID":"171","BGLID":"1339","QBales":2,"InDate":"2020-07-13","BLNo":"NGNT01710600","ContainerNo":"PCIU0120897","OrderNo":"TR200211Z","VolumeUnit":"0.1120","WeightUnit":"80.0000","MetersPerBale":"300.0000","MetersPerBaleUnitID":"1","TexID_01":"4","TexType":"IsColor","TexName_Show":"TR","UnitName":"码","UnitNameEN":"y","spec":[{"color_name":"G30","bales":1,"meters_per_bale":300,"qsum":300}]}]}]},{"TexType":"IsItem","Container":[{"ContainerNo":"PCIU9266352","ContainerList":[{"PIGLID":4123,"PIID":"171","BGLID":"1356","QBales":2,"InDate":"2020-07-15","BLNo":"NGNT01710900","ContainerNo":"PCIU9266352","OrderNo":"BG200309A","VolumeUnit":"0.2200","WeightUnit":"33.5000","MetersPerBale":"30.0000","MetersPerBaleUnitID":"5","TexID_01":"505","TexType":"IsItem","TexName_Show":"BG","UnitName":"个","UnitNameEN":"pcs","spec":[{"brand_name":"AnningTex","color_name":"123colo","item_name":"G20","bales":2,"meters_per_bale":30,"qsum":60}]}]}]}]
         */

        private String ID;
        private String PIID;
        private String BvCode;
        private String LoadDate;
        private String FromPort;
        private String ToCountryID;
        private String ToPort;
        private String ClearBorder;
        private String DeliveryNo;
        private String PlateNo;
        private String Driver;
        private String PhoneNo;
        private String Notes;
        private String VolumeTotal;
        private String WeightTotal;
        private String QBalesTotal;
        private List<GoodsListBean> GoodsList;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getPIID() {
            return PIID;
        }

        public void setPIID(String PIID) {
            this.PIID = PIID;
        }

        public String getBvCode() {
            return BvCode;
        }

        public void setBvCode(String BvCode) {
            this.BvCode = BvCode;
        }

        public String getLoadDate() {
            return LoadDate;
        }

        public void setLoadDate(String LoadDate) {
            this.LoadDate = LoadDate;
        }

        public String getFromPort() {
            return FromPort;
        }

        public void setFromPort(String FromPort) {
            this.FromPort = FromPort;
        }

        public String getToCountryID() {
            return ToCountryID;
        }

        public void setToCountryID(String ToCountryID) {
            this.ToCountryID = ToCountryID;
        }

        public String getToPort() {
            return ToPort;
        }

        public void setToPort(String ToPort) {
            this.ToPort = ToPort;
        }

        public String getClearBorder() {
            return ClearBorder;
        }

        public void setClearBorder(String ClearBorder) {
            this.ClearBorder = ClearBorder;
        }

        public String getDeliveryNo() {
            return DeliveryNo;
        }

        public void setDeliveryNo(String DeliveryNo) {
            this.DeliveryNo = DeliveryNo;
        }

        public String getPlateNo() {
            return PlateNo;
        }

        public void setPlateNo(String PlateNo) {
            this.PlateNo = PlateNo;
        }

        public String getDriver() {
            return Driver;
        }

        public void setDriver(String Driver) {
            this.Driver = Driver;
        }

        public String getPhoneNo() {
            return PhoneNo;
        }

        public void setPhoneNo(String PhoneNo) {
            this.PhoneNo = PhoneNo;
        }

        public String getNotes() {
            return Notes;
        }

        public void setNotes(String Notes) {
            this.Notes = Notes;
        }

        public String getVolumeTotal() {
            return VolumeTotal;
        }

        public void setVolumeTotal(String VolumeTotal) {
            this.VolumeTotal = VolumeTotal;
        }

        public String getWeightTotal() {
            return WeightTotal;
        }

        public void setWeightTotal(String WeightTotal) {
            this.WeightTotal = WeightTotal;
        }

        public String getQBalesTotal() {
            return QBalesTotal;
        }

        public void setQBalesTotal(String QBalesTotal) {
            this.QBalesTotal = QBalesTotal;
        }

        public List<GoodsListBean> getGoodsList() {
            return GoodsList;
        }

        public void setGoodsList(List<GoodsListBean> GoodsList) {
            this.GoodsList = GoodsList;
        }

        public static class GoodsListBean {
            /**
             * TexType : IsFlower
             * Container : [{"ContainerNo":"PCIU1766670","ContainerList":[{"PIGLID":4127,"PIID":"171","BGLID":"1530","QBales":1,"InDate":"2020-09-02","BLNo":"NGNT01718100","ContainerNo":"PCIU1766670","OrderNo":"SF191206A","VolumeUnit":"0.1000","WeightUnit":"72.0000","MetersPerBale":"600.0000","MetersPerBaleUnitID":"1","TexID_01":"479","TexType":"IsFlower","TexName_Show":"SF","UnitName":"码","UnitNameEN":"y"},{"PIGLID":4124,"PIID":"171","BGLID":"1531","QBales":2,"InDate":"2020-09-02","BLNo":"NGNT01718100","ContainerNo":"PCIU1766670","OrderNo":"SF191207A","VolumeUnit":"0.1000","WeightUnit":"73.0000","MetersPerBale":"600.0000","MetersPerBaleUnitID":"1","TexID_01":"479","TexType":"IsFlower","TexName_Show":"SF","UnitName":"码","UnitNameEN":"y"}]}]
             */
            private String TexType;
            private List<ContainerBean> Container;

            public String getTexType() {
                return TexType;
            }

            public void setTexType(String TexType) {
                this.TexType = TexType;
            }

            public List<ContainerBean> getContainer() {
                return Container;
            }

            public void setContainer(List<ContainerBean> Container) {
                this.Container = Container;
            }

            public static class ContainerBean {
                /**
                 * ContainerNo : PCIU1766670
                 * ContainerList : [{"PIGLID":4127,"PIID":"171","BGLID":"1530","QBales":1,"InDate":"2020-09-02","BLNo":"NGNT01718100","ContainerNo":"PCIU1766670","OrderNo":"SF191206A","VolumeUnit":"0.1000","WeightUnit":"72.0000","MetersPerBale":"600.0000","MetersPerBaleUnitID":"1","TexID_01":"479","TexType":"IsFlower","TexName_Show":"SF","UnitName":"码","UnitNameEN":"y"},{"PIGLID":4124,"PIID":"171","BGLID":"1531","QBales":2,"InDate":"2020-09-02","BLNo":"NGNT01718100","ContainerNo":"PCIU1766670","OrderNo":"SF191207A","VolumeUnit":"0.1000","WeightUnit":"73.0000","MetersPerBale":"600.0000","MetersPerBaleUnitID":"1","TexID_01":"479","TexType":"IsFlower","TexName_Show":"SF","UnitName":"码","UnitNameEN":"y"}]
                 */

                private String ContainerNo;
                private List<ContainerListBean> ContainerList;

                public String getContainerNo() {
                    return ContainerNo;
                }

                public void setContainerNo(String ContainerNo) {
                    this.ContainerNo = ContainerNo;
                }

                public List<ContainerListBean> getContainerList() {
                    return ContainerList;
                }

                public void setContainerList(List<ContainerListBean> ContainerList) {
                    this.ContainerList = ContainerList;
                }

                public static class ContainerListBean {
                    /**
                     * PIGLID : 4127
                     * PIID : 171
                     * BGLID : 1530
                     * QBales : 1
                     * InDate : 2020-09-02
                     * BLNo : NGNT01718100
                     * ContainerNo : PCIU1766670
                     * OrderNo : SF191206A
                     * VolumeUnit : 0.1000
                     * WeightUnit : 72.0000
                     * MetersPerBale : 600.0000
                     * MetersPerBaleUnitID : 1
                     * TexID_01 : 479
                     * TexType : IsFlower
                     * TexName_Show : SF
                     * UnitName : 码
                     * UnitNameEN : y
                     */
                    private int PIGLID;
                    private String PIID;
                    private String BGLID;
                    private int QBales;
                    private String InDate;
                    private String BLNo;
                    private String ContainerNo;
                    private String OrderNo;
                    private String VolumeUnit;
                    private String WeightUnit;
                    private String MetersPerBale;
                    private String MetersPerBaleUnitID;
                    private String TexID_01;
                    private String TexType;
                    private String TexName_Show;
                    private String UnitName;
                    private String UnitNameEN;
                    private List<SpecBean> specBean;

                    public int getPIGLID() {
                        return PIGLID;
                    }

                    public void setPIGLID(int PIGLID) {
                        this.PIGLID = PIGLID;
                    }

                    public String getPIID() {
                        return PIID;
                    }

                    public void setPIID(String PIID) {
                        this.PIID = PIID;
                    }

                    public String getBGLID() {
                        return BGLID;
                    }

                    public void setBGLID(String BGLID) {
                        this.BGLID = BGLID;
                    }

                    public int getQBales() {
                        return QBales;
                    }

                    public void setQBales(int QBales) {
                        this.QBales = QBales;
                    }

                    public String getInDate() {
                        return InDate;
                    }

                    public void setInDate(String InDate) {
                        this.InDate = InDate;
                    }

                    public String getBLNo() {
                        return BLNo;
                    }

                    public void setBLNo(String BLNo) {
                        this.BLNo = BLNo;
                    }

                    public String getContainerNo() {
                        return ContainerNo;
                    }

                    public void setContainerNo(String ContainerNo) {
                        this.ContainerNo = ContainerNo;
                    }

                    public String getOrderNo() {
                        return OrderNo;
                    }

                    public void setOrderNo(String OrderNo) {
                        this.OrderNo = OrderNo;
                    }

                    public String getVolumeUnit() {
                        return VolumeUnit;
                    }

                    public void setVolumeUnit(String VolumeUnit) {
                        this.VolumeUnit = VolumeUnit;
                    }

                    public String getWeightUnit() {
                        return WeightUnit;
                    }

                    public void setWeightUnit(String WeightUnit) {
                        this.WeightUnit = WeightUnit;
                    }

                    public String getMetersPerBale() {
                        return MetersPerBale;
                    }

                    public void setMetersPerBale(String MetersPerBale) {
                        this.MetersPerBale = MetersPerBale;
                    }

                    public String getMetersPerBaleUnitID() {
                        return MetersPerBaleUnitID;
                    }

                    public void setMetersPerBaleUnitID(String MetersPerBaleUnitID) {
                        this.MetersPerBaleUnitID = MetersPerBaleUnitID;
                    }

                    public String getTexID_01() {
                        return TexID_01;
                    }

                    public void setTexID_01(String TexID_01) {
                        this.TexID_01 = TexID_01;
                    }

                    public String getTexType() {
                        return TexType;
                    }

                    public void setTexType(String TexType) {
                        this.TexType = TexType;
                    }

                    public String getTexName_Show() {
                        return TexName_Show;
                    }

                    public void setTexName_Show(String TexName_Show) {
                        this.TexName_Show = TexName_Show;
                    }

                    public String getUnitName() {
                        return UnitName;
                    }

                    public void setUnitName(String UnitName) {
                        this.UnitName = UnitName;
                    }

                    public String getUnitNameEN() {
                        return UnitNameEN;
                    }

                    public void setUnitNameEN(String UnitNameEN) {
                        this.UnitNameEN = UnitNameEN;
                    }

                    public List<SpecBean> getSpecBean() {
                        return specBean;
                    }

                    public void setSpecBean(List<SpecBean> specBean) {
                        this.specBean = specBean;
                    }

                    public static class SpecBean {
                        private String brand_name, color_name, item_name;
                        private int bales, meters_per_bale, qsum;

                        public String getBrand_name() {
                            return brand_name;
                        }

                        public void setBrand_name(String brand_name) {
                            this.brand_name = brand_name;
                        }

                        public String getColor_name() {
                            return color_name;
                        }

                        public void setColor_name(String color_name) {
                            this.color_name = color_name;
                        }

                        public String getItem_name() {
                            return item_name;
                        }

                        public void setItem_name(String item_name) {
                            this.item_name = item_name;
                        }

                        public int getBales() {
                            return bales;
                        }

                        public void setBales(int bales) {
                            this.bales = bales;
                        }

                        public int getMeters_per_bale() {
                            return meters_per_bale;
                        }

                        public void setMeters_per_bale(int meters_per_bale) {
                            this.meters_per_bale = meters_per_bale;
                        }

                        public int getQsum() {
                            return qsum;
                        }

                        public void setQsum(int qsum) {
                            this.qsum = qsum;
                        }
                    }
                }
            }
        }
    }
}
