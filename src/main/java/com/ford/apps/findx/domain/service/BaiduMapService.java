
package com.ford.apps.findx.domain.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.ford.apps.findx.common.constant.AppConstant;
import com.ford.apps.findx.data.dao.LocationPointMapper;
import com.ford.apps.findx.data.entity.LocationPoint;
import com.ford.apps.findx.domain.model.MapResult;

@Service
public class BaiduMapService {

	@Value("${baidu-ak}")
	private String BAIDU_AK = null;

	@Autowired
	private LocationPointMapper locationPointMapper = null;

	@Transactional
	public List<LocationPoint> searchOnPurpose(String lat, String lng, String query, String username) {
		RestTemplate restTemplate = new RestTemplate();
		String url2 = AppConstant.BAIDU_MAP_SEARCH_API_HEAD_PART
			+ "?query=" + query + "&location=" + lat + "," + lng
			+ "&radius=" + AppConstant.BAIDU_MAP_SEARCH_RADIUS
			+ "&output=json&ak=" + BAIDU_AK;
		ResponseEntity<String> res2 = restTemplate.getForEntity(url2, String.class);
		String info = res2.getBody();
		MapResult mapResult = JSON.parseObject(info, MapResult.class);
		List<LocationPoint> lps = mapResult.getResults().stream()
			.map(p -> new LocationPoint(0, p.getName(), p.getAddress(), p.getProvince(), p.getCity(),
				p.getArea(), p.getStreet_id(), username, (new Date()))).collect(Collectors.toList());
		locationPointMapper.insertBatch(lps);
		return lps;
	}

	@Transactional(readOnly=true)
	public List<LocationPoint> getTops() {
		List<LocationPoint> lps = locationPointMapper.findTops();
		return lps;
	}
}