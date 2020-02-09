package jxwy.mwl.mongo;


import jxwy.mwl.mongo.entity.CorpLKLFaceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Field;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("corp")
public class CorpLKLFaceInfoController {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping
    public List<CorpLKLFaceInfo> find(
            @RequestParam(value = "establishTime", required = false, defaultValue = "") Long establishTime,
            @RequestParam(value = "companyScale", required = false, defaultValue = "") Integer companyScale
    ) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("esDate").gte(establishTime);
        query.addCriteria(criteria);
        query.fields().include("entName");
        List<CorpLKLFaceInfo> corpLKLFaceInfos = mongoTemplate.find(query, CorpLKLFaceInfo.class);
        return corpLKLFaceInfos;

    }

}
