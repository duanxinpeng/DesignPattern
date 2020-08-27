package com.upincar.dms;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, String> jw = randomLonLat(85, 122, 29, 116);
        System.out.println(jw.get("J") + "," + jw.get("W"));
    }

    /**
     * @Description: 在矩形内随机生成经纬度
     * @param MinLon：最小经度
     * 		  MaxLon： 最大经度
     *  	  MinLat：最小纬度
     * 		  MaxLat：最大纬度
     * @return @throws
     */
    public static Map<String, String> randomLonLat(double MinLon, double MaxLon, double MinLat, double MaxLat) {
        BigDecimal db = new BigDecimal(Math.random() * (MaxLon - MinLon) + MinLon);
        String lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();// 小数后6位
        db = new BigDecimal(Math.random() * (MaxLat - MinLat) + MinLat);
        String lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
        Map<String, String> map = new HashMap<String, String>();
        map.put("J", lon);
        map.put("W", lat);
        return map;
    }
}
