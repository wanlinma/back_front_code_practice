package jxwy.mwl.mongo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document("corp_lkl_faceinfo")
@ToString
@Data
@EqualsAndHashCode(callSuper = false)
public class CorpLKLFaceInfo {

    @Field("entName")
    String entName;
    @Field("entStatus")
    String entStatus;
}
