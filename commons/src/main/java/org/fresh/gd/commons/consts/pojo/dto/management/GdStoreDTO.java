package org.fresh.gd.commons.consts.pojo.dto.management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * @DATA 2019-04-12 10:31
 * @Author 张国伟  WeChat:17630376104
 * @Description
 */
@ApiModel("门店信息数据模型")
@Data
public class GdStoreDTO {

    @ApiModelProperty("店铺ID")
    private Integer storeid;


    @ApiModelProperty("店铺名称")
    private String storename;

    @ApiModelProperty("店铺地址")
    private String storeaddress;

    @ApiModelProperty("图片链接")
    private String storeImagesUri;

    @ApiModelProperty("图片文件")
    private MultipartFile multipartFile;

    @ApiModelProperty("图片File文件")
    private File file;

    private List<ManageStoreDTO> manageStoreDTOList;
}
